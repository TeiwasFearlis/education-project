package ru.education.oop;

public class Lance extends ColdWeapon {
    int lengthLanceShaft = 150;

    @Override
    public void shaftLength(int length) {
        lengthLanceShaft = length;
        super.shaftLength(length);
    }

    @Override
    public int bladeLength() {

        return 0;
    }

    @Override
    public int bladeSharpened() {
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
