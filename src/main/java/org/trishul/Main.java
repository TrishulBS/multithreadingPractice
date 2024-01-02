package org.trishul;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
//        Printer printer = new Printer();
//        Thread t1 = new Thread(new TaskEvenOdd(true, printer, 10));
//        Thread t2 = new Thread(new TaskEvenOdd(false, printer, 10));
//
//        t1.start();
//        t2.start();
//        -----------------------------------------
//        SharedPrinter sharedPrinter = new SharedPrinter();
//        Thread t1 = new Thread(new OddSemaphore(sharedPrinter), "odd");
//        Thread t2 = new Thread(new EvenSemaphore(sharedPrinter), "even");
//
//        t1.start();
//        t2.start();
//        -------------------------------------------

        Data data = new Data();
        Thread sender = new Thread(new Sender(data));
        Thread receiver = new Thread(new Receiver(data));

        sender.start();
        receiver.start();
    }
}