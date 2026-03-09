package id.my.ascii;

public class PsGame extends Game {

    private String psVersion;  // "PS4" atau "PS5"
    private boolean hasVRSupport;

    public PsGame(String id, String title, double pricePerDay,
                  String psVersion, boolean hasVRSupport) {
        super(id, title, pricePerDay);
        this.psVersion = psVersion;
        this.hasVRSupport = hasVRSupport;
    }

    public void checkVRSupport() {
        if (hasVRSupport) {
            System.out.println(getTitle() + " mendukung PS VR!");
        }
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Konsol: PLAYSTATION");
        System.out.println("Versi: " + psVersion);
        System.out.println("VR Support: " + (hasVRSupport ? "Ya" : "Tidak"));
        System.out.println("----------------------------------------");
    }

    public String getPsVersion() { return psVersion; }
    public boolean isHasVRSupport() { return hasVRSupport; }
}