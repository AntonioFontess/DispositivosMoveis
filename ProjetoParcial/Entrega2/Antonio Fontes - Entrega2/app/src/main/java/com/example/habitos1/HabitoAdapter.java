package com.example.habitos1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.ArrayList;

public class HabitoAdapter extends ArrayAdapter<Habito> {

    public HabitoAdapter(Context context, ArrayList<Habito> habitos) {
        super(context, 0, habitos);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Habito habito = getItem(position);

        ViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext())
                    .inflate(R.layout.item_habito, parent, false);

            holder = new ViewHolder();
            holder.tvNome = convertView.findViewById(R.id.textNome);
            holder.tvDescricao = convertView.findViewById(R.id.textDescricao);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.tvNome.setText(habito.getNome());
        holder.tvDescricao.setText(habito.getDescricao());

        return convertView;
    }

    static class ViewHolder {
        TextView tvNome;
        TextView tvDescricao;
    }
}