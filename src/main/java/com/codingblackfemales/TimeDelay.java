package com.codingblackfemales;

import java.util.concurrent.TimeUnit;

public class TimeDelay {
    public void timeDelay(int milliseconds){
        try {
    TimeUnit.MILLISECONDS.sleep(milliseconds); 
        } catch (InterruptedException e) {
            System.out.println("Time delay failed to execute");
            e.printStackTrace();
        }
    }
}
