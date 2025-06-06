package com.example.habito1;

import android.content.Context;
import android.view.*;
import android.widget.*;
import java.util.List;

public class HabitoAdapter extends BaseAdapter {

    private Context context;
    private List<Habito> habitos;

    public HabitoAdapter(Context context, List<Habito> habitos) {
        this.context = context;
        this.habitos = habitos;
    }

    @Override
    public int getCount() {
        return habitos.size();
    }

    @Override
    public Object getItem(int position) {
        return habitos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_habito, parent, false);
        TextView textNome = view.findViewById(R.id.textNome);
        TextView textDescricao = view.findViewById(R.id.textDescricao);

        Habito habito = habitos.get(position);
        textNome.setText(habito.getNome());
        textDescricao.setText(habito.getDescricao());

        return view;
    }
}
