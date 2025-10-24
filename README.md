# Responsi-1-Mobile-H1D023100
Nama : Daan Nabil 
NIM : H1D023100 
Shift Lama : I 
Shift Baru : F

## 🎬 Demo Video

Klik tautan di bawah untuk melihat video demo:  
[🎥 Lihat Video](https://github.com/Nabeel211/Responsi-1-Mobile-H1D023100/blob/main/app/demo/Responsi.mp4)

# Alur Aplikasi

Aplikasi ini menggunakan arsitektur MVVM dengan dukungan Retrofit, LiveData, dan ViewBinding untuk mengelola alur data secara terstruktur.

Berikut penjelasan alur datanya:

1️⃣ Pemanggilan Data dari API

 - Aplikasi menggunakan Football-Data.org API untuk mengambil informasi tentang klub sepak bola, termasuk detail tim, pelatih, dan skuad pemain.
 - Endpoint API diakses melalui interface Api yang didefinisikan di RetrofitInstance menggunakan Retrofit.

2️⃣ Pengelolaan Data di Repository

 - TeamRepository bertugas untuk melakukan request asynchronous ke API.
 - Jika respon berhasil, data JSON dari API akan otomatis diubah menjadi objek Kotlin SearchResponse menggunakan Gson Converter.
 - Repository menyimpan hasilnya dalam MutableLiveData agar bisa diobservasi oleh ViewModel.

3️⃣ Distribusi Data ke ViewModel

 - TeamViewModel bertindak sebagai penghubung antara UI dan repository.
 - ViewModel menerima data LiveData dari repository dan meneruskannya ke komponen UI.
 - Karena LiveData bersifat reaktif, setiap kali data dari API berubah, ViewModel otomatis memberi notifikasi ke Activity atau Fragment yang mengamatinya.

4️⃣ Penyajian Data di Layar

 - Setiap Activity mengamati perubahan dari LiveData di ViewModel.
 - HeadCoachActivity menampilkan nama, tanggal lahir, dan kebangsaan pelatih, serta gambar pelatih dari resource lokal menggunakan Glide.
 - TeamSquadActivity menampilkan daftar pemain dalam RecyclerView, di mana setiap kartu diberi warna berbeda sesuai posisi (Goalkeeper, Defence, Midfield, Offence).
 - Ketika pengguna menekan salah satu pemain, detail pemain muncul di bagian bawah layar menggunakan BottomSheetDialogFragment.