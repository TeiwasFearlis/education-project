package ru.education.oop;

public abstract class ColdWeapon implements IWeapon{
    private int lengthShaft ;
//Длина лезвия
    public abstract int bladeLength();

//Заточенность лезвия
    public abstract int bladeSharpened();//Тупое,Острое

//Тип холодного оружия
    public void bladeType(String type){
        System.out.println("Это оружие "+type);
    };//рубящее,спортивное,охотничье,боевое.

//Длина древка
    public void setShaftLength(int length){
        lengthShaft = length;
    }

    public int getLengthShaft() {
        return lengthShaft;
    }
}
