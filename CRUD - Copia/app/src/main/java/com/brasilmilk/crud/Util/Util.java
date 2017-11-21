package com.brasilmilk.crud.Util;

import android.database.Cursor;
import android.util.Log;


import com.brasilmilk.crud.Anotacoes.ApresentacaoAN;
import com.brasilmilk.crud.Anotacoes.AtributoAnotation;
import com.brasilmilk.crud.Anotacoes.ClassAnotation;
import com.brasilmilk.crud.Anotacoes.MetodoAnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;

/**
 * Created by ricar on 20/11/2017.
 */
public class Util {
    public static String[] getColumView(final Class<?> clazz){

        try {
            int i = 0;
            String[] colunasApresentacao = new String[clazz.getDeclaredFields().length];
            for(Field field : clazz.getDeclaredFields()){
                if(field.isAnnotationPresent(ApresentacaoAN.class)){
                    ApresentacaoAN anotation = field.getAnnotation(ApresentacaoAN.class);
                    if(anotation.apresentar()){
                        colunasApresentacao[i] = field.getName();
                        i++;
                    }
                }


            }
           return  colunasApresentacao;
        }catch (Exception e){
            Log.e("Erro: ", e.getMessage());
        }
        return  null;
    }

    public static String[] setColumn(final Object obj){
        String[] colunasApresentacao = new String[]{};
        try {
            Class<?> clazz = obj.getClass();
            int i = 0;
            for(Field field : clazz.getDeclaredFields()){
                if(field.isAnnotationPresent(ApresentacaoAN.class)){
                    ApresentacaoAN anotation = field.getAnnotation(ApresentacaoAN.class);
                    if(anotation.apresentar()){
                        colunasApresentacao[i] = field.getName();
                    }
                }
                i++;
            }
        }catch (Exception e){
            Log.e("Erro: ", e.getMessage());
        }
        return  colunasApresentacao;
    }
    public static Object createNewInstance(final Class clazz)
            throws InstantiationException, IllegalAccessException,
            InvocationTargetException {
        Constructor<?> ctor;
        try {
            ctor = clazz.getConstructors()[0];
            Object object = ctor.newInstance();
            return object;

        } catch (SecurityException | IllegalArgumentException e) {
            e.printStackTrace();

        }

        return null;
    }

    public static Object createNewInstance(Object obj)
            throws InstantiationException, IllegalAccessException,
            InvocationTargetException {
        Constructor<?> ctor;
        try {
            Class<?> clazz = obj.getClass();
            ctor = clazz.getConstructors()[0];
            Object object = ctor.newInstance();
            return object;

        } catch (SecurityException | IllegalArgumentException e) {
            e.printStackTrace();

        }

        return null;
    }


    public static HashMap<String, String> getColumKey(Object obj) {
        HashMap<String, String> mapKey = new HashMap<>();
        try {
            Class<?> clazz = obj.getClass();
            for(Field field : clazz.getDeclaredFields()){
                if(field.isAnnotationPresent(AtributoAnotation.class)){
                    AtributoAnotation anotation = field.getAnnotation(AtributoAnotation.class);
                    mapKey.put(anotation.nomeAtributo(), anotation.nomeGet());
                }
            }
        }catch (Exception e){
            Log.e("Erro: ", e.getMessage());
        }

        return mapKey;
    }
    public static HashMap<String, String> getColumSet(Class<?> clazz) {
        HashMap<String, String> mapKey = new HashMap<>();
        try {
            for(Field field : clazz.getDeclaredFields()){
                if(field.isAnnotationPresent(AtributoAnotation.class)){
                    AtributoAnotation anotation = field.getAnnotation(AtributoAnotation.class);
                    mapKey.put(anotation.nomeAtributo(), anotation.nomeSet());
                }
            }
        }catch (Exception e){
            Log.e("Erro: ", e.getMessage());
        }

        return mapKey;
    }

    public static Object getValueMethod(final Object obj, String metodo) {
        try {
            Class<?> clazz = obj.getClass();
            for(Method method : clazz.getDeclaredMethods()){
                if(method.getName().equals(metodo)){
                    if(method.isAnnotationPresent(MetodoAnotation.class)){
                        MetodoAnotation anotation = method.getAnnotation(MetodoAnotation.class);
                        return method.invoke(obj);

                    }

                }
            }
        }catch (Exception e){
            Log.e("Erro: ", e.getMessage());
        }
        return null;
    }

    public static String getTipReturnMethod(final Object obj, String metodo) {
        try {
            Class<?> clazz = obj.getClass();
            for(Method method : clazz.getDeclaredMethods()){
                if(method.getName().equals(metodo)){
                    if(method.isAnnotationPresent(MetodoAnotation.class)){
                        MetodoAnotation anotation = method.getAnnotation(MetodoAnotation.class);
                        return anotation.tipoRetorno();
                    }

                }
            }
        }catch (Exception e){
            Log.e("Erro: ", e.getMessage());
        }
        return null;
    }

    public static String getTipSETMethod(final Class<?> clazz, String metodo) {
        try {

            for(Method method : clazz.getDeclaredMethods()){
                if(method.getName().equals(metodo)){
                    if(method.isAnnotationPresent(MetodoAnotation.class)){
                        MetodoAnotation anotation = method.getAnnotation(MetodoAnotation.class);
                        return anotation.tipoSet();
                    }

                }
            }
        }catch (Exception e){
            Log.e("Erro: ", e.getMessage());
        }
        return null;
    }

    public static String getNomeTabela(final Class<?> clazz){
        try {
            if(clazz.isAnnotationPresent(ClassAnotation.class)){
                ClassAnotation anotation = clazz.getAnnotation(ClassAnotation.class);
                return anotation.nomeTabela();
            }

        }catch (Exception e){
            Log.e("Erro: ", e.getMessage());
        }
        return null;
    }
    public static String getNomeTabela(final Object obj){
        try {
            Class<?> clazz = obj.getClass();
            if(clazz.isAnnotationPresent(ClassAnotation.class)){
                ClassAnotation anotation = clazz.getAnnotation(ClassAnotation.class);
                return anotation.nomeTabela();
            }

        }catch (Exception e){
            Log.e("Erro: ", e.getMessage());
        }
        return null;
    }

    public static String getPrimaryKey(final Class<?> clazz) {
        try {

            for(Field field : clazz.getDeclaredFields()){
                if(field.isAnnotationPresent(AtributoAnotation.class)){
                    AtributoAnotation anotation = field.getAnnotation(AtributoAnotation.class);
                    if(anotation.primaryKeyAtributo()){
                        return anotation.nomeAtributo();
                    }
                }
            }

        }catch (Exception e){
            Log.e("Erro: ", e.getMessage());
        }

        return null;
    }

    public static String getSQLCreate(final Class<?> clazz) {
        StringBuilder scritpBuilder = new StringBuilder();
        scritpBuilder.append("CREATE TABLE ");
        scritpBuilder.append(getNomeTabela(clazz));
        scritpBuilder.append(" ( ");
        //Class<?> clazz = obj.getClass();
        int cont = 0;
        for (Field field : clazz.getDeclaredFields()){
            if(field.isAnnotationPresent(AtributoAnotation.class)){
                AtributoAnotation anotation = field.getAnnotation(AtributoAnotation.class);
                scritpBuilder.append(anotation.nomeAtributo());
                scritpBuilder.append(" ");
                //scritpBuilder.append(anotation.tipoAtributo().toUpperCase());
                switch (anotation.tipoAtributo()){
                    case ("INTEGER"):
                        scritpBuilder.append(anotation.tipoAtributo());
                        break;
                    case ("VARCHAR"):
                        scritpBuilder.append(anotation.tipoAtributo());
                        scritpBuilder.append(" ( ");
                        scritpBuilder.append(anotation.tamanhoAtributo());
                        scritpBuilder.append(" ) ");
                        break;
                    case ("CHAR"):
                        scritpBuilder.append(anotation.tipoAtributo());
                        scritpBuilder.append(" ( ");
                        scritpBuilder.append(anotation.tamanhoAtributo());
                        scritpBuilder.append(" ) ");
                        break;
                }
                scritpBuilder.append(" ");

                if(anotation.primaryKeyAtributo()){
                    scritpBuilder.append(" PRIMARY KEY ");
                }
                if(anotation.autoIncrementAtributo()){
                    scritpBuilder.append(" AUTOINCREMENT ");
                }

            }
            cont++;
            if(cont < clazz.getDeclaredFields().length){
                scritpBuilder.append(", ");
            }
        }
        scritpBuilder.append(");");
        return scritpBuilder.toString();
    }
    //"DROP TABLE IF EXISTS VENDEDOR"
    public static String getDROPSQLite( final Class<?> obj){
        StringBuilder scritpBuilder = new StringBuilder();
        scritpBuilder.append("DROP TABLE IF EXISTS ");
        scritpBuilder.append(getNomeTabela(obj));
        return scritpBuilder.toString();
    }

    public static void setValueAtributoByCursor(String nomeAtributo, String nomeMetodo, final Cursor cursor, Class<?> clazz, final Object objLinha) {
        //Class<?> clazz = objClazz.getClass();
        //Object obj = null;
        try {
            //obj = createNewInstance(clazz);
            String tipoSet = Util.getTipSETMethod(clazz, nomeMetodo);
            for(Method method : clazz.getDeclaredMethods()){
                if(method.getName().equals(nomeMetodo)){
                    switch (tipoSet){
                        case "String":
                            method.invoke(objLinha, cursor.getString(cursor.getColumnIndex(nomeAtributo)));
                            break;
                        case "boolean":
                            method.invoke(objLinha, cursor.getInt(cursor.getColumnIndex(nomeAtributo)));
                            break;
//                            case "Byte":
//                                method.invoke(obj, cursor.getB(cursor.getColumnIndex(nomeAtributo)));
//                                break;
                        case "Double":
                            method.invoke(objLinha, cursor.getDouble(cursor.getColumnIndex(nomeAtributo)));
                            break;
                        case "Float":
                            method.invoke(objLinha, cursor.getFloat(cursor.getColumnIndex(nomeAtributo)));
                            break;
                        case "Integer":
                            //vendedorLinha.setID_VENDEDOR(cursor.getInt(cursor.getColumnIndex("ID_VENDEDOR")));
                            method.invoke(objLinha, cursor.getInt(cursor.getColumnIndex(nomeAtributo)));
                            break;
                        case "Long":
                            method.invoke(objLinha, cursor.getLong(cursor.getColumnIndex(nomeAtributo)));
                            break;
                        case "Short":
                            method.invoke(objLinha, cursor.getShort(cursor.getColumnIndex(nomeAtributo)));
                            break;
                    }

                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }


}