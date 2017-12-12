package com.frango.frangonecropsia.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ricar on 11/12/2017.
 */

public class Frango {
    private List<Boolean> frango1;
    private List<Boolean> frango2;
    private List<Boolean> frango3;
    private List<Boolean> frango4;
    private List<Boolean> frango5;
    private List<String> doencaList;
    public Frango() {
        this.frango1 = new ArrayList<Boolean>(){{add(true); add(false); add(true); add(false);
            add(false); add(false); add(false); add(false); add(false); add(false); add(false);
            add(false); add(false); add(true); add(false); add(false); add(true); add(false);
            add(false); add(false); add(false); add(true); add(false); add(false); add(false);
            add(false); add(false); add(false); add(false); add(true); add(false); add(true);
            add(false); add(false); add(false); add(false); add(false); add(false); add(false);
            add(false); add(false); add(false); add(false); add(false); add(false); add(false);
            add(false); add(true);
        }};
        this.frango2 = new ArrayList<Boolean>(){{add(true); add(false); add(true); add(false);
            add(false); add(false); add(false); add(false); add(false); add(false); add(false);
            add(false); add(false); add(true); add(false); add(false); add(true); add(false);
            add(false); add(false); add(false); add(true); add(false); add(false); add(false);
            add(false); add(false); add(false); add(false); add(true); add(false); add(true);
            add(false); add(false); add(false); add(false); add(false); add(false); add(false);
            add(false); add(false); add(false); add(false); add(false); add(false); add(false);
            add(false); add(true);
        }};
        this.frango3 = new ArrayList<Boolean>(){{add(true); add(false); add(true); add(false);
            add(false); add(false); add(false); add(false); add(false); add(false); add(false);
            add(false); add(false); add(true); add(false); add(false); add(true); add(false);
            add(false); add(false); add(false); add(true); add(false); add(false); add(false);
            add(false); add(false); add(false); add(false); add(true); add(false); add(true);
            add(false); add(false); add(false); add(false); add(false); add(false); add(false);
            add(false); add(false); add(false); add(false); add(false); add(false); add(false);
            add(false); add(true);
        }};
        this.frango4 = new ArrayList<Boolean>(){{add(true); add(false); add(true); add(false);
            add(false); add(false); add(false); add(false); add(false); add(false); add(false);
            add(false); add(false); add(true); add(false); add(false); add(true); add(false);
            add(false); add(false); add(false); add(true); add(false); add(false); add(false);
            add(false); add(false); add(false); add(false); add(true); add(false); add(true);
            add(false); add(false); add(false); add(false); add(false); add(false); add(false);
            add(false); add(false); add(false); add(false); add(false); add(false); add(false);
            add(false); add(true);
        }};
        this.frango5 = new ArrayList<Boolean>(){{add(true); add(false); add(true); add(false);
            add(false); add(false); add(false); add(false); add(false); add(false); add(false);
            add(false); add(false); add(true); add(false); add(false); add(true); add(false);
            add(false); add(false); add(false); add(true); add(false); add(false); add(false);
            add(false); add(false); add(false); add(false); add(true); add(false); add(true);
            add(false); add(false); add(false); add(false); add(false); add(false); add(false);
            add(false); add(false); add(false); add(false); add(false); add(false); add(false);
            add(false); add(true);
        }};
        doencaList = new ArrayList<>();
    }


    public List<Boolean> getFrango1() {
        return frango1;
    }

    public List<Boolean> getFrango2() {
        return frango2;
    }

    public List<Boolean> getFrango3() {
        return frango3;
    }

    public List<Boolean> getFrango4() {
        return frango4;
    }

    public List<Boolean> getFrango5() {
        return frango5;
    }

    public Boolean getFrango1ByPos(int pos) {
        return frango1.get(pos);
    }

    public Boolean getFrango2ByPos(int pos) {
        return frango2.get(pos);
    }

    public Boolean getFrango3ByPos(int pos) {
        return frango3.get(pos);
    }

    public Boolean getFrango4ByPos(int pos) {
        return frango4.get(pos);
    }

    public Boolean getFrango5ByPos(int pos) {
        return frango5.get(pos);
    }



    public void setFrango1(Boolean bol, int pos){
        this.frango1.set(pos,bol);
    }
    public void setFrango2(Boolean bol, int pos){
        this.frango2.set(pos,bol);
    }
    public void setFrango3(Boolean bol, int pos){
        this.frango3.set(pos,bol);
    }
    public void setFrango4(Boolean bol, int pos){
        this.frango4.set(pos,bol);
    }
    public void setFrango5(Boolean bol, int pos){
        this.frango5.set(pos,bol);
    }
}
