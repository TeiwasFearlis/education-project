package ru.education.oop;

public class Battle {

    private IWeapon weapon;

    public void setWeapon(IWeapon weapon) {
        this.weapon = weapon;
    }


    public Battle() {
    }

    public void damage() {
        System.out.println("Вы нанесли:" + weapon.doDamage() + " урона");
    }

    public void strength() {
        System.out.println("Прочность оружия = " + weapon.strength());
    }

    public void material() {
        System.out.println("Материал изготовления= " + weapon.material());
    }

    public void bladeLength(ColdWeapon coldWeapon){
        System.out.println("Длина лезвия= " + coldWeapon.bladeLength());
    }



}

