// introduces a reuseable method that creates a time delay. I didn't like all of the information being pushed to the user all at one time.
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
