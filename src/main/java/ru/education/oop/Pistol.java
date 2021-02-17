package ru.education.oop;

public class Pistol extends FireWeapon{

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
}
