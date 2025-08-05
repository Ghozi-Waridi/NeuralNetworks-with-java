# Java Neural Networks from Scratch

![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)
![Status: In-Development](https://img.shields.io/badge/status-in_development-orange.svg)
![Contributions: Welcome](https://img.shields.io/badge/contributions-welcome-brightgreen.svg)

Selamat datang di **Java Neural Networks from Scratch**! Proyek ini saya buat untuk belajar *Neural Networks* yang dibangun sepenuhnya dari awal tanpa menggunakan library apapun hanya menggunakan package dari java itu sendiri seperti math arraylist dll. 

Tujuan utama proyek ini untuk edukasi: menyediakan tempat untuk melakukan kolaborasi github, sambil belajar algoritma neural networks, project ini terbuka untuk umum jadi siapapun bisa mengikutinya. asalkan mengikuti aturan dan cara kerja yang sudah ditetapkan.

---

## ⭐️ Fitur Utama
- **Zero Dependencies**: Dibangun murni dengan java untuk memahami algoritma di balik *neural networks* ini dengan pemahaman yang maksimal.
- **Arsitektur Modular**: Pemisahan file file project `Layers`, `Activation Function`, `Loss Function` dan `Optimizers` untuk keterbacaan code.
- **Orientasi Object**: Desain yang bersih memanfaatkan prinsip-prinsip OOP.
- **Terbuka untuk Kolaborasi**: Proyek ini hidup bagi siapapun yang punya keinginan.

## 🗂️ Struktur Proyek

Untuk memudahkan navigasi dan kontribusi, proyek ini diorganisis ke dalam beberapa folder.

neural-network-from-scratch/ ## Nama Proyek
├── bin/ ## Tempat file file hasil kompilasi (.class)
├── src/ ## 
│   └── com/
│       └── neuralnetworks/
│           ├── activations/ 
│           │   ├── ActivationFunction.java   (Interface)
│           │   ├── ReLU.java
│           │   └── Sigmoid.java
│           │
│           ├── data/
│           │   └── DataLoader.java
│           │
│           ├── layers/
│           │   ├── Layer.java                (Abstract Class)
│           │   └── DenseLayer.java
│           │
│           ├── loss/
│           │   ├── LossFunction.java         (Interface)
│           │   └── MeanSquaredError.java
│           │
│           ├── math/
│           │   └── Matrix.java
│           │
│           ├── networks/
│           │   └── NeuralNetwork.java
│           │
│           ├── optimizers/
│           │   ├── Optimizer.java            (Interface)
│           │   └── SGD.java
│           │
│           └── App.java                      (Main Entry Point)
│
├── test/
│   └── (file-file tes untuk setiap komponen)
│
├── .gitignore
├── LICENSE
└── README.md




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






