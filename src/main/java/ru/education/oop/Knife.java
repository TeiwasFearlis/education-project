package ru.education.oop;


public class  Knife extends ColdWeapon {

    private final String name;

    public Knife(String name) {
        this.name = name;
        setShaftLength(10);
    }

    protected void name() {
        System.out.println("Название ножа: " + name);
    }


    public int bladeLength() {
        return 0;
    }

    @Override
    public int bladeSharpened() {
        return 150;
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
