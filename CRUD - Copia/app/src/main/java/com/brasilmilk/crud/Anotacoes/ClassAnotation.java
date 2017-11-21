package com.brasilmilk.crud.Anotacoes;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by ricar on 20/11/2017.
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface ClassAnotation {
    public String nomeTabela();
}
