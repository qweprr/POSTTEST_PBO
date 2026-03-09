package id.my.ascii;

public class XboxGame extends Game {

    private boolean hasGamePass;
    private int controllerCount;

    public XboxGame(String id, String title, double pricePerDay,
                    boolean hasGamePass, int controllerCount) {
        super(id, title, pricePerDay);

        this.hasGamePass = hasGamePass;
        this.controllerCount = controllerCount;
    }

    public void activateGamePass() {
        System.out.println("Game Pass diaktifkan untuk " + getTitle());
    }

    @Override
    public void displayInfo() {
        super.displayInfo();  // Panggil method displayInfo dari Game
        System.out.println("Konsol: XBOX");
        System.out.println("Game Pass: " + (hasGamePass ? "Ya" : "Tidak"));
        System.out.println("Controller: " + controllerCount);
        System.out.println("----------------------------------------");
    }

    public boolean isHasGamePass() { return hasGamePass; }
    public int getControllerCount() { return controllerCount; }
}