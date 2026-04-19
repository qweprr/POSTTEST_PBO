package id.my.ascii;

public class XBoxGame extends Game implements RentalFeatures {
    protected String consoleType = "XBOX";
    private boolean hasGamePass;
    private int controllerCount;

    public XBoxGame(String id, String title, double pricePerDay, boolean hasGamePass, int controllerCount) {
        super(id, title, pricePerDay);
        this.hasGamePass = hasGamePass;
        setControllerCount(controllerCount);
    }

    public void setControllerCount(int controllerCount) {
        if (controllerCount > 0) {
            this.controllerCount = controllerCount;
        } else {
            System.out.println("Controller minimal 1!");
            this.controllerCount = 1;
        }
    }

    @Override
    public void rentGame() {
        if (isAvailable()) {
            setAvailable(false);
            System.out.println(getTitle() + " (XBOX) disewa dengan "
                    + controllerCount + " controller!");
        } else {
            System.out.println(getTitle() + " sedang tidak tersedia.");
        }
    }

    @Override
    public void displayInfo() {
        System.out.println("ID: " + getId());
        System.out.println("Judul: " + getTitle());
        System.out.println("Harga: Rp " + getPricePerDay());
        System.out.println("Status: " + (isAvailable() ? "Tersedia" : "Disewa"));
        System.out.println("Konsol: " + consoleType);
        System.out.println("Game Pass: " + (hasGamePass ? "Ya" : "Tidak"));
        System.out.println("Controller: " + controllerCount);
        System.out.println("----------------------------------");
    }

    @Override
    public void applyDiscount(double discount) {
        double hargaBaru = getPricePerDay() - (getPricePerDay() * discount);
        System.out.println("Harga setelah diskon: Rp " + hargaBaru);
    }

    @Override
    public void showRentalStatus() {
        System.out.println(getTitle() + " status: " + (isAvailable() ? "Tersedia" : "Disewa"));
    }
}