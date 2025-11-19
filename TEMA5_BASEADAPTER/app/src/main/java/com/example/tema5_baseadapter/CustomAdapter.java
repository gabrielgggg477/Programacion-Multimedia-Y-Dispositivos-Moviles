package com.example.tema5_baseadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.List;

public class CustomAdapter extends BaseAdapter {
    private Context context;
    private List<ListItem> items;
    private int selectedPosition = -1;


    public CustomAdapter(Context context, List<ListItem> items){
        this.context = context;
        this.items = items;
    }
    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false );
        }
        ImageView imageView = convertView.findViewById(R.id.itemImage);
        TextView titleView = convertView.findViewById(R.id.itemTitle);
        TextView contentView = convertView.findViewById(R.id.itemContent);
        RadioButton radioButton = convertView.findViewById(R.id.itemRadio);
        ListItem item = items.get(position);
        imageView.setImageResource(item.getImageResId());
        titleView.setText(item.getTitle());
        contentView.setText(item.getContent());
        radioButton.setChecked(position == selectedPosition);
        radioButton.setOnClickListener(v -> {
            selectedPosition = position;
            notifyDataSetChanged();
        });
        return null;
    }
}
