package id.my.ascii;

public class Game {
    private String id;
    private String title;
    private double pricePerDay;
    private boolean isAvailable;

    boolean validatePrice(double price) {
        return price > 0;
    }

    public Game(String id, String title, double pricePerDay) {
        this.id = id;
        this.title = title;
        setPricePerDay(pricePerDay); // pake setter biar divalidasi
        this.isAvailable = true;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if (title != null && !title.isEmpty()) {
            this.title = title;
        } else {
            System.out.println("Error: Judul game ga boleh kosong!");
        }
    }

    public double getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(double pricePerDay) {
        if (validatePrice(pricePerDay)) {
            this.pricePerDay = pricePerDay;
        } else {
            System.out.println("Error: Harga harus lebih dari 0!");
            this.pricePerDay = 0;
        }
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public void displayInfo() {
        System.out.println("ID: " + id);
        System.out.println("Judul: " + title);
        System.out.println("Harga: Rp " + pricePerDay);
        System.out.println("Status: " + (isAvailable ? "Tersedia" : "Disewa"));
    }
}