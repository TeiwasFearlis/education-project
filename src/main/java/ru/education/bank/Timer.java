package ru.education.bank;

import java.io.IOError;
import java.io.IOException;
import java.util.Date;

public class Timer extends Thread {

    private Date date;

    public Timer(Date date) {
        this.date = date;
    }


public boolean chekTime(){
          Date simpleTime = new Date();
          long start = date.getTime();
          long time = simpleTime.getTime();
          long chek = time - start;
          System.out.println(chek);
        try {  if (chek < 20000) {
              return true;
          }else {
              throw new IllegalStateException("Your time is over");
          }
      }catch (IllegalStateException e){
         throw new RuntimeException(e);
      }
}

    @Override
    public void run() {
       chekTime2();
    }

    private void chekTime2() {
        do {
            Date simpleTime = new Date();
            long start = date.getTime();
            long time = simpleTime.getTime();
            long chek = time - start;
            System.out.println(start);
            System.out.println(time);
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                if (chek < 20000) {
                   continue;
                } else {
                    throw new IllegalStateException("Your time is over");
                }
            } catch (IllegalStateException e) {
                throw new RuntimeException(e);
            }
        }while (true);
    }


}
