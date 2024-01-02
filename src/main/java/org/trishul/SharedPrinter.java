package org.trishul;

import java.util.concurrent.Semaphore;

public class SharedPrinter {
    private Semaphore oddSemaphore = new Semaphore(1);
    private Semaphore evenSemaphore = new Semaphore(0);

    public void printOdd(int num){
        try{
            oddSemaphore.acquire();
        } catch( InterruptedException e){
            Thread.currentThread().interrupt();
        }
        System.out.println(Thread.currentThread().getName()+num);
        evenSemaphore.release();
    }

    public void printEven(int num){
        try{
            evenSemaphore.acquire();
        }
        catch (InterruptedException e){
            Thread.currentThread().interrupt();
        }
        System.out.println(Thread.currentThread().getName()+num);
        oddSemaphore.release();
    }
}
