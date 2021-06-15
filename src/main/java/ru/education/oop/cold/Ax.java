package ru.education.oop.cold;

public class Ax extends ColdWeapon {
    @Override
    public int bladeLength() {

        return 40;
    }

    @Override
    public int getBladeSharpened() {
        return 50;
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
