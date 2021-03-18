package id.ac.ui.cs.advprog.tutorial3.facade.service;

import org.springframework.stereotype.Service;

/*
 * Asumsikan kelas ini sebagai kelas Client
*/
@Service
public class FacadeServiceImpl implements FacadeService {

    private boolean recentRequestType;
    private String recentRequestValue;

    /*
     * Flow encoding: 
     * 1. Lakukan konversi text menjadi sebuah objek Spell (lihat kode Spell.java)
     * 2. Pastikan jenis Codex yang dipilih adalah AlphaCodex
     * 3. Lakukan langkah-langkah transformasi encoding berikut: 
     * 3.1. Lakukan encoding CelestialTransformation terhadap objek Spell pada poin 1.
     * 3.2. Lakukan encoding AbyssalTransformation terhadap objek Spell pada objek hasil operasi poin 3.1
     * 3.3. Lakukan translasi objek Spell pada poin 3.2 dari AlphaCodex menjadi RunicCodex
     *      (lihat CodexTranslator)
     * (Langkah-langkah transformasi ini tidak perlu dijalankan secara berurutan)
     * 4. Kembalikan teks dari Spell yang sudah ditransformasikan
     * 
     * Hint:
     *  Anda mungkin membutuhkan sebuah kelas baru untuk menangani operasi-operasi tersebut
     * 
     * Latihan: 
     * 1. Buatlah sebuah kelas transformasi baru (masukkan ke dalam package transformation)
     * 2. Buatlah metode encode(Spell spell) dan implementasinya pada kelas tersebut
     * (Perhatikan properti dari Codex yang digunakan pada saat implementasi metode encode())
     * 3. Masukkan kelas yang sudah dibuat ke dalam langkah encoding 
     *    (Lakukan encode() menggunakan kelas tersebut pada langkah encoding)
     * 
     * Hint untuk latihan: 
     *  Untuk kelas transformasi untuk latihan, disarankan menggunakan algoritma kriptografi
     *  sederhana seperti Caesar cipher
     * 
     * Ekspektasi output: 
     *  Teks hasil transformasi dengan Codex Runic (RunicCodex)
     * 
     * Bonus: 
     *  * Langkah-langkah transformasi encoding tidak dieksekusi secara hard-coded
     *  * Inisialisasi kelas transformasi secara hard-coded diperbolehkan
     *  * Nilai bonus hanya diberikan jika:
     *      1. Implementasi Facade Pattern dilakukan dengan benar
     *      2. Soal latihan dikerjakan dengan benar
     *      3. Requirements dari latihan bonus dipenuhi
     *  
     * Hint untuk bonus:
     *  Manfaatkan prinsip-prinsip Object Oriented Programming dan/atau Design Pattern
    */
    @Override
    public String encode(String text){
        return "Implement me";
    }

    /*
     * Flow decoding: 
     * 1a. Lakukan konversi text menjadi sebuah objek Spell (lihat kode Spell.java)
     * 2. Pastikan jenis Codex yang dipilih adalah RunicCodex
     * 3. Lakukan langkah-langkah transformasi decoding
     * (perhatikan urutan langkah-langkah encoding yang dilakukan dan buat 
     *  langkah-langkah decoding sesuai dengan urutan tersebut)
     * 4. Kembalikan teks dari Spell yang sudah ditransformasikan
     * 
     * Hint:
     *  Anda mungkin membutuhkan sebuah kelas baru untuk menangani operasi-operasi tersebut
     * 
     * Latihan: 
     * 1. Pada kelas transformasi yang dibuat di latihan encoding, buatlah metode decode(Spell spell)
     * (Perhatikan properti dari Codex yang digunakan pada saat implementasi metode decode())
     * 2. Pastikan hasil decoding menghasilkan hasil yang sama dengan teks sebelum dilakukan encoding
     * 3. Masukkan kelas yang sudah dibuat ke dalam langkah encoding 
     *    (Lakukan decode() menggunakan kelas tersebut pada langkah transformasi encoding)
     * 
     * Hint untuk latihan: 
     *  Untuk kelas transformasi untuk latihan, disarankan menggunakan algoritma kriptografi
     *  sederhana seperti Caesar cipher
     * 
     * Ekspektasi output: 
     *  * Teks hasil transformasi dengan Codex Alpha (AlphaCodex)
     *  * Teks hasil decoding merupakan teks yang sebelum dilakukan encoding pada teks tersebut
     * 
     * Bonus : 
     *  * Langkah-langkah transformasi decoding tidak dieksekusi secara hard-coded
     *  * Inisialisasi kelas transformasi secara hard-coded diperbolehkan
     *  * Nilai bonus hanya diberikan jika:
     *      1. Implementasi Facade Pattern dilakukan dengan benar
     *      2. Soal latihan dikerjakan dengan benar
     *      3. Requirements dari latihan bonus dipenuhi
     *  
     * Hint untuk bonus:
     *  Manfaatkan prinsip-prinsip Object Oriented Programming dan/atau Design Pattern
    */
    @Override
    public String decode(String code){
        return "Implement me";
    }

    @Override
    public void setRequestType(String requestType){
        recentRequestType = requestType.equals("encode");
    }

    @Override
    public void setRequestValue(String requestValue){
        recentRequestValue = requestValue;
    }

    @Override
    public boolean isRequestEncode(){
        return recentRequestType;
    }

    @Override
    public String getRequestValue(){
        return recentRequestValue;
    }
}
