//Thomas Chen
//Thread Lab


class ThreadLab {
  public static void main(String[] args) {
    // Create tasks
   Runnable printA = new PrintText("Fa", 1);
    Runnable printB = new PrintText("La", 5);

    // Create threads
    Thread thread1 = new Thread(printA);
    Thread thread2 = new Thread(printB);

    // Start threads
    thread1.start();
    thread2.start();
  }
}


class PrintText implements Runnable {
  private String ToPrint; 
  private int times;


  public PrintText(String c, int t) {
    ToPrint = c;
    times = t;
  }


  public void run() {
for (int i = 0; i < times ; i++) {
    System.out.print(ToPrint + "-");
    }
  }
}
