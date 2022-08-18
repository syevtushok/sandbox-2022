package examples.concurrency.core;

public class SynchronizedExample {
    private int sum;



    public void calculate() {
        setSum(getSum() + 1);
    }

    public synchronized void synchronizedCalculate() {
        setSum(getSum() + 1);
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }
}
