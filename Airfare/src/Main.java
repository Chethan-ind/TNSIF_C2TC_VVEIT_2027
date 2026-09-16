package Airfare;
public class Main {
    public static void main(String[] args) {

        // ---- AirIndia
        Airfare airIndia = new AirIndia(5, 1500.0);
        airIndia.display();

        System.out.println();

        // ---- Indigo
        Indigo indigo = new Indigo();
        indigo.setHours(5);
        indigo.setCostPerHour(1500.0);
        indigo.display();
    }
}