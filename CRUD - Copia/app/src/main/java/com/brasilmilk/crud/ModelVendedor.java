package com.brasilmilk.crud;


import com.brasilmilk.crud.Anotacoes.ApresentacaoAN;
import com.brasilmilk.crud.Anotacoes.AtributoAnotation;
import com.brasilmilk.crud.Anotacoes.ClassAnotation;
import com.brasilmilk.crud.Anotacoes.MetodoAnotation;

@ClassAnotation(nomeTabela = "VENDEDOR")
public class ModelVendedor {
    @ApresentacaoAN
    @AtributoAnotation(nomeAtributo = "ID_VENDEDOR", tipoAtributo = "INTEGER", nomeGet = "getID_VENDEDOR", nomeSet = "setID_VENDEDOR", primaryKeyAtributo = true, autoIncrementAtributo = true)
    private Integer ID_VENDEDOR;

    @ApresentacaoAN(lisView = true)
    @AtributoAnotation(nomeAtributo = "NOME", nomeGet = "getNOME", nomeSet = "setNOME")
    private String NOME;

    @ApresentacaoAN
    @AtributoAnotation(nomeAtributo = "ATIVO",tipoAtributo = "CHAR", tamanhoAtributo = 1, nomeGet = "getATIVO", nomeSet = "setATIVO")
    private String ATIVO;

    @ApresentacaoAN
    @AtributoAnotation(nomeAtributo = "TIPO", nomeGet = "getTIPO", nomeSet = "setTIPO")
    private String TIPO;

    @MetodoAnotation(tipoRetorno = "Integer", tipoSet = "Integer")
    public Integer getID_VENDEDOR() {
        return ID_VENDEDOR;
    }

    @MetodoAnotation(tipoRetorno = "Integer", tipoSet = "Integer")
    public void setID_VENDEDOR(Integer ID_VENDEDOR) {
        this.ID_VENDEDOR = ID_VENDEDOR;
    }

    @MetodoAnotation
    public String getNOME() {
        return NOME;
    }

    @MetodoAnotation
    public void setNOME(String NOME) {
        this.NOME = NOME;
    }

    @MetodoAnotation
    public String getATIVO() {
        return ATIVO;
    }

    @MetodoAnotation
    public void setATIVO(String ATIVO) {
        this.ATIVO = ATIVO;
    }

    @MetodoAnotation
    public String getTIPO() {
        return TIPO;
    }

    @MetodoAnotation
    public void setTIPO(String TIPO) {
        this.TIPO = TIPO;
    }
}
