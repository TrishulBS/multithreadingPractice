package org.trishul;

public class Printer {
    private volatile boolean isOdd = true;

    synchronized public void printEven(int number){
        while(isOdd){
            try{
                wait();
            }catch(InterruptedException e){
                Thread.currentThread().interrupt();
            }
        }
        System.out.println(Thread.currentThread().getName()+":"+number);
        isOdd = true;
        notify();
    }

    synchronized public void printOdd(int number){
        while(isOdd == false){
            try{
                wait();
            }
            catch (InterruptedException e){
                Thread.currentThread().interrupt();
            }
        }
        System.out.println(Thread.currentThread().getName()+":"+number);
        isOdd=false;
        notify();
    }
}
