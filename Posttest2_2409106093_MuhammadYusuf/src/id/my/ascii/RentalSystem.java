package id.my.ascii;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RentalSystem {
    private List<Game> gameList;
    private Scanner scanner;

    public RentalSystem() {
        this.gameList = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    public void addGame() {
        System.out.println("\n=== TAMBAH GAME BARU ===");
        System.out.println("Pilih jenis game:");
        System.out.println("1. XBOX Game");
        System.out.println("2. PlayStation Game");
        System.out.print("Pilihan (1-2): ");

        int choice = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Masukkan ID Game: ");
        String id = scanner.nextLine();

        if (findGameById(id) != null) {
            System.out.println("Error: ID " + id + " udah dipake!");
            return;
        }

        System.out.print("Masukkan Judul Game: ");
        String title = scanner.nextLine();

        System.out.print("Masukkan Harga Sewa per Hari: Rp ");
        double price = scanner.nextDouble();
        scanner.nextLine();

        if (choice == 1) {
            System.out.print("Termasuk Game Pass? (true/false): ");
            boolean hasGamePass = scanner.nextBoolean();

            System.out.print("Jumlah Controller: ");
            int controllerCount = scanner.nextInt();
            scanner.nextLine();

            XBoxGame xboxGame = new XBoxGame(id, title, price, hasGamePass, controllerCount);
            gameList.add(xboxGame);
            System.out.println("Game XBOX berhasil ditambahkan!");

        } else if (choice == 2) {
            System.out.print("Versi PS (PS4/PS5): ");
            String psVersion = scanner.nextLine();

            System.out.print("Mendukung VR? (true/false): ");
            boolean hasVRSupport = scanner.nextBoolean();
            scanner.nextLine();

            PsGame psGame = new PsGame(id, title, price, psVersion, hasVRSupport);
            gameList.add(psGame);
            System.out.println("Game PlayStation berhasil ditambahkan!");

        } else {
            System.out.println("Pilihan ga valid!");
        }
    }

    // --- PUBLIC METHOD (READ) ---
    public void displayAllGames() {
        System.out.println("\n=== DAFTAR SEMUA GAME ===");
        if (gameList.isEmpty()) {
            System.out.println("Kosong bosque, belom ada game.");
            return;
        }

        System.out.println("Total Game: " + gameList.size() + "\n");
        for (int i = 0; i < gameList.size(); i++) {
            System.out.println("Game ke-" + (i + 1));
            gameList.get(i).displayInfo();
        }
    }

    Game findGameById(String id) {
        for (Game game : gameList) {
            if (game.getId().equalsIgnoreCase(id)) {
                return game;
            }
        }
        return null;
    }

    public void updateGame() {
        System.out.println("\n=== UPDATE GAME ===");
        System.out.print("Masukkan ID Game yang mau diupdate: ");
        String id = scanner.nextLine();

        Game game = findGameById(id);
        if (game == null) {
            System.out.println("Error: Game dengan ID " + id + " ga ketemu!");
            return;
        }

        System.out.println("\nData Game Saat Ini:");
        game.displayInfo();

        System.out.println("\nMasukkan data baru (enter aja kalo ga diubah):");

        System.out.print("Judul baru [" + game.getTitle() + "]: ");
        String newTitle = scanner.nextLine();
        if (!newTitle.isEmpty()) {
            game.setTitle(newTitle);
        }

        System.out.print("Harga baru per Hari [Rp " + game.getPricePerDay() + "]: ");
        String priceInput = scanner.nextLine();
        if (!priceInput.isEmpty()) {
            try {
                double newPrice = Double.parseDouble(priceInput);
                game.setPricePerDay(newPrice);
            } catch (NumberFormatException e) {
                System.out.println("Input ga bener, harga ga diubah.");
            }
        }

        System.out.print("Status (tersedia/disewa) [" +
                (game.isAvailable() ? "tersedia" : "disewa") + "]: ");
        String statusInput = scanner.nextLine().toLowerCase();
        if (statusInput.equals("tersedia")) {
            game.setAvailable(true);
        } else if (statusInput.equals("disewa")) {
            game.setAvailable(false);
        }

        if (game instanceof XBoxGame) {
            XBoxGame xboxGame = (XBoxGame) game;

            System.out.print("Game Pass (true/false) [" + xboxGame.isHasGamePass() + "]: ");
            String gpInput = scanner.nextLine();
            if (!gpInput.isEmpty()) {
                xboxGame.setHasGamePass(Boolean.parseBoolean(gpInput));
            }

            System.out.print("Jumlah Controller [" + xboxGame.getControllerCount() + "]: ");
            String ctrlInput = scanner.nextLine();
            if (!ctrlInput.isEmpty()) {
                try {
                    xboxGame.setControllerCount(Integer.parseInt(ctrlInput));
                } catch (NumberFormatException e) {
                    System.out.println("Input ga bener.");
                }
            }

        } else if (game instanceof PsGame) {
            PsGame psGame = (PsGame) game;

            System.out.print("Versi PS (PS4/PS5) [" + psGame.getPsVersion() + "]: ");
            String verInput = scanner.nextLine();
            if (!verInput.isEmpty()) {
                psGame.setPsVersion(verInput);
            }

            System.out.print("VR Support (true/false) [" + psGame.isHasVRSupport() + "]: ");
            String vrInput = scanner.nextLine();
            if (!vrInput.isEmpty()) {
                psGame.setHasVRSupport(Boolean.parseBoolean(vrInput));
            }
        }

        System.out.println("Data game berhasil diupdate!");
    }

    public void deleteGame() {
        System.out.println("\n=== HAPUS GAME ===");
        System.out.print("Masukkan ID Game yang mau dihapus: ");
        String id = scanner.nextLine();

        Game game = findGameById(id);
        if (game == null) {
            System.out.println("Error: Game ga ketemu!");
            return;
        }

        System.out.println("\nGame yang mau dihapus:");
        game.displayInfo();

        System.out.print("Yakin mau dihapus? (y/n): ");
        String confirm = scanner.nextLine();

        if (confirm.equalsIgnoreCase("y")) {
            gameList.remove(game);
            System.out.println("Game berhasil dihapus!");
        } else {
            System.out.println("Penghapusan dibatalin.");
        }
    }

    public void searchGame() {
        System.out.println("\n=== CARI GAME ===");
        System.out.print("Masukkan judul game: ");
        String keyword = scanner.nextLine().toLowerCase();

        List<Game> results = new ArrayList<>();
        for (Game game : gameList) {
            if (game.getTitle().toLowerCase().contains(keyword)) {
                results.add(game);
            }
        }

        if (results.isEmpty()) {
            System.out.println("Ga ada game dengan judul \"" + keyword + "\"");
        } else {
            System.out.println("\nDitemukan " + results.size() + " game:");
            for (Game game : results) {
                game.displayInfo();
            }
        }
    }

    public void showMenu() {
        System.out.println("\n╔════════════════════════════════════╗");
        System.out.println("║   SISTEM PENYEWAAN GAME ONLINE     ║");
        System.out.println("║         XBOX / PLAYSTATION         ║");
        System.out.println("╠════════════════════════════════════╣");
        System.out.println("║ 1. Tambah Game                     ║");
        System.out.println("║ 2. Tampilkan Semua Game            ║");
        System.out.println("║ 3. Update Game                     ║");
        System.out.println("║ 4. Hapus Game                      ║");
        System.out.println("║ 5. Cari Game                       ║");
        System.out.println("║ 0. Keluar                          ║");
        System.out.println("╚════════════════════════════════════╝");
        System.out.print("Pilih menu (0-5): ");
    }

    public void run() {
        int choice;
        do {
            showMenu();
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addGame();
                    break;
                case 2:
                    displayAllGames();
                    break;
                case 3:
                    updateGame();
                    break;
                case 4:
                    deleteGame();
                    break;
                case 5:
                    searchGame();
                    break;
                case 0:
                    System.out.println("\nMakasih udah pake program ini!");
                    System.out.println("Dadah...");
                    break;
                default:
                    System.out.println("\nPilihan ga valid! Coba 0-5.");
            }
        } while (choice != 0);

        scanner.close();
    }
}