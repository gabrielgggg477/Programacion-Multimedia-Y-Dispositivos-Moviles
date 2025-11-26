package com.example.listacompra;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ShoppingListAdapter extends BaseAdapter {

    private Context context;
    private List<Item> items;

    public ShoppingListAdapter(Context context, List<Item> items) {
        this.context = context;
        this.items = items;
    }

    @Override
    public int getCount() { return items.size(); }

    @Override
    public Object getItem(int position) { return items.get(position); }

    @Override
    public long getItemId(int position) { return position; }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_shopping, parent, false);
        }

        Item item = items.get(position);

        ImageView imgItem = convertView.findViewById(R.id.imgItem);
        TextView tvNombre = convertView.findViewById(R.id.tvNombre);
        TextView tvCantidad = convertView.findViewById(R.id.tvCantidad);
        Button btnEliminar = convertView.findViewById(R.id.btnEliminar);

        imgItem.setImageResource(item.getImagenResId());
        tvNombre.setText(item.getNombre());
        tvCantidad.setText(context.getString(R.string.cantidad_text, item.getCantidad()));

        btnEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                items.remove(position);
                notifyDataSetChanged();
            }
        });

        return convertView;
    }
}
