package ru.education.oop.cold;

public class Lance extends ColdWeapon {

    public Lance(){
        setShaftLength(150);
    }

    @Override
    public int bladeLength() {

        return 0;
    }

    @Override
    public int getBladeSharpened() {
        return 200;
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
