package Airfare;
public class Indigo implements Airfare {

    private int hours;
    private double costPerHour;

    public Indigo() {
        this.hours = 0;
        this.costPerHour = 0.0;
    }

    public Indigo(int hours, double costPerHour) {
        this.hours = hours;
        this.costPerHour = costPerHour;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public double getCostPerHour() {
        return costPerHour;
    }

    public void setCostPerHour(double costPerHour) {
        this.costPerHour = costPerHour;
    }
    public double calculateAmount() {
        return (hours * costPerHour) * 8;
    }
    public void display() {
        double amount = calculateAmount();
        double roundedAmount = Math.round(amount * 100.0) / 100.0;

        System.out.println("---- Indigo Fare Details ----");
        System.out.println("Hours          : " + hours);
        System.out.println("Cost Per Hour  : " + costPerHour);
        System.out.printf("Total Amount   : %.2f%n", roundedAmount);
        System.out.println("------------------------------");
    }
}
