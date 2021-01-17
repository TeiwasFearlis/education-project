package ru.education.shapes;

abstract class Shape {
    int width;
    abstract void area();
}
//введите код сюда
class Square extends Shape {
    protected  int square;
    Square (int width){
        this .width = width ;
    }
    public void area (){
        square =width*width;
        System.out.println(square) ;

    }
}

 class Circle  extends Shape {
     double circle ;

     Circle (int width){
        this .width = width ;

    }
    public void area (){
        double doubleWidth= (double ) width ;
        circle =Math.PI* doubleWidth*doubleWidth;
        System.out.println(circle) ;


    }

}

