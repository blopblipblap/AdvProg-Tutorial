## Lazy Instantiation
Lazy Instatiation adalah salah satu dari dua cara implementasi yang dapat dilakukan
di Singleton Pattern. Lazy Instantiation adalah dimana instance dari Singleton di instantiasi
ketika method getInstance() dipanggil. Maka instantiasi ini dilakukan di dalam method getInstance()
dan dicek terlebih dahulu apakah instance sudah terbuat atau belum (null). Jika belum terbuat,
maka instance Singleton akan diinisialisasi. 

* Keuntungan
1. Hemat memory karena objek dibuat hanya ketika dipanggil (menghindari objek yang redundant)
2. Bisa dibuat exception handling

* Kekurangan
1. Tidak thread safe (multithreading)
2. Method harus dipanggil terlebih dahulu untuk membuat objek
3. Codingan terlihat lebih berantakan
    
## Eager Instantiation
Eager Instantiation adalah ketika instance Singleton di instantiasi ketika kelas terpanggil. Seperti yang
kita tahu, kelas akan dipanggil ketika kita mengeksekusi aplikasi kita, maka Singleton akan membuat
instancenya saat aplikasi dijalankan. 

* Keuntungan
1. Codingan terlihat lebih clean
2. Thread safe
3. Objek sudah siap pakai ketika aplikasi dijalankan

* Kekurangan
1. Boros memory ketika ada objek yang redundant
2. Tidak bisa membuat exception handling