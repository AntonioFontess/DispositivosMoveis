package com.example.habito1;

import android.content.Context;
import android.view.*;
import android.widget.*;
import com.example.habito1.model.RegistroHabito;

import java.time.format.DateTimeFormatter;
import java.util.List;

public class RegistroAdapter extends ArrayAdapter<RegistroHabito> {

    public RegistroAdapter(Context context, List<RegistroHabito> registros) {
        super(context, 0, registros);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        RegistroHabito registro = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_registro, parent, false);
        }

        TextView tvData = convertView.findViewById(R.id.tvData);
        TextView tvStatus = convertView.findViewById(R.id.tvStatus);

        tvData.setText(registro.getData().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        tvStatus.setText(registro.isStatus() ? "Concluído" : "Não concluído");

        return convertView;
    }
}
