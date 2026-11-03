
class FirstThread extends Thread {

    @Override
    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println("First cook: preparing pizza, step " + i);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("First thread interrupted");
                return;
            }
        }

        System.out.println("First cook: pizza is ready!");
    }
}

class SecondTask implements Runnable {

    @Override
    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println("Second cook: preparing burger, step " + i);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Second thread interrupted");
                return;
            }
        }

        System.out.println("Second cook: burger is ready!");
    }
}

public class Main {

    public static void main(String[] args)
            throws InterruptedException {

        System.out.println("The cafe is open!");
        System.out.println("Two orders have arrived.\n");

        FirstThread first = new FirstThread();

        SecondTask task = new SecondTask();
        Thread second = new Thread(task);

        first.start();
        second.start();

        first.join();
        second.join();

        System.out.println("\nAll cooks have finished working!");
        System.out.println("All orders are ready!");
    }
}
