package ru.education.oop.fire;

import ch.qos.logback.core.LayoutBase;
import ru.education.oop.IWeapon;

public abstract class FireWeapon implements IWeapon {

    private int caliber;

    public int getCaliber() {
        return caliber;
    }

    public void setCaliber(int caliber) {
        this.caliber = caliber;
    }

    public abstract String getFireWeaponCaliberType();


    public abstract int getSize();
}

