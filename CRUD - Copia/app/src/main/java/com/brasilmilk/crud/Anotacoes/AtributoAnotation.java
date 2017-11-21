package com.brasilmilk.crud.Anotacoes;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by ricar on 20/11/2017.
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface AtributoAnotation {
    String nomeAtributo();
    String tipoAtributo()default "VARCHAR";
    int tamanhoAtributo()default 100;
    String nomeGet();
    String nomeSet();
    boolean primaryKeyAtributo()default false;
    boolean autoIncrementAtributo() default false;
}
