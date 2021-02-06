package ru.education.oop;

public abstract class ColdWeapon implements IWeapon{

//Длина лезвия
    public abstract int bladeLength();

//Заточенность лезвия
    public abstract int bladeSharpened();//Тупое,Острое

//Тип холодного оружия
    public void bladeType(String type){
        System.out.println("Это оружие "+type);
    };//рубящее,спортивное,охотничье,боевое.

//Длина древка
    public void shaftLength(int length){
        System.out.println("Длина древка= "+length);
    }










}
