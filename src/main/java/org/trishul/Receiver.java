package org.trishul;

import java.util.concurrent.ThreadLocalRandom;

public class Receiver implements Runnable{
    private Data data;

    public Receiver(Data data) {
        this.data = data;
    }

    public void run(){
        for(String packet = data.receive(); !packet.equals("End"); packet = data.receive()){
            System.out.println(packet);

            try {
                Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 5000));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.println("Thread Interrupted");
            }
        }
    }
}
