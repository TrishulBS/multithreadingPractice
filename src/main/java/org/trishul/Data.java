package org.trishul;

public class Data {
    private String packet;
    private boolean transfer = true;

    synchronized public String receive(){
        while(transfer){
            try{
                wait();
            }
            catch (InterruptedException e){
                Thread.currentThread().interrupt();
                System.out.println("Thread Interrupted");
            }
        }
        transfer = true;
        notifyAll();
        return this.packet;
    }

    synchronized public void send(String data){
        while(transfer == false){
            try{
                wait();
            }
            catch (InterruptedException e){
                Thread.currentThread().interrupt();
                System.out.println("Thread Interrupted");
            }
        }
        transfer = false;
        this.packet = data;
        notifyAll();
    }
}
