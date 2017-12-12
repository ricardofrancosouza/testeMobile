package com.frango.frangonecropsia;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;

import com.frango.frangonecropsia.adaptador.AdapterOrgaos;
import com.frango.frangonecropsia.model.Frango;
import com.frango.frangonecropsia.util.Orgaos;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private GridView gridView;
    private ListView listView;
    private Frango frango;
    private AdapterOrgaos adapterOrgaos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        frango = new Frango();
        Orgaos orgaosList = new Orgaos();
        List<String> listItens = new ArrayList<>();
        for(int i = 0; i<7;i++){
            switch (i){
                case 0:
                    listItens.addAll(orgaosList.getOrgaoMap().get("PROVENTRICULO"));
                    break;
                case 1:
                    listItens.addAll(orgaosList.getOrgaoMap().get("INTESTINO"));
                    break;
                case 2:
                    listItens.addAll(orgaosList.getOrgaoMap().get("TRAQUEIA"));
                    break;
                case 3:
                    listItens.addAll(orgaosList.getOrgaoMap().get("PULMOES"));
                    break;
                case 4:
                    listItens.addAll(orgaosList.getOrgaoMap().get("SACOS AEREOS"));
                    break;
                case 5:
                    listItens.addAll(orgaosList.getOrgaoMap().get("CLOACA"));
                    break;
                case 6:
                    listItens.addAll(orgaosList.getOrgaoMap().get("FIGADO"));
                    break;
            }
        }

        listView = findViewById(R.id.listView);
        adapterOrgaos = new AdapterOrgaos(this, listItens, frango);
        listView.setAdapter(adapterOrgaos);


    }
}
