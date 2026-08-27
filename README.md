# CertifyHub - Digital Certificate Management & Verification System

CertifyHub adalah aplikasi Web Statis modern (*Client-Side Web Application*) berbasis **HTML5, Tailwind CSS, JavaScript (ES6+), Canvas API, QRCode.js, jsPDF, dan Firebase JS SDK**.

Aplikasi ini dapat langsung dijalankan di browser manapun tanpa instalasi server backend dan **100% siap di-deploy langsung ke GitHub Pages**, Vercel, Netlify, atau Firebase Hosting.

---

## 🚀 Cara Deploy ke GitHub Pages (Gratis & Cepat)

1. **Push ke GitHub**:
   - Pastikan file `index.html` berada di root repository utama Anda.
   ```bash
   git init
   git add .
   git commit -m "Deploy CertifyHub static web"
   git branch -M main
   git remote add origin https://github.com/USERNAME/NAMA_REPO.git
   git push -u origin main
   ```

2. **Aktifkan GitHub Pages**:
   - Buka repositori Anda di GitHub.
   - Pergi ke menu **Settings** > **Pages** (di sidebar kiri).
   - Pada bagian **Build and deployment > Source**, pilih **Deploy from a branch**.
   - Pada **Branch**, pilih `main` dan folder `/(root)`, lalu klik **Save**.
   - Tunggu sekitar 1-2 menit, website Anda akan langsung aktif di:
     `https://USERNAME.github.io/NAMA_REPO/`

---

## ✨ Fitur Utama Web CertifyHub

1. **Responsive Web UI (Tailwind CSS)**:
   - Tampilan bersih, elegan, dan adaptif untuk Desktop PC/Laptop, Tablet, maupun Smartphone.
2. **Dynamic Canvas Dimensions (Ukuran Menyesuaikan Desain)**:
   - Ukuran sertifikat otomatis menyesuaikan resolusi asli foto/background template yang di-upload (1080p, 4K, A4 300 DPI, Landscape/Portrait).
3. **Link Buat Sendiri (Self-Service Claim)**:
   - Panitia cukup membagikan link khusus event (`?claim=EVENT_ID`) via WhatsApp atau QR Code.
   - Peserta menginput nama sendiri, melihat *Live Preview*, dan mengunduh sertifikat secara instan.
4. **Ekspor Ultra High-Resolution**:
   - Unduh sertifikat langsung dalam format **PNG Resolusi Tinggi** atau **PDF Kualitas Cetak**.
5. **Verifikasi Keaslian Sertifikat (Anti-Palsu via QR Code)**:
   - Setiap sertifikat yang diterbitkan memiliki UUID unik dan QR Code verifikasi resmi (`?verify=UUID`).
6. **Mode Offline & Demo**:
   - Berjalan mandiri dengan penyimpanan lokal browser (*IndexedDB/LocalStorage*) jika Firebase belum dikonfigurasi.
7. **Cloud Ready (Firebase Firestore & Auth)**:
   - Cukup masukkan konfigurasi Firebase Anda di menu Pengaturan untuk sinkronisasi multi-user dan multi-device.

---

## 📁 Struktur File Web Statis

- `index.html` : Seluruh aplikasi frontend web mandiri (HTML, CSS Tailwind, JavaScript & Library).
- `README.md` : Dokumentasi penggunaan dan panduan deployment.
