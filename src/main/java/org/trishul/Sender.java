package org.trishul;

import java.util.concurrent.ThreadLocalRandom;

public class Sender implements Runnable{

    private Data data;

    public Sender(Data data) {
        this.data = data;
    }

    public void run(){
        String[] packets = {"First Packet", "Second Packet", "Third Packet", "Fourth Packet", "End"};
        for(String str: packets){
            data.send(str);
            try{
                Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 5000));
            }
            catch( InterruptedException e){
                Thread.currentThread().interrupt();
                System.err.println("Thread Interrupted");
            }
        }
    }
}
