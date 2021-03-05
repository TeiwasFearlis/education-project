package ru.education.oop;

import ru.education.oop.cold.Knife;
import ru.education.oop.cold.Lance;
import ru.education.oop.fire.DesertEagle;
import ru.education.oop.fire.MakarovPistol;
import ru.education.oop.fire.Pistol;

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
        System.out.println(makarovPistol.doDamage());
        System.out.println(makarovPistol.getCaliber());
        makarovPistol.setCheckSilencer(true);
        System.out.println(makarovPistol.getCheckSilencer());
        System.out.println(makarovPistol.getFireWeaponCaliberType());

        System.out.println(new DesertEagle().getFireWeaponCaliberType());


        ///
        Robot robot=new Robot(new ColdWeaponAdapter(new Pistol()));
        System.out.println(robot.getColdWeapon().getBladeSharpened());
        System.out.println(robot.getColdWeapon().getLengthShaft());
        Robot robot2=new Robot(new ColdWeaponAdapter(new DesertEagle()));



    }
}
