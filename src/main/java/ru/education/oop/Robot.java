package ru.education.oop;

import ru.education.oop.cold.ColdWeapon;
import ru.education.oop.cold.Knife;
import ru.education.oop.cold.Lance;

public class Robot {
    private final ColdWeapon coldWeapon;

    public Robot(ColdWeapon coldWeapon) {
        this.coldWeapon = coldWeapon;
    }

    public ColdWeapon getColdWeapon() {
        return coldWeapon;
    }
}
