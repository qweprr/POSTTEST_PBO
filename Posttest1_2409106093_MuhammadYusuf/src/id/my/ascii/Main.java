package id.my.ascii;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== DEMO PARENT & CHILD CLASS ===\n");

        XboxGame gameXbox = new XboxGame(
                "XB001",
                "Halo Infinite",
                25000,
                true,
                2
        );

        PsGame gamePs = new PsGame(
                "PS001",
                "Spider-Man 2",
                30000,
                "PS5",
                false
        );

        System.out.println(">> INFO GAME XBOX:");
        gameXbox.displayInfo();

        System.out.println("\n>> INFO GAME PLAYSTATION:");
        gamePs.displayInfo();

        System.out.println("\n>> METHOD KHUSUS:");
        gameXbox.activateGamePass();
        gamePs.checkVRSupport();

        System.out.println("\n>> POLYMORPHISM:");
        Game game1 = new XboxGame("XB002", "Forza Horizon", 20000, true, 1);
        Game game2 = new PsGame("PS002", "God of War", 35000, "PS5", true);

        game1.displayInfo();
        game2.displayInfo();
    }
}
