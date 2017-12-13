package com.frango.frangonecropsia.util;

import android.util.Log;


import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by ricar on 12/12/2017.
 */

public class RequisicaoWebService  {
    public String post(String json) throws IOException {

        OkHttpClient client = new OkHttpClient();

        String url = "http://www.umsitequalquer.com.br/fazPost";

        Request.Builder builder = new Request.Builder();

        builder.url(url);

        MediaType mediaType =
                MediaType.parse("application/json; charset=utf-8");

        RequestBody body = RequestBody.create(mediaType, json);
        builder.post(body);

        Request request = builder.build();

        Response response = client.newCall(request).execute();

        String jsonDeResposta = response.body().string();

        return jsonDeResposta;

    }
    public String[] getAnalise(String json) {
        OkHttpClient client = new OkHttpClient();
        List<String> possiveisCausasList = new ArrayList<>();
        String url = "http://192.168.1.6:8080/frango/necropsia/doencas1";
        Gson gson;

        Request.Builder builder = new Request.Builder();
        String[] possiveisCausasVet = null;
        gson = new Gson();
        try {
            builder.url(url);

            MediaType mediaType = MediaType.parse("application/json; charset=utf-8");

            RequestBody body = RequestBody.create(mediaType, json);
            builder.post(body);
            Request request = builder.build();

            Response response = client.newCall(request).execute();

            String jsonDeResposta = response.body().string();
            String aux;
            possiveisCausasVet = new String[5];
            if(jsonDeResposta.length() >11) {
                aux = jsonDeResposta.substring(jsonDeResposta.indexOf("[")+1, jsonDeResposta.indexOf("]"));
                for (int i = 0; i < 5; i++) {
                    try {
                        possiveisCausasVet[i] = aux.substring(aux.indexOf("F"), aux.indexOf(","));
                        aux = aux.substring(aux.indexOf(",")+1, aux.length());
                    } catch (Exception e) {
                        possiveisCausasVet[i] = aux.substring(aux.indexOf("F"), aux.length());
                    }
                }
            }


        }catch (IOException e){
            Log.e("Erro: ", e.getMessage());
        }
        return possiveisCausasVet;
    }
    public String get() throws IOException {

        String url = "http://192.168.1.6:8080/frango/necropsia/doencas1";

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder().url(url).build();

        Response response = client.newCall(request).execute();

        String jsonDeResposta = response.body().string();

        return jsonDeResposta;
    }
}

