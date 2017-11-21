package com.milkfarm.testeapp;


import java.util.ArrayList;

public class InterpretadorSigno {
    private ArrayList<Signo> signos = new ArrayList<Signo>(){{
        add(new Signo(20,1,18,2,"Aquario","@drawable/aquario"));
        add(new Signo(19,2,20,3,"Aquario","@drawable/peixes"));
        add(new Signo(21,3,19,4,"Aquario","@drawable/aries"));
        add(new Signo(20,4,20,5,"Aquario","@drawable/touro"));
        add(new Signo(21,5,20,6,"Aquario","@drawable/gemeos"));
        add(new Signo(21,6,22,7,"Aquario","@drawable/cancer"));
        add(new Signo(23,7,22,8,"Aquario","@drawable/leao"));
        add(new Signo(23,8,22,9,"Aquario","@drawable/virgem"));
        add(new Signo(23,9,22,10,"Aquario","@drawable/libra"));
        add(new Signo(23,10,21,11,"Aquario","@drawable/escorpiao"));
        add(new Signo(22,11,21,12,"Aquario","@drawable/sagitario"));
        add(new Signo(22,12,19,1,"Aquario","@drawable/capricornio"));

    }};
    public Signo interpretar(int dia, int mes) {
            Signo signo = null;
               for (Signo s : signos) {
                     if (s.getMesInicio() == mes && dia >= s.getDiaInicio()) {
                            signo = s;
                            break;
                         } else if (s.getMesFim() == mes && dia <= s.getDiaFim()) {
                           signo = s;
                           break;
                        }
                 }
           return signo;
         }
}
