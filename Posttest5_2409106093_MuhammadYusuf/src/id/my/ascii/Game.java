package id.my.ascii;

public abstract class Game {
    private String id;
    private String title;
    private double pricePerDay;
    private boolean isAvailable;

    public Game(String id, String title, double pricePerDay) {
        this.id = id;
        this.title = title;
        setPricePerDay(pricePerDay);
        this.isAvailable = true;
    }

    // ABSTRACT METHOD
    public abstract void displayInfo();

    boolean validatePrice(double price) {
        return price > 0;
    }

    public String getId() { return id; }
    public String getTitle() { return title; }

    public void setTitle(String title) {
        if (title != null && !title.isEmpty()) {
            this.title = title;
        } else {
            System.out.println("Error: Judul ga boleh kosong!");
        }
    }

    public double getPricePerDay() { return pricePerDay; }

    public void setPricePerDay(double pricePerDay) {
        if (validatePrice(pricePerDay)) {
            this.pricePerDay = pricePerDay;
        } else {
            System.out.println("Error: Harga harus > 0!");
            this.pricePerDay = 0;
        }
    }

    public boolean isAvailable() { return isAvailable; }
    public void setAvailable(boolean available) { isAvailable = available; }

    public void rentGame() {
        if (isAvailable) {
            isAvailable = false;
            System.out.println(title + " berhasil disewa!");
        } else {
            System.out.println(title + " sedang tidak tersedia.");
        }
    }

    public void rentGame(int days) {
        if (isAvailable) {
            isAvailable = false;
            double total = pricePerDay * days;
            System.out.println(title + " disewa " + days + " hari.");
            System.out.println("Total: Rp " + total);
        } else {
            System.out.println(title + " sedang tidak tersedia.");
        }
    }

    public void rentGame(int days, double discount) {
        if (isAvailable) {
            isAvailable = false;
            double total = pricePerDay * days;
            total -= total * discount;
            System.out.println(title + " disewa " + days + " hari (diskon " + (discount * 100) + "%)");
            System.out.println("Total bayar: Rp " + total);
        } else {
            System.out.println(title + " sedang tidak tersedia.");
        }
    }
}