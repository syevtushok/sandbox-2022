package examples.core.oop;

public class EncapsulationExample {
    private int year;
    private int start;

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year + start;
    }
}
