package com.brasilmilk.crud.Anotacoes;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by ricar on 20/11/2017.
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface MetodoAnotation {
    String tipoRetorno()default "String";
    String tipoSet() default "String";
}
