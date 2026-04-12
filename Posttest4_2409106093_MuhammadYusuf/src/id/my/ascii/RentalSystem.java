package id.my.ascii;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RentalSystem {
    private List<Game> gameList = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public RentalSystem() {
        gameList.add(new XBoxGame("G01", "Where Winds Meet", 15000, true, 1));
        gameList.add(new PsGame("G02", "Wukong", 20000, "PS5", true));
        gameList.add(new XBoxGame("G03", "Wuthering Waves", 18000, false, 1));
        gameList.add(new PsGame("G04", "Tower of Fantasy", 17000, "PS4", false));
        gameList.add(new XBoxGame("G05", "Conqueror Blade", 16000, true, 2));
    }

    public void displayAllGames() {
        System.out.println("\n=== DAFTAR GAME ===");
        for (Game game : gameList) {
            game.displayInfo(); // polymorphism
        }
    }

    public void rentGameMenu() {
        System.out.print("\nMasukkan ID game: ");
        String id = scanner.nextLine();

        Game game = findGameById(id);

        if (game == null) {
            System.out.println("Game tidak ditemukan!");
            return;
        }

        System.out.println("1. Sewa biasa");
        System.out.println("2. Sewa + durasi");
        System.out.println("3. Sewa + diskon");
        System.out.print("Pilih: ");
        int pilih = scanner.nextInt();

        if (pilih == 1) {
            game.rentGame();
        } else if (pilih == 2) {
            System.out.print("Jumlah hari: ");
            int hari = scanner.nextInt();
            game.rentGame(hari);
        } else if (pilih == 3) {
            System.out.print("Jumlah hari: ");
            int hari = scanner.nextInt();
            System.out.print("Diskon (0.1 = 10%): ");
            double disc = scanner.nextDouble();
            game.rentGame(hari, disc);
        }

        scanner.nextLine();
    }

    private Game findGameById(String id) {
        for (Game g : gameList) {
            if (g.getId().equalsIgnoreCase(id)) {
                return g;
            }
        }
        return null;
    }

    public void showMenu() {
        System.out.println("\n===== RENTAL GAME =====");
        System.out.println("1. Lihat Game");
        System.out.println("2. Sewa Game");
        System.out.println("0. Keluar");
        System.out.print("Pilih: ");
    }

    public void run() {
        int pilih;
        do {
            showMenu();
            pilih = scanner.nextInt();
            scanner.nextLine();

            switch (pilih) {
                case 1 -> displayAllGames();
                case 2 -> rentGameMenu();
                case 0 -> System.out.println("Terima kasih!");
                default -> System.out.println("Pilihan salah!");
            }
        } while (pilih != 0);
    }
}