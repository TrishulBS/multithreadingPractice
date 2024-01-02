package org.trishul;

public class EvenSemaphore implements Runnable{
    private SharedPrinter sharedPrinter;

    public EvenSemaphore(SharedPrinter sharedPrinter){
        this.sharedPrinter = sharedPrinter;
    }
    public void run(){
        for(int i = 2; i<=10 ; i+=2){
            sharedPrinter.printEven(i);
        }
    }

}
