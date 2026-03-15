package id.my.ascii;

public class PsGame extends Game {
    // --- PROTECTED PROPERTY ---
    protected String consoleType = "PLAYSTATION";

    private String psVersion;
    private boolean hasVRSupport;

    public PsGame(String id, String title, double pricePerDay,
                  String psVersion, boolean hasVRSupport) {
        super(id, title, pricePerDay);
        setPsVersion(psVersion);
        this.hasVRSupport = hasVRSupport;
    }

    public void checkVRSupport() {
        if (hasVRSupport) {
            System.out.println(getTitle() + " support PS VR! Joss!");
        } else {
            System.out.println(getTitle() + " ga support VR.");
        }
    }

    public String getPsVersion() {
        return psVersion;
    }

    public void setPsVersion(String psVersion) {
        if (psVersion != null && (psVersion.equals("PS4") || psVersion.equals("PS5"))) {
            this.psVersion = psVersion;
        } else {
            System.out.println("Error: Versi PS harus PS4 atau PS5!");
            this.psVersion = "PS5"; // default
        }
    }

    public boolean isHasVRSupport() {
        return hasVRSupport;
    }

    public void setHasVRSupport(boolean hasVRSupport) {
        this.hasVRSupport = hasVRSupport;
    }

    public String getConsoleType() {
        return consoleType;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Konsol: " + consoleType);
        System.out.println("Versi: " + psVersion);
        System.out.println("VR Support: " + (hasVRSupport ? "Ya" : "Tidak"));
        System.out.println("----------------------------------------");
    }
}