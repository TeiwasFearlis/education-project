package ru.education.oop;

public class StartGame {

    public static void main(String[] args) {

        System.out.println(new Knife("").getLengthShaft());
        System.out.println(new Lance().getLengthShaft());
//        Battle battle = new Battle();
//
//        battle.setWeapon(new Backsword());
//
//        Backsword backsword = new Backsword();
//        battle.damage();
//        battle.strength();
//        battle.material();
//        battle.bladeLength(backsword);
//        backsword.nameBacksword();
MakarovPistol makarovPistol = new MakarovPistol();
        System.out.println(new MakarovPistol().doDamage());
        System.out.println(makarovPistol.getCaliber());
        makarovPistol.setChekSilencer(true);
        System.out.println(makarovPistol.getChekSilencer());
        System.out.println(makarovPistol.FireWeaponCaliberType(makarovPistol.getType()));

    }
}
