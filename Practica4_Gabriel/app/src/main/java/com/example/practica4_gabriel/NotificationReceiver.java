package com.example.practica4_gabriel;

import android.Manifest;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;

import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

public class NotificationReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        String nombre = intent.getStringExtra("nombre");
        String fecha = intent.getStringExtra("fecha");
        String hora = intent.getStringExtra("hora");

        // Intent para abrir MainActivity al pulsar la notificación
        Intent abrirApp = new Intent(context, MainActivity.class);
        abrirApp.putExtra("nombre", nombre);
        abrirApp.putExtra("fecha", fecha);
        abrirApp.putExtra("hora", hora);

        PendingIntent pendingIntent = PendingIntent.getActivity(
                context,
                0,
                abrirApp,
                PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_IMMUTABLE
        );

        // Crear canal si no existe (por seguridad)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel canal = new NotificationChannel(
                    "eventos",
                    "Eventos",
                    NotificationManager.IMPORTANCE_HIGH
            );

            NotificationManager manager = context.getSystemService(NotificationManager.class);
            manager.createNotificationChannel(canal);
        }

        Notification notification = new NotificationCompat.Builder(context, "eventos")
                .setSmallIcon(R.drawable.icono)
                .setContentTitle("Recordatorio de evento")
                .setContentText(nombre + " - " + fecha + " " + hora)
                .setAutoCancel(true)
                .setContentIntent(pendingIntent)
                .build();

        if (ActivityCompat.checkSelfPermission(
                context,
                Manifest.permission.POST_NOTIFICATIONS
        ) != PackageManager.PERMISSION_GRANTED) {
            return;
        }

        NotificationManagerCompat.from(context)
                .notify((int) System.currentTimeMillis(), notification);
    }
}
