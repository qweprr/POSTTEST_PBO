# LAPORAN PRAKTIKUM

## PENERAPAN POLYMORPHISM PADA SISTEM RENTAL GAME BERBASIS JAVA

### 1. Pendahuluan

Pemrograman Berorientasi Objek (Object Oriented Programming/OOP) merupakan paradigma pemrograman yang menggunakan objek sebagai dasar pengembangan sistem. Salah satu konsep penting dalam OOP adalah **Polymorphism**, yaitu kemampuan suatu method untuk memiliki banyak bentuk atau perilaku berbeda.

Pada praktikum ini dibuat sebuah aplikasi sederhana berupa **Sistem Rental Game** menggunakan bahasa pemrograman Java. Program ini menerapkan konsep **Inheritance**, **Encapsulation**, serta fokus utama pada **Polymorphism** yang terdiri dari:

* Method Overloading (Polimorfisme statis)
* Method Overriding (Polimorfisme dinamis)

---

### 2. Tujuan

Adapun tujuan dari praktikum ini adalah:

1. Memahami konsep Polymorphism dalam Java
2. Mengimplementasikan Method Overloading dan Overriding
3. Membangun sistem rental game berbasis OOP
4. Menerapkan relasi antar class (Inheritance)

---

### 3. Deskripsi Program

Program yang dibuat adalah sistem rental game dengan fitur:

* Menampilkan daftar game
* Menyewa game
* Menghitung biaya sewa berdasarkan durasi dan diskon

Struktur class dalam program terdiri dari:

* **Game (Superclass)**
* **PsGame (Subclass)**
* **XBoxGame (Subclass)**
* **RentalSystem (Controller)**
* **Main (Entry Point)**

---

### 4. Penjelasan Kode Program

#### 4.1 Class Game (Superclass)

Class `Game` merupakan class induk yang memiliki atribut utama:

* `id` → ID game
* `title` → Judul game
* `pricePerDay` → Harga sewa per hari
* `isAvailable` → Status ketersediaan

Class ini juga memiliki method utama seperti:

* `rentGame()`
* `displayInfo()`

##### 🔹 Penerapan Overloading

Method `rentGame()` diimplementasikan dalam beberapa bentuk:

1. `rentGame()` → sewa biasa
2. `rentGame(int days)` → sewa dengan durasi
3. `rentGame(int days, double discount)` → sewa dengan diskon

Hal ini menunjukkan bahwa satu method memiliki banyak bentuk dengan parameter berbeda.

---

#### 4.2 Class PsGame (Subclass)

Class `PsGame` merupakan turunan dari `Game` yang merepresentasikan game PlayStation.

Atribut tambahan:

* `psVersion` (PS4 / PS5)
* `hasVRSupport`

##### 🔹 Penerapan Overriding

Method yang dioverride:

* `rentGame()` → menampilkan info khusus PlayStation
* `displayInfo()` → menampilkan detail tambahan

Hal ini menunjukkan bahwa method yang sama memiliki perilaku berbeda pada subclass.

---

#### 4.3 Class XBoxGame (Subclass)

Class `XBoxGame` juga merupakan turunan dari `Game`.

Atribut tambahan:

* `hasGamePass`
* `controllerCount`

##### 🔹 Penerapan Overriding

Method yang dioverride:

* `rentGame()` → menampilkan jumlah controller
* `displayInfo()` → menampilkan info Game Pass

---

#### 4.4 Class RentalSystem

Class ini berfungsi sebagai pengatur jalannya program.

Fitur utama:

* Menyimpan daftar game (`ArrayList<Game>`)
* Menampilkan semua game
* Menu penyewaan game

##### 🔹 Penerapan Polymorphism

```java
Game game = findGameById(id);
game.rentGame();
```

Pada kode di atas, objek bertipe `Game` dapat memanggil method dari subclass (`PsGame` atau `XBoxGame`) sesuai objek sebenarnya saat runtime.

---

#### 4.5 Class Main

Class `Main` berfungsi sebagai titik awal program.

Menjalankan sistem dengan:

```java
RentalSystem app = new RentalSystem();
app.run();
```

---

### 5. Hasil dan Pembahasan

Program berhasil dijalankan dengan fitur:

* Menampilkan daftar game dari berbagai jenis
* Menyewa game dengan berbagai opsi
* Menghitung total harga sewa

Konsep Polymorphism terbukti berjalan dengan baik, karena:

* Method yang sama menghasilkan output berbeda tergantung objeknya
* Program menjadi lebih fleksibel dan mudah dikembangkan

---

### 6. Kesimpulan

Dari praktikum ini dapat disimpulkan bahwa:

1. Polymorphism memungkinkan satu method memiliki banyak bentuk
2. Method Overloading digunakan untuk variasi parameter
3. Method Overriding digunakan untuk perubahan perilaku pada subclass
4. Penggunaan OOP membuat program lebih terstruktur dan modular