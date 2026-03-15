package id.my.ascii;

public class XBoxGame extends Game {
    protected String consoleType = "XBOX";

    private boolean hasGamePass;
    private int controllerCount;

    public XBoxGame(String id, String title, double pricePerDay,
                    boolean hasGamePass, int controllerCount) {
        super(id, title, pricePerDay);
        this.hasGamePass = hasGamePass;
        setControllerCount(controllerCount); // pake setter
    }

    public void activateGamePass() {
        if (hasGamePass) {
            System.out.println("Game Pass udah aktif buat " + getTitle());
        } else {
            System.out.println("Game " + getTitle() + " ga include Game Pass");
        }
    }

    public boolean isHasGamePass() {
        return hasGamePass;
    }

    public void setHasGamePass(boolean hasGamePass) {
        this.hasGamePass = hasGamePass;
    }

    public int getControllerCount() {
        return controllerCount;
    }

    public void setControllerCount(int controllerCount) {
        if (controllerCount > 0) {
            this.controllerCount = controllerCount;
        } else {
            System.out.println("Error: Jumlah controller minimal 1!");
            this.controllerCount = 1; // default
        }
    }

    public String getConsoleType() {
        return consoleType;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Konsol: " + consoleType);
        System.out.println("Game Pass: " + (hasGamePass ? "Ya" : "Tidak"));
        System.out.println("Controller: " + controllerCount);
        System.out.println("----------------------------------------");
    }
}