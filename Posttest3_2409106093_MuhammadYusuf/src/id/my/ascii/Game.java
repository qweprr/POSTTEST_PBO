package id.my.ascii;

public class Game {
    private String id;
    private String title;
    private double pricePerDay;
    private boolean isAvailable;

    public Game(String id, String title, double pricePerDay) {
        this.id = id;
        this.title = title;
        this.setPricePerDay(pricePerDay);
        this.isAvailable = true;
    }

    boolean validatePrice(double price) {
        return price > (double)0.0F;
    }

    public String getId() {
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        if (title != null && !title.isEmpty()) {
            this.title = title;
        } else {
            System.out.println("Error: Judul ga boleh kosong!");
        }

    }

    public double getPricePerDay() {
        return this.pricePerDay;
    }

    public void setPricePerDay(double pricePerDay) {
        if (this.validatePrice(pricePerDay)) {
            this.pricePerDay = pricePerDay;
        } else {
            System.out.println("Error: Harga harus > 0!");
            this.pricePerDay = (double)0.0F;
        }

    }

    public boolean isAvailable() {
        return this.isAvailable;
    }

    public void setAvailable(boolean available) {
        this.isAvailable = available;
    }

    public void rentGame() {
        if (this.isAvailable) {
            this.isAvailable = false;
            System.out.println(this.title + " berhasil disewa!");
        } else {
            System.out.println(this.title + " sedang tidak tersedia.");
        }

    }

    public void displayInfo() {
        String var10001 = this.id;
        System.out.println("ID: " + var10001);
        var10001 = this.title;
        System.out.println("Judul: " + var10001);
        double var2 = this.pricePerDay;
        System.out.println("Harga: Rp " + var2);
        System.out.println("Status: " + (this.isAvailable ? "Tersedia" : "Disewa"));
    }
}
