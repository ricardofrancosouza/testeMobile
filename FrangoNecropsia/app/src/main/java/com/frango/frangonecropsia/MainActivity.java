package com.frango.frangonecropsia;

import android.app.AlertDialog;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

import com.frango.frangonecropsia.adaptador.AdapterOrgaos;
import com.frango.frangonecropsia.model.Frango;
import com.frango.frangonecropsia.util.Orgaos;
import com.frango.frangonecropsia.util.RequisicaoWebService;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private Button btnAnalisar, btnReset;
    private GridView gridView;
    private ListView listView;
    private Frango frango;
    private AdapterOrgaos adapterOrgaos;
    Orgaos orgaosList;
    private Gson gson;
    private AlertDialog alerta;
    List<String> listItens;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        frango = new Frango();
        gson = new Gson();
        orgaosList = new Orgaos();
        carregaListaItens();
        listView = (ListView) findViewById(R.id.listView);
        btnAnalisar = (Button) findViewById(R.id.btnAnalisar);
        btnReset = (Button) findViewById(R.id.btnResetar);
        adapterOrgaos = new AdapterOrgaos(this, listItens, frango);
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                frango = new Frango();
                adapterOrgaos = new AdapterOrgaos(MainActivity.this, listItens,frango);
                listView.removeAllViewsInLayout();
                listView.setAdapter(adapterOrgaos);
            }
        });


        listView.setAdapter(adapterOrgaos);
        btnAnalisar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LayoutInflater li = getLayoutInflater();
                final View viewPossiveisCausas = li.inflate(R.layout.possiveis_causas_list, null);
                RequisicaoWebService rw = new RequisicaoWebService();

                try {
                    //inflamos o layout alerta.xml na view
                    String[] causaList = rw.getAnalise(gson.toJson(frango));

                    ArrayAdapter<String> possiveisCausasAdapt =  new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_expandable_list_item_1, causaList);
                    ListView listViewPCausas = viewPossiveisCausas.findViewById(R.id.listViewPCausas);
                    listViewPCausas.setAdapter(possiveisCausasAdapt);
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setTitle("Possiveis Causas");
                    builder.setView(viewPossiveisCausas);
                    alerta = builder.create();
                    alerta.show();
                    Button btnOk = viewPossiveisCausas.findViewById(R.id.btnOk);
                    btnOk.setOnClickListener(new View.OnClickListener() {

                        @Override
                        public void onClick(View view) {
                            alerta.dismiss();
                        }
                    });

                } catch (Exception e) {
                    Log.e("Erro: ", e.getMessage());
                }
            }
        });
    }

    private void carregaListaItens() {
        listItens = new ArrayList<>();
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
    }

}
