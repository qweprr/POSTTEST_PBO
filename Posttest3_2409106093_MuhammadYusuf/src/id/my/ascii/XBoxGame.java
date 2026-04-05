package id.my.ascii;

public class XBoxGame extends Game {
    protected String consoleType = "XBOX";
    private boolean hasGamePass;
    private int controllerCount;

    public XBoxGame(String id, String title, double pricePerDay, boolean hasGamePass, int controllerCount) {
        super(id, title, pricePerDay);
        this.hasGamePass = hasGamePass;
        this.setControllerCount(controllerCount);
    }

    public void activateGamePass() {
        if (this.hasGamePass) {
            System.out.println("Game Pass aktif untuk " + this.getTitle());
        } else {
            System.out.println("Game tidak termasuk Game Pass");
        }

    }

    public boolean isHasGamePass() {
        return this.hasGamePass;
    }

    public void setHasGamePass(boolean hasGamePass) {
        this.hasGamePass = hasGamePass;
    }

    public int getControllerCount() {
        return this.controllerCount;
    }

    public void setControllerCount(int controllerCount) {
        if (controllerCount > 0) {
            this.controllerCount = controllerCount;
        } else {
            System.out.println("Controller minimal 1!");
            this.controllerCount = 1;
        }

    }

    public String getConsoleType() {
        return this.consoleType;
    }

    public void displayInfo() {
        super.displayInfo();
        String var10001 = this.consoleType;
        System.out.println("Konsol: " + var10001);
        System.out.println("Game Pass: " + (this.hasGamePass ? "Ya" : "Tidak"));
        System.out.println("Controller: " + this.controllerCount);
        System.out.println("----------------------------------");
    }
}
