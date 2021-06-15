package ru.education.oop.cold;


public class  Knife extends ColdWeapon {

    private final String name;
   
    public Knife(String name) {
        this.name = name;
        setShaftLength(10);
    }

    protected void name() {
        System.out.println("Название ножа: " + name);
    }

    public void vv(){
        System.out.println("dfgdfg");
    }


    public int bladeLength() {
        return 10000;
    }

    @Override
    public int getBladeSharpened() {
        return 150;
    }

    @Override
    public int doDamage() {
        return 0;
    }

    @Override
    public int strength() {
        return 0;
    }

    @Override
    public String material() {
        return null;
    }


    public  class Root extends Ax {


        public Root() {
            System.out.println();
        }

        public void voice(){
            System.out.println(  bladeLength());
            System.out.println( Knife.this.bladeLength());
            vv();
            System.out.println("AAAA");
        }

        public class Test {
            public void power(){
                System.out.println("Кошка,беги!!!");

            }

        }
    }


}
