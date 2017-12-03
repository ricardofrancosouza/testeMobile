package com.teste.testemapa;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * A simple {@link Fragment} subclass.
 */
public class ExemploProvaiderFragmentV1 extends SupportMapFragment implements OnMapReadyCallback, GoogleMap.OnMapClickListener {

    private GoogleMap mMap;
    private LocationManager locationManager;
    // declaração da interface de comunicação
    public interface InterfaceComunicao {

        // aqui, um ou mais métodos de comunicação
        void setIdade(String provider); // por exemplo, este método retorna a idade inserida no fragment
    }
    private InterfaceComunicao listener;
    private String provider;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        locationManager = (LocationManager) getActivity().getSystemService(Context.LOCATION_SERVICE);
        Criteria criteria = new Criteria();
        provider = locationManager.getBestProvider(criteria, true);
        testeComunicacao(provider);
        try {

        mMap = googleMap;
        mMap.setOnMapClickListener(this);
        mMap.getUiSettings().setZoomControlsEnabled(true);

        mMap.setMyLocationEnabled(true);
        }catch (SecurityException e){
            Log.e("Erro:", e.getMessage());
        }

        // Add a marker in Sydney and move the camera
       @SuppressLint("MissingPermission") Location location =  locationManager.getLastKnownLocation(provider);
        LatLng sydney = new LatLng(location.getLatitude(), location.getLongitude());
        MarkerOptions marker = new MarkerOptions();
        marker.position(sydney);
        marker.title("Marker in Sydney");

        mMap.addMarker(marker);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }

    @Override
    public void onMapClick(LatLng latLng) {
        Toast.makeText(getContext(),"coordenadas: "+ latLng.toString(),Toast.LENGTH_SHORT).show();
    }

    /*
    onAttach faz parte do ciclo de vida do fragment, é executado
    quando o fragment é associado à activity
        */
    @Override
    public void onAttach(Activity activity) {

        super.onAttach(activity);
        if(activity instanceof InterfaceComunicao){
            listener = (InterfaceComunicao) activity;
        }else {
            Log.e("Erro", String.valueOf(new ClassCastException()));
        }
    }
    public void testeComunicacao(String link){
        /*
            - chama o método de comunicação para atualizar o valor que o usuário informou na tela
            - neste ponto, ler o valor de uma view, por exemplo TextView na tela
            - para o exemplo configuramos direto o valor 15
        */
        listener.setIdade(link);
    }
}
