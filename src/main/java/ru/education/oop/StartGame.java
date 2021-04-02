package ru.education.oop;

import ru.education.bank.*;
import ru.education.bank.Admin.Admin;
import ru.education.bank.Admin.AdminOperationAdapter;
import ru.education.bank.SimpleUser.SimpleUser;
import ru.education.bank.SimpleUser.UserOperationAdapter;

import java.math.BigDecimal;

public class StartGame {

    public static void main(String[] args) throws InterruptedException {

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
//
     //   Timer timer = new Timer(new Date());
       // Authorization authorization =new Authorization(new FileBasedUserRepo());
       // timer.start();
        SimpleUser simpleUser = new SimpleUser("Hello","word",new BigDecimal("1000"), new UserOperationAdapter(new FileBasedUserRepo()));
        Admin admin =new Admin("ss","gg", new AdminOperationAdapter(new FileBasedUserRepo()));
        admin.addNewUser(new Admin("test2","test", new AdminOperationAdapter(new FileBasedUserRepo())));
        //       // admin.addNewUser(new SimpleUser("test","test",new BigDecimal(1), new UserOperationAdapter(new FileBasedUserRepo())));
       // System.out.println(simpleUser.seeBalance());
       // Thread.sleep(10000);
      //  simpleUser.takeMoney(new BigDecimal(1000));
      //  Thread.sleep(10000);
     // simpleUser.sendMoney("fifa",new BigDecimal(1000));
     //  Thread.sleep(10000);
       // System.out.println(simpleUser.seeBalance());
      // Thread.sleep(10000);
       // System.out.println(simpleUser.seeBalance());

}
}
