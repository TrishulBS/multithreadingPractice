package org.trishul;

public class OddSemaphore implements Runnable{

    private SharedPrinter sharedPrinter;

    OddSemaphore(SharedPrinter sharedPrinter){
        this.sharedPrinter = sharedPrinter;
    }
    public void run(){
        for(int i = 1; i<=10; i+=2){
            sharedPrinter.printOdd(i);
        }
    }
}
