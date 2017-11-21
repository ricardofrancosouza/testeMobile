package com.brasilmilk.crud;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.content.Context;
import android.util.Log;

import com.brasilmilk.crud.DAO.AbstratroDAO;
import com.brasilmilk.crud.DAO.InterfaceDAO;
import com.brasilmilk.crud.Helper.SQLiteHelper;
import com.brasilmilk.crud.Util.Util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by ricar on 19/11/2017.
 */

public class DAOVendedor extends AbstratroDAO implements InterfaceDAO {
    private  String scriptSQLCreate;
    private  String scriptSQLDelete;
    private SQLiteDatabase db;
    private SQLiteHelper dbHelper;
    private List<ModelVendedor> listaVendedores;

    public DAOVendedor(Context ctx) {

            try {
               // scriptSQLCreate = Util.getSQLCreate(ModelVendedor.class);
               // scriptSQLDelete = Util.getDROPSQLite(ModelVendedor.class);
                dbHelper = new SQLiteHelper(ctx, SQLiteHelper.NOME_BD, SQLiteHelper.VERSAO_BD, this.scriptSQLCreate, this.scriptSQLDelete);
                this.listaVendedores = new ArrayList<ModelVendedor>();
                ///metodo para criacao dos banco e tabelas
                db = dbHelper.getWritableDatabase();
            } catch (Exception e) {
                Log.e("Erro: ", e.getMessage());
            }

    }


    @Override
    public Integer salvar(Object obj) {
        return super.insert(obj, this.db);
    }

    @Override
    public boolean excluir(String[] parametros) {
        List<String> campoList = new ArrayList<String>();
        campoList.add("ID_VENDEDOR");
        return super.delete(this.db, ModelVendedor.class, campoList, parametros);
    }

    @Override
    public boolean alterar(final Object obj) {
        List<String> campoList = new ArrayList<String>();
        campoList.add("ID_VENDEDOR");
        String[] parametros = new String[]{String.valueOf(Util.getValueMethod(obj, "getID_VENDEDOR"))};
        return super.edit(this.db, obj, campoList, parametros);
    }

    @Override
    public List<?> getAll() {

        listaVendedores.clear();
        listaVendedores.addAll((Collection<? extends ModelVendedor>) super.getAll(db, ModelVendedor.class));
        return  listaVendedores;
    }

    @Override
    public Object getById(String nome) {
        List<String> campoList = new ArrayList<String>();
        campoList.add("NOME");
        String[] parametro = new String[]{nome};
        return super.getByParam(db, ModelVendedor.class, campoList, parametro);
    }

    @Override
    public void close() {
        super.close(this.db);
    }

    @Override
    public ContentValues contentValues() {
         return super.contentCreate(ModelVendedor.class);
    }
}
