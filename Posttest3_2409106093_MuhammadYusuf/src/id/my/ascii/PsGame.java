package id.my.ascii;

public class PsGame extends Game {
    protected String consoleType = "PLAYSTATION";
    private String psVersion;
    private boolean hasVRSupport;

    public PsGame(String id, String title, double pricePerDay, String psVersion, boolean hasVRSupport) {
        super(id, title, pricePerDay);
        this.setPsVersion(psVersion);
        this.hasVRSupport = hasVRSupport;
    }

    public void checkVRSupport() {
        if (this.hasVRSupport) {
            System.out.println(this.getTitle() + " support VR!");
        } else {
            System.out.println(this.getTitle() + " tidak support VR.");
        }

    }

    public String getPsVersion() {
        return this.psVersion;
    }

    public void setPsVersion(String psVersion) {
        if (psVersion == null || !psVersion.equals("PS4") && !psVersion.equals("PS5")) {
            System.out.println("Versi harus PS4 atau PS5!");
            this.psVersion = "PS5";
        } else {
            this.psVersion = psVersion;
        }

    }

    public boolean isHasVRSupport() {
        return this.hasVRSupport;
    }

    public void setHasVRSupport(boolean hasVRSupport) {
        this.hasVRSupport = hasVRSupport;
    }

    public void displayInfo() {
        super.displayInfo();
        String var10001 = this.consoleType;
        System.out.println("Konsol: " + var10001);
        var10001 = this.psVersion;
        System.out.println("Versi: " + var10001);
        System.out.println("VR Support: " + (this.hasVRSupport ? "Ya" : "Tidak"));
        System.out.println("----------------------------------");
    }
}
