package ru.education.oop;

public abstract class FireWeapon implements IWeapon{

private int caliber;

    public int getCaliber() {
        return caliber;
    }

    public void setCaliber(int caliber) {
        this.caliber = caliber;
    }

    public String FireWeaponCaliberType (String type){
        return  "Тип оружия: "+type;//Крупнокалиберное,Обычное,Малокалиберное
    }






}

