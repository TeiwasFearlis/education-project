package ru.education.oop;

public class Backsword extends Knife{
  private   int damage = 8;
   private int strength = 10;
   private int bladeLength = 40;
   private String typeBacksword = "Охотничье";
   private final String name;
   private String material = "Сталь";

    public Backsword(String name) {
        super(name);
        this.name=name;
        bladeLength();
    }



    @Override
    public int bladeLength() {
        return bladeLength;
    }

    @Override
    public int strength() {
        return strength;
    }

    @Override
    public int doDamage() {
        return damage;
    }

    protected void bladeTypeBacksword() {
        super.bladeType(typeBacksword);

    }

    @Override
    public String material() {
        return material;
    }
}
