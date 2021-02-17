package ru.education.oop;

public class MakarovPistol extends Pistol{
    private final String type="Обычный";

    private boolean chekSilencer;



    public String getType(){
        return type;
    }

    @Override
    public int doDamage() {
        return 80;
    }

    public  MakarovPistol() {
        setCaliber(9);
        setValueMagazine(10);
    }
    
    public boolean getChekSilencer() {
        return chekSilencer;
    }

    public void setChekSilencer(boolean chekSilencer) {
        this.chekSilencer = chekSilencer;
    }

    @Override
    public String FireWeaponCaliberType(String type) {
        return super.FireWeaponCaliberType(type);
    }
}


