package com.frango.frangonecropsia.adaptador;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.frango.frangonecropsia.R;
import com.frango.frangonecropsia.model.Frango;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by ricar on 11/12/2017.
 */

public class AdapterOrgaos extends BaseAdapter {
    private  Context ctx;
    List<String> lista;
    private Frango frango;
    public AdapterOrgaos(Context ctx, List<String> lista, final Frango frango){
        this.ctx = ctx;
        this.lista = lista;
        this.frango = frango;
    }
    @Override
    public int getCount() {
        return lista.size();
    }

    @Override
    public Object getItem(int position) {
        return lista.get(position);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }


    @Override
    public View getView(final int position, View convertView, ViewGroup viewGroup) {
        String org = lista.get(position);
        View view = LayoutInflater.from(ctx).inflate(R.layout.checklista,null);

        TextView txtView = view.findViewById(R.id.txtOrgao);
        CheckBox chk1 = view.findViewById(R.id.chk1);
        CheckBox chk2 = view.findViewById(R.id.chk2);
        CheckBox chk3 = view.findViewById(R.id.chk3);
        CheckBox chk4 = view.findViewById(R.id.chk4);
        CheckBox chk5 = view.findViewById(R.id.chk5);
        txtView.setText(lista.get(position));
        chk1.setChecked(frango.getFrango1ByPos(position));
        chk2.setChecked(frango.getFrango2ByPos(position));
        chk3.setChecked(frango.getFrango3ByPos(position));
        chk4.setChecked(frango.getFrango4ByPos(position));
        chk5.setChecked(frango.getFrango5ByPos(position));

        chk1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                frango.setFrango1(b,position);
            }
        });
        chk2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                frango.setFrango2(b,position);
            }
        });
        chk3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                frango.setFrango3(b,position);
            }
        });
        chk4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                frango.setFrango4(b,position);
            }
        });
        chk5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                frango.setFrango5(b,position);
            }
        });
        return view;
    }
}
