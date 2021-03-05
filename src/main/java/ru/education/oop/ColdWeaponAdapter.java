package ru.education.oop;

import ru.education.oop.cold.ColdWeapon;
import ru.education.oop.fire.FireWeapon;

public class ColdWeaponAdapter extends ColdWeapon {
    private final FireWeapon fireWeapon;

    public ColdWeaponAdapter(FireWeapon fireWeapon) {
        this.fireWeapon = fireWeapon;
    }

    @Override
    public int bladeLength() {
        return fireWeapon.getSize();
    }

    @Override
    public int getBladeSharpened() {
        return 0;
    }

    @Override
    public int doDamage() {
        return 10;
    }

    @Override
    public int strength() {
        return 40;
    }

    @Override
    public String material() {
        return "Сталь";
    }
}
