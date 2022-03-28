import java.util.ArrayList;

public class MainThread {
    public static void main(String[] args) throws InterruptedException {

        // Initialization.
        ArrayList<Integer> numList = new ArrayList<>();
        ArrayList<Integer> quarterList1 = new ArrayList<>(250);
        ArrayList<Integer> quarterList2 = new ArrayList<>(250);
        ArrayList<Integer> quarterList3 = new ArrayList<>(250);
        ArrayList<Integer> quarterList4 = new ArrayList<>(250);

        // Filling the number list.
        for (int i = 1; i <= 1000 ; i++) {
            numList.add(i);
        }

        // Seperating to sublists.
        quarterList1.addAll(numList.subList(0, 250-1));
        quarterList2.addAll(numList.subList(250, 500-1));
        quarterList3.addAll(numList.subList(500, 750-1));
        quarterList4.addAll(numList.subList(750, 1000-1));

        // Counter initialize.
        EvenOddCounter o1 = new EvenOddCounter(quarterList1);
        EvenOddCounter o2 = new EvenOddCounter(quarterList2);
        EvenOddCounter o3 = new EvenOddCounter(quarterList3);
        EvenOddCounter o4 = new EvenOddCounter(quarterList4);

        // Creating threads.
        Thread t1 = new Thread(o1);
        Thread t2 = new Thread(o2);
        Thread t3 = new Thread(o3);
        Thread t4 = new Thread(o4);

        // Threads start.
        t1.start();
        t2.start();
        t3.start();
        t4.start();

        // loop for all threads finish.
        t1.join();
        t2.join();
        t3.join();
        t4.join();

        // Print result.
        EvenOddCounter.print();
        System.out.println("even-size: " + EvenOddCounter.evenList.size());
        System.out.println("odd-size : " + EvenOddCounter.oddList.size());
    }
}
