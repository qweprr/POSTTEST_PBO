package id.my.ascii;

public class PsGame extends Game implements RentalFeatures {
    protected String consoleType = "PLAYSTATION";
    private String psVersion;
    private boolean hasVRSupport;

    public PsGame(String id, String title, double pricePerDay, String psVersion, boolean hasVRSupport) {
        super(id, title, pricePerDay);
        setPsVersion(psVersion);
        this.hasVRSupport = hasVRSupport;
    }

    public void setPsVersion(String psVersion) {
        if (psVersion == null || (!psVersion.equals("PS4") && !psVersion.equals("PS5"))) {
            System.out.println("Versi harus PS4 atau PS5!");
            this.psVersion = "PS5";
        } else {
            this.psVersion = psVersion;
        }
    }

    @Override
    public void rentGame() {
        if (isAvailable()) {
            setAvailable(false);
            System.out.println(getTitle() + " (PS " + psVersion + ") berhasil disewa!");
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
        System.out.println("Versi: " + psVersion);
        System.out.println("VR Support: " + (hasVRSupport ? "Ya" : "Tidak"));
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