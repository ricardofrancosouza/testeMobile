package com.brasilmilk.crud.DAO;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.icu.util.ULocale;
import android.util.Log;

import com.brasilmilk.crud.Helper.SQLiteHelper;
import com.brasilmilk.crud.ModelVendedor;
import com.brasilmilk.crud.Util.Util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ricar on 20/11/2017.
 */

public abstract class AbstratroDAO {




    public void close(final SQLiteDatabase db){
        if(db != null){
            if(!db.isOpen()){
                db.close();
            }
        }
    }
    public ContentValues contentCreate (Object obj){
        ContentValues values = new ContentValues();
        HashMap<String, String> mapKey = Util.getColumKey(obj);
        for(Map.Entry<String, String> entry : mapKey.entrySet()){
            String tipoRetorno = Util.getTipReturnMethod(obj, entry.getValue());
            switch (tipoRetorno){
                case "String":
                    values.put(entry.getKey(), (String) Util.getValueMethod(obj, entry.getValue()));
                    break;
                case "boolean":
                    values.put(entry.getKey(), (Boolean) Util.getValueMethod(obj, entry.getValue()));
                    break;
                case "Byte":
                    values.put(entry.getKey(), (Byte) Util.getValueMethod(obj, entry.getValue()));
                    break;
                case "Double":
                    values.put(entry.getKey(), (Double) Util.getValueMethod(obj, entry.getValue()));
                    break;
                case "Float":
                    values.put(entry.getKey(), (Float) Util.getValueMethod(obj, entry.getValue()));
                    break;
                case "Integer":
                    values.put(entry.getKey(), (Integer) Util.getValueMethod(obj, entry.getValue()));
                    break;
                case "Long":
                    values.put(entry.getKey(), (Long) Util.getValueMethod(obj, entry.getValue()));
                    break;
                case "Short":
                    values.put(entry.getKey(), (Short) Util.getValueMethod(obj, entry.getValue()));
                    break;

            }

        }
        return  values;
    }
    public Integer insert(final Object obj, final SQLiteDatabase db){
        Integer id = 0;
        try {
            ContentValues values = contentCreate(obj);
            long id2 = db.insert(Util.getNomeTabela(obj),null,values);
            id = Integer.valueOf(String.valueOf(id2));

        }catch (Exception e){
            Log.e("Erro: ", e.getMessage());
        }
        return id;
    }

    public boolean delete(final SQLiteDatabase db, final Class<?> obj, List<String>atributosDeleteList, String[] parametros){
        boolean resultadoExclusao= false;
        try {
            StringBuilder whereBuilder = new StringBuilder();
            int cont = 0;
            for(String atributo : atributosDeleteList){
                if(cont > 1){
                    whereBuilder.append(" AND ");
                }
                whereBuilder.append(atributo);
                whereBuilder.append(" = ?");
                cont ++;
            }
            String where = whereBuilder.toString();
            String[] args = parametros;
            int num = db.delete(Util.getNomeTabela(obj), where, args);
            if(num == 1){
                resultadoExclusao = true;
            }
        }catch (Exception e){
            Log.e("Erro: ", e.getMessage());
        }
        return resultadoExclusao;
    }

    public boolean edit(final SQLiteDatabase db, final Object obj, List<String>atributosEditList, String[] parametros){
        boolean resultadoAlteracao = false;
        try {
            StringBuilder whereBuilder = new StringBuilder();
            int cont = 0;
            for(String atributo : atributosEditList){
                if(cont > 1){
                    whereBuilder.append(" AND ");
                }
                whereBuilder.append(atributo);
                whereBuilder.append(" = ? ");
                cont++;
            }
            String where = whereBuilder.toString();
            String[]args = parametros;
            int num = db.update(Util.getNomeTabela(obj), contentCreate(obj), where,args);
            if(num == 1){
                resultadoAlteracao = true;
            }
        } catch (Exception e){
            Log.e("Erro: ", e.toString());
        }
        return resultadoAlteracao;
    }

    public static List<?> getAll(final SQLiteDatabase db, final Class<?> clazz){
        Cursor cursor = null;
        List<Object> listaObjs = new ArrayList<>();

        try {
            StringBuilder orderByBuilder = new StringBuilder();
            orderByBuilder.append(Util.getPrimaryKey(clazz));
            orderByBuilder.append(" DESC");
            cursor = db.query(Util.getNomeTabela(clazz), Util.getColumView(clazz), null,null,null,null,
                    orderByBuilder.toString(),null);
            if(cursor.getCount()>0){
                HashMap<String, String> mapKey = Util.getColumSet(clazz);
                while (cursor.moveToNext()){
                    Object objLinha = Util.createNewInstance(clazz);
                    for(Map.Entry<String, String> entry : mapKey.entrySet()){
                       Util.setValueAtributoByCursor(entry.getKey(), entry.getValue(), cursor, clazz, objLinha );
                    }
                    listaObjs.add(objLinha);
                }
            }
        }catch (Exception e){
            Log.e("Erro: ",e.getMessage());
        }
        finally {
            if(cursor != null){
                if(!cursor.isClosed()){
                    cursor.close();
                }
            }
        }
        return listaObjs;
    }
    public static Object getByParam(final SQLiteDatabase db, final Class<?> clazz, List<String> atributosWhere, String[] parametros ){
        Cursor cursor = null;
        StringBuilder whereBuilder = new StringBuilder();
        int cont = 0;
        for(String atributo : atributosWhere){
            if(cont > 1){
                whereBuilder.append(" AND ");
            }
            whereBuilder.append(atributo);
            whereBuilder.append(" = ? ");
            cont++;
        }
        String where = whereBuilder.toString();
        String[]args = parametros;
        try {
           Object objReturn = Util.createNewInstance(clazz);
            cursor = db.query(Util.getNomeTabela(clazz), Util.getColumView(clazz), where, args, null, null, null);
            if(cursor.getCount() > 0){
                HashMap<String, String> mapSet = Util.getColumSet(clazz);
                while (cursor.moveToNext()){
                    for(Map.Entry<String, String> entry : mapSet.entrySet()){
                        Util.setValueAtributoByCursor(entry.getKey(), entry.getValue(), cursor, clazz, objReturn );
                    }
                }
                return objReturn;
            }

        }catch (Exception e){
            Log.e("Erro: ", e.toString());
        }finally {
            if(cursor != null){
                if(!cursor.isClosed()){
                    cursor.close();
                }

            }
        }
        return null;
    }

}

