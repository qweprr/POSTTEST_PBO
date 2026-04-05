package id.my.ascii;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RentalSystem {
    private List<Game> gameList = new ArrayList();
    private Scanner scanner;

    public RentalSystem() {
        this.scanner = new Scanner(System.in);
        this.gameList.add(new XBoxGame("G01", "Where Winds Meet", (double)15000.0F, true, 1));
        this.gameList.add(new PsGame("G02", "Wukong", (double)20000.0F, "PS5", true));
        this.gameList.add(new XBoxGame("G03", "Wuthering Waves", (double)18000.0F, false, 1));
        this.gameList.add(new PsGame("G04", "Tower of Fantasy", (double)17000.0F, "PS4", false));
        this.gameList.add(new XBoxGame("G05", "Conqueror Blade", (double)16000.0F, true, 2));
    }

    public void addGame() {
        System.out.println("\n=== TAMBAH GAME ===");
        System.out.println("1. XBOX");
        System.out.println("2. PLAYSTATION");
        System.out.print("Pilih: ");
        int choice = this.scanner.nextInt();
        this.scanner.nextLine();
        System.out.print("ID Game: ");
        String id = this.scanner.nextLine();
        if (this.findGameById(id) != null) {
            System.out.println("ID sudah digunakan!");
        } else {
            System.out.print("Judul: ");
            String title = this.scanner.nextLine();
            System.out.print("Harga per hari: ");
            double price = this.scanner.nextDouble();
            this.scanner.nextLine();
            if (choice == 1) {
                System.out.print("Game Pass (true/false): ");
                boolean gp = this.scanner.nextBoolean();
                System.out.print("Jumlah Controller: ");
                int ctrl = this.scanner.nextInt();
                this.scanner.nextLine();
                this.gameList.add(new XBoxGame(id, title, price, gp, ctrl));
                System.out.println("Game XBOX berhasil ditambah!");
            } else if (choice == 2) {
                System.out.print("Versi (PS4/PS5): ");
                String ver = this.scanner.nextLine();
                System.out.print("VR Support (true/false): ");
                boolean vr = this.scanner.nextBoolean();
                this.scanner.nextLine();
                this.gameList.add(new PsGame(id, title, price, ver, vr));
                System.out.println("Game PS berhasil ditambah!");
            } else {
                System.out.println("Pilihan tidak valid!");
            }

        }
    }

    public void displayAllGames() {
        System.out.println("\n=== DAFTAR GAME ===");
        if (this.gameList.isEmpty()) {
            System.out.println("Belum ada game!");
        } else {
            for(Game game : this.gameList) {
                game.displayInfo();
            }

        }
    }

    public void rentGameMenu() {
        System.out.print("\nMasukkan ID game yang mau disewa: ");
        String id = this.scanner.nextLine();
        Game game = this.findGameById(id);
        if (game == null) {
            System.out.println("Game tidak ditemukan!");
        } else {
            game.rentGame();
        }
    }

    private Game findGameById(String id) {
        for(Game g : this.gameList) {
            if (g.getId().equalsIgnoreCase(id)) {
                return g;
            }
        }

        return null;
    }

    public void showMenu() {
        System.out.println("\n===== RENTAL GAME =====");
        System.out.println("1. Tambah Game");
        System.out.println("2. Lihat Game");
        System.out.println("3. Sewa Game");
        System.out.println("0. Keluar");
        System.out.print("Pilih: ");
    }

    public void run() {
        int pilih;
        do {
            this.showMenu();
            pilih = this.scanner.nextInt();
            this.scanner.nextLine();
            switch (pilih) {
                case 0:
                    System.out.println("Terima kasih!");
                    break;
                case 1:
                    this.addGame();
                    break;
                case 2:
                    this.displayAllGames();
                    break;
                case 3:
                    this.rentGameMenu();
                    break;
                default:
                    System.out.println("Pilihan salah!");
            }
        } while(pilih != 0);

        this.scanner.close();
    }
}
