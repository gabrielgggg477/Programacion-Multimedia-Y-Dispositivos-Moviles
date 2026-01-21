package com.example.practica4_gabriel;

import android.Manifest;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    Button btnAgregar;
    ListView listEventos;
    ArrayList<Evento> eventos;
    ArrayAdapter<String> adapter;

    String fechaSeleccionada = "";
    String horaSeleccionada = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAgregar = findViewById(R.id.btnAgregar);
        listEventos = findViewById(R.id.listEventos);

        eventos = new ArrayList<>();

        adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                new ArrayList<>()
        );

        listEventos.setAdapter(adapter);

        btnAgregar.setOnClickListener(v -> mostrarDialogoEvento());

        listEventos.setOnItemClickListener((parent, view, position, id) ->
                mostrarSnackbar(view, eventos.get(position))
        );

        solicitarPermisoNotificaciones();
    }

    private void mostrarDialogoEvento() {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Nuevo evento");

        EditText input = new EditText(this);
        input.setHint("Nombre del evento");
        builder.setView(input);

        builder.setPositiveButton("Siguiente", (dialog, which) -> {
            String nombre = input.getText().toString();
            seleccionarFecha(nombre);
        });

        builder.setNegativeButton("Cancelar", null);
        builder.show();
    }

    private void seleccionarFecha(String nombre) {
        Calendar c = Calendar.getInstance();

        DatePickerDialog dpd = new DatePickerDialog(
                this,
                (view, year, month, day) -> {
                    fechaSeleccionada = day + "/" + (month + 1) + "/" + year;
                    seleccionarHora(nombre);
                },
                c.get(Calendar.YEAR),
                c.get(Calendar.MONTH),
                c.get(Calendar.DAY_OF_MONTH)
        );

        dpd.show();
    }

    private void seleccionarHora(String nombre) {
        Calendar c = Calendar.getInstance();

        TimePickerDialog tpd = new TimePickerDialog(
                this,
                (view, hour, minute) -> {
                    horaSeleccionada = hour + ":" + String.format("%02d", minute);
                    agregarEvento(nombre);
                },
                c.get(Calendar.HOUR_OF_DAY),
                c.get(Calendar.MINUTE),
                true
        );

        tpd.show();
    }

    private void agregarEvento(String nombre) {

        Evento evento = new Evento(nombre, fechaSeleccionada, horaSeleccionada);
        eventos.add(evento);

        adapter.add(nombre + " - " + fechaSeleccionada + " " + horaSeleccionada);

        // Notificación inmediata
        mostrarNotificacion(evento);

        // 🔔 ALERTA 5 SEGUNDOS DESPUÉS
        mostrarAlertaConRetraso(evento);

        // Notificación programada
        programarNotificacion(evento);
    }

    private void mostrarNotificacion(Evento evento) {

        String canalId = "eventos";

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel canal = new NotificationChannel(
                    canalId,
                    "Canal Eventos",
                    NotificationManager.IMPORTANCE_DEFAULT
            );
            getSystemService(NotificationManager.class)
                    .createNotificationChannel(canal);
        }

        Intent intent = new Intent(this, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(
                this,
                0,
                intent,
                PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_IMMUTABLE
        );

        Notification notification = new NotificationCompat.Builder(this, canalId)
                .setSmallIcon(R.drawable.icono)
                .setContentTitle(evento.getNombre())
                .setContentText(evento.getFecha() + " " + evento.getHora())
                .setContentIntent(pendingIntent)
                .setAutoCancel(true)
                .build();

        if (ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.POST_NOTIFICATIONS
        ) != PackageManager.PERMISSION_GRANTED) {
            return;
        }

        NotificationManagerCompat.from(this)
                .notify((int) System.currentTimeMillis(), notification);
    }

    // ⏰ ALERTA CON RETRASO DE 5 SEGUNDOS
    private void mostrarAlertaConRetraso(Evento evento) {

        new Handler(Looper.getMainLooper())
                .postDelayed(() -> {

                    new AlertDialog.Builder(MainActivity.this)
                            .setTitle("⏰ Recordatorio")
                            .setMessage(
                                    "Evento: " + evento.getNombre() + "\n" +
                                            "Fecha y hora: " +
                                            evento.getFecha() + " " + evento.getHora()
                            )
                            .setPositiveButton("OK", null)
                            .show();

                }, 5000);
    }

    private void mostrarSnackbar(View view, Evento evento) {

        Snackbar.make(
                view,
                evento.getNombre() + "\n" +
                        evento.getFecha() + " " + evento.getHora(),
                Snackbar.LENGTH_LONG
        ).show();
    }

    private void solicitarPermisoNotificaciones() {

        if (Build.VERSION.SDK_INT >= 33) {
            if (checkSelfPermission(
                    Manifest.permission.POST_NOTIFICATIONS)
                    != PackageManager.PERMISSION_GRANTED) {

                requestPermissions(
                        new String[]{Manifest.permission.POST_NOTIFICATIONS},
                        1
                );
            }
        }
    }

    private void programarNotificacion(Evento evento) {

        Calendar calendar = Calendar.getInstance();

        String[] fecha = evento.getFecha().split("/");
        String[] hora = evento.getHora().split(":");

        calendar.set(
                Integer.parseInt(fecha[2]),
                Integer.parseInt(fecha[1]) - 1,
                Integer.parseInt(fecha[0]),
                Integer.parseInt(hora[0]),
                Integer.parseInt(hora[1])
        );

        Intent intent = new Intent(this, NotificationReceiver.class);
        intent.putExtra("nombre", evento.getNombre());
        intent.putExtra("fechaHora",
                evento.getFecha() + " " + evento.getHora());

        PendingIntent pendingIntent = PendingIntent.getBroadcast(
                this,
                (int) System.currentTimeMillis(),
                intent,
                PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_IMMUTABLE
        );

        android.app.AlarmManager alarmManager =
                (android.app.AlarmManager) getSystemService(ALARM_SERVICE);

        if (alarmManager != null) {
            alarmManager.set(
                    android.app.AlarmManager.RTC_WAKEUP,
                    calendar.getTimeInMillis(),
                    pendingIntent
            );
        }
    }
}
