package ru.education.oop.fire;

import kotlin.reflect.jvm.internal.impl.util.Check;

public class MakarovPistol extends Pistol{

    private boolean chekSilencer;

    @Override
    public int doDamage() {
        return 80;
    }

    public  MakarovPistol() {
        setCaliber(9);
        setValueMagazine(10);
    }
    
    public boolean getCheckSilencer() {
        return chekSilencer;
    }

    public void setCheckSilencer(boolean chekSilencer) {
        this.chekSilencer = chekSilencer;
    }

}


