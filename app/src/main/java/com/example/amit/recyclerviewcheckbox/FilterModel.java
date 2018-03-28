package com.example.amit.recyclerviewcheckbox;

/**
 * Created by Amit on 28-03-2018.
 */

class FilterModel {

    private String string;
    private int anInt;
    private boolean aBoolean;

    public FilterModel(String string, int anInt, boolean aBoolean) {
        this.string = string;
        this.anInt = anInt;
        this.aBoolean = aBoolean;
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    public int getAnInt() {
        return anInt;
    }

    public void setAnInt(int anInt) {
        this.anInt = anInt;
    }

    public boolean isaBoolean() {
        return aBoolean;
    }

    public void setaBoolean(boolean aBoolean) {
        this.aBoolean = aBoolean;
    }
}
