package org.trishul;

public class TaskEvenOdd implements Runnable{
    private boolean isEven;
    private Printer printer;
    private int max;

    public TaskEvenOdd(boolean isEven, Printer printer, int max){
        this.isEven = isEven;
        this.printer = printer;
        this.max = max;
    }

    public void run(){
        int number;
        if(isEven == true){
            number = 2;
        }
        else{
            number = 1;
        }

        while(number<=max){
            if(isEven){
                printer.printEven(number);
            }
            else{
                printer.printOdd(number);
            }
            number+=2;
        }
    }
}
