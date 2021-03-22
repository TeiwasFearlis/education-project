package ru.education.oop;

import ru.education.bank.Admin.Admin;
import ru.education.bank.SimpleUser.SimpleUser;
import ru.education.bank.User;

public class StartGame {

    public static void main(String[] args) {

//        System.out.println(new Knife("").getLengthShaft());
//        System.out.println(new Lance().getLengthShaft());
////        Battle battle = new Battle();
//
//        battle.setWeapon(new Backsword());
//
//        Backsword backsword = new Backsword();
//        battle.damage();
//        battle.strength();
//        battle.material();
//        battle.bladeLength(backsword);
//        backsword.nameBacksword();
//        MakarovPistol makarovPistol = new MakarovPistol();
//        System.out.println(makarovPistol.doDamage());
//        System.out.println(makarovPistol.getCaliber());
//        makarovPistol.setCheckSilencer(true);
//        System.out.println(makarovPistol.getCheckSilencer());
//        System.out.println(makarovPistol.getFireWeaponCaliberType());
//
//        System.out.println(new DesertEagle().getFireWeaponCaliberType());


        ///
//        Robot robot=new Robot(new ColdWeaponAdapter(new Pistol()));
//        System.out.println(robot.getColdWeapon().getBladeSharpened());
//        System.out.println(robot.getColdWeapon().getLengthShaft());
//        Robot robot2=new Robot(new ColdWeaponAdapter(new DesertEagle()));
//        System.out.println(robot.getColdWeapon().doDamage());;
        SimpleUser simpleUser =new SimpleUser(new User("test234","pass234"));//("test234","pass234");
        System.out.println(simpleUser.seeBalance());
        System.out.println(simpleUser.takeMoney(40));
        System.out.println(simpleUser.sendMoney("Hello",50));
       Admin admin =new Admin(new User("Hello","word"));
        System.out.println(admin.seeBalance("test234"));
        System.out.println(admin.addMoney("test234",100));

    }
}
