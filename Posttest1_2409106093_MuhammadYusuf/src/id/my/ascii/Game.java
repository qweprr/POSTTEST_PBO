package id.my.ascii;

public class Game {
    private String id;
    private String title;
    private double pricePerDay;

    public Game(String id, String title, double pricePerDay) {
        this.id = id;
        this.title = title;
        this.pricePerDay = pricePerDay;
    }

    public void displayInfo() {
        System.out.println("ID: " + id);
        System.out.println("Judul: " + title);
        System.out.println("Harga: Rp " + pricePerDay);
    }

    public String getId() { return id; }
    public String getTitle() { return title; }
    public double getPricePerDay() { return pricePerDay; }
}
