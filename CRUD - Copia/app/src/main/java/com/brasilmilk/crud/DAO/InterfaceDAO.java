package com.brasilmilk.crud.DAO;

import android.content.ContentValues;

import java.util.List;

/**
 * Created by ricar on 20/11/2017.
 */

public interface InterfaceDAO {
    public Integer salvar(Object obj);
    public boolean excluir(String[] parametros);
    public boolean alterar( Object obj);
    public List<?> getAll();
    public Object getById(String nome);
    public void close();
    public ContentValues contentValues();
}
