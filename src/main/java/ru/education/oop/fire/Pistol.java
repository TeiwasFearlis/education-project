package ru.education.oop.fire;


public class Pistol extends FireWeapon {

    private String type="Обычный";

    public void setType(String type) {
        this.type = type;
    }

    private int valueMagazine;

    public int getValueMagazine() {
        return valueMagazine;
    }

    public void setValueMagazine(int valueMagazine) {
        this.valueMagazine = valueMagazine;
    }

    @Override
    public int doDamage() {
        return 0;
    }

    @Override
    public int strength() {
        return 0;
    }

    @Override
    public String material() {
        return null;
    }

    @Override
    public String getFireWeaponCaliberType() {
        return  "Тип оружия: "+type;
    }

    @Override
    public int getSize() {
        return 15;
    }
}
