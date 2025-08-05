# Java Neural Networks from Scratch

![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)
![Status: In-Development](https://img.shields.io/badge/status-in_development-orange.svg)
![Contributions: Welcome](https://img.shields.io/badge/contributions-welcome-brightgreen.svg)

Selamat datang di **Java Neural Networks from Scratch**! Proyek ini kami buat untuk belajar *Neural Networks* yang dibangun sepenuhnya dari awal tanpa menggunakan library apapun hanya menggunakan package dari java itu sendiri seperti math arraylist dll. 

Tujuan utama proyek ini untuk edukasi: menyediakan tempat untuk melakukan kolaborasi github, sambil belajar algoritma neural networks, project ini terbuka untuk umum jadi siapapun bisa mengikutinya. asalkan mengikuti aturan dan cara kerja yang sudah ditetapkan.

---

## ⭐️ Fitur Utama
- **Zero Dependencies**: Dibangun murni dengan java untuk memahami algoritma di balik *neural networks* ini dengan pemahaman yang maksimal.
- **Arsitektur Modular**: Pemisahan file file project `Layers`, `Activation Function`, `Loss Function` dan `Optimizers` untuk keterbacaan code.
- **Orientasi Object**: Desain yang bersih memanfaatkan prinsip-prinsip OOP.
- **Terbuka untuk Kolaborasi**: Proyek ini hidup bagi siapapun yang punya keinginan.

## 🗂️ Struktur Proyek

Untuk memudahkan navigasi dan kontribusi, proyek ini diorganisis ke dalam beberapa folder.
```text
neural-network-from-scratch/ ## Nama Proyek
├── bin/ ## Tempat file file hasil kompilasi (.class)
├── src/ ## Direktori utama untuk semua source code
│   └── com/
│       └── neuralnetworks/
│           ├── activations/  ## Implementasi berbagai fungsi aktivasi
│           │   ├── ActivationFunction.java   (Interface)
│           │   ├── ReLU.java
│           │   └── Sigmoid.java
│           │
│           ├── data/ ## Utilitas untuk memuat dan memproses data
│           │   └── DataLoader.java
│           │
│           ├── layers/ ## Block pembangun jaringan (misall: DenseLayer)
│           │   ├── Layer.java                (Abstract Class)
│           │   └── DenseLayer.java
│           │
│           ├── loss/ ## Fungsi untuk menghitung error model
│           │   ├── LossFunction.java         (Interface)
│           │   └── MeanSquaredError.java
│           │
│           ├── math/ ## Logika Matematika inti
│           │   └── Matrix.java
│           │
│           ├── networks/ ## Kelas Utama yang membangun jaringan NeuralNetworks
│           │   └── NeuralNetwork.java
│           │
│           ├── optimizers/ ## Algoritma untuk memperbarui oObot (function optimizer)
│           │   ├── Optimizer.java            (Interface)
│           │   └── SGD.java
│           │
│           └── App.java ## Titik masuk utama aplikasi (Main)
│
├── test/
│   └── (file-file tes untuk setiap komponen)
│
├── .gitignore
├── LICENSE
└── README.md
```



## 🚀 Memulai 
Untuk menjalankan proyek ini silahkan ikuti langkah langkah berikut: 

### Prasyarat
- Java Development Kit (JDK) 11 (saran gunakan JDK 23)
- Git.

### Instalasi  & Menjalankan
1. **Clone Repository ini:**
   ```sh
   git clone https://github.com/Ghozi-Waridi/NeuralNetworks-with-java.git

   cd NeuralNetworks-with-java
   ```
   
2. **Buka dengan IDE (Code Editor) Kalian:**
   Buka folder proyek di code editor kesayangan kalian
   
3. **Kompilasi & Jalankan:**
   Jalankan Project untuk melakukan kompilasi. di file `APP.java` pada folder ` src/com/neuralnetworks/ `.
   
## 🤝 Cara Berkolaborasi

Project ini terbuka bagi siapapun, kami siap menampung semua kontribusi kalian, dalam bentuk penambahan fitur, perbaikan bug, atau peningkatan dokumentasi. Setiap konribusi kalian adalah kebahagiaan bagi kita semua !!

Berikut langkah-langkah utnuk memulai berkontribusi:

1.  **Fork Repositori**
    Klik tombol "Fork" di sudut kanan atas halaman ini untuk membuat salinan repositori ini di akun GitHub Anda.

2.  **Buat Branch Baru**
    Buat branch baru dari branch `main` untuk mengerjakan perubahan Anda. Gunakan nama branch yang deskriptif.
    ```sh
    # Contoh nama branch
    git checkout -b feature/add-tanh-activation
    # atau
    git checkout -b fix/tensor-transpose-bug
    ```

3.  **Lakukan Perubahan Anda**
    Tulis kode Anda. Pastikan untuk mengikuti gaya penulisan kode yang sudah ada. Jika Anda menambahkan fitur baru, jangan lupa untuk menambahkan *unit test* yang relevan di dalam direktori `test/`.

4.  **Commit Perubahan Anda**
    Tulis pesan commit yang jelas dan ringkas (ikuti penulisan https://gist.github.com/rishavpandey43/84665ffe3cea76400d8e5a1ad7133a79).
    ```sh
    git commit -m ":start: feat: Menambahkan fungsi aktivasi Tanh"
    # atau
    git commit -m ":bug: fix: Memperbaiki bug pada metode transpose Tensor"
    ```

5.  **Push ke Branch Anda**
    Unggah perubahan Anda ke repositori fork Anda.
    ```sh
    git push origin feature/add-tanh-activation
    ```

6.  **Buka Pull Request (PR)**
    Buka halaman repositori asli dan klik tombol "New pull request". Pilih branch Anda sebagai sumber dan branch `main` dari repositori asli sebagai tujuan. Berikan judul dan deskripsi yang jelas tentang apa yang dilakukan oleh PR Anda.

Tim kami akan meninjau PR Anda sesegera mungkin. Terima kasih telah berkontribusi!


## 🗺️ Roadmap / Rencana Pengembangan

Berikut adalah beberapa fitur dan tugas yang kami rencanakan untuk ditambahkan. Ini adalah tempat yang bagus untuk mencari ide jika Anda ingin berkontribusi!

- [ ] **Matematika**: Implementasi `transpose`, `mean`, `max`, `sum`, DLL.
- [ ] **Fungsi Aktivasi**: Menambahkan `Tanh`, `Softmax`, `LeakyReLU`, DLL.
- [ ] **Fungsi Loss**: Menambahkan `CrossEntropyLoss`, DLL.
- [ ] **Optimizer**: Menambahkan `Adam`, DLL.
- [ ] **Layer**: Implementasi `ConvolutionalLayer`, `PoolingLayer` DLL.


## 📜 Lisensi

Proyek ini dilisensikan di bawah Lisensi MIT. Lihat file `LICENSE` untuk detail lebih lanjut.





