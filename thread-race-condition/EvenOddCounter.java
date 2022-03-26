import java.util.ArrayList;

public class EvenOddCounter implements Runnable {
    private static int threadCount = 0;
    boolean notFinish;
    private int no;

    public ArrayList<Integer> numList;
    public static ArrayList<Integer> evenList = new ArrayList<>();
    public static ArrayList<Integer> oddList = new ArrayList<>();

    public EvenOddCounter(ArrayList<Integer> numList) {
        this.numList = numList;
        this.no = ++threadCount;
        this.notFinish = true;
    }

    @Override
    public void run() {
        for (int i = 0; i < numList.size() ; i++) {
            if (numList.get(i) % 2 == 0) {
                evenList.add(numList.get(i));
            }
            else {
                oddList.add(numList.get(i));
            }
        }
        this.notFinish = false;
    }

    public static void print() {
        System.out.println();
        System.out.println("(even) : " + evenList.toString());
        System.out.println("(odd ) : " + oddList.toString());
    }
}
