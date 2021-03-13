# Tutorial 1

# In This World There Are Different Types of Adventurers with Different Types of Attacks and Different Types of Quests

Setelah pada tutorial sebelumnya (tutorial-0), Anda telah menjalankan amanah untuk membuat sistem menggunakan sihir bernama Spring, dimana sihir ini menggunakan pemahaman Advanced Programming yang Anda miliki. Kali ini di `tutorial-1` kita akan menggunakan sihir Spring lagi untuk melanjutkan perjalanan di dunia ini.


## (Strategy Pattern)
------------------------
Pada `tutorial-1` kali ini, terdapat penjelajah atau ***adventurer*** yang akan melakukan misi mereka dalam melaksanakan Quest di dunia ini, namun sebelum mereka dapat menjalankan Quest, mereka harus berlatih dan mempersiapkan strategi **`attack`** dan **`defense`** sebagaimana para penjelajah pada umumnya, strategi **`attack`** dan **`defense`** tersebut juga dapat dilakukan pergantian sesuai keinginan.

Diberikan `interface` untuk mendukung persiapan strategi dari ***adventurer***, yaitu `AttackBehavior.java` dan `DefenseBehavior.java` yang nantinya akan diimplementasikan dengan tipe Attack dan Defense tertentu.

Langkah selanjutnya Anda sebagai penghuni dunia ini, kalian akan diminta untuk dapat mengimplementasikan strategi kepada tiap ***adventurer***.
Terdapat 4 *package* yang diberikan pada package **startegy**, yaitu **controller**, **core**, **repository**, dan **service**.

1.  Pada package **controller** terdapat `StrategyController.java`, diharapkan kalian dapat menampilkan attribut dari para **adventurer** sehingga dapat ditampilkan pada web ketika Spring Boot dijalankan.
    ```java
    ...
    ...
    @RequestMapping(path = "/all", method = RequestMethod.GET)
    public String strategyHome(Model model) {
        Iterable<AttackBehavior> attackBehaviors = adventurerService.getAttackBehaviors();
        Iterable<DefenseBehavior> defenseBehaviors = adventurerService.getDefenseBehaviors();
        // TODO: Complete Me
        return "strategy/home";
    }
    ...
    ...
    ````
2. Pada package **core** didalamnya terdapat file-file yang berisi class dimana Attack, Defense, dan Adventurer dibuat. Pada bagian ini kalian diharapkan dapat melengkapi **sihir/mantra** attack dan defense untuk para Adventurer.
Penjelasan attack/defense tiap Adventurer:
    >> a. `Agile Adventurer` secara **`default`** memiliki attack behaviour menggunakan **Senjata Api** dan defense behaviour **Penghadang(Barrier)**.

    >> b. `Knight Adventurer` secara **`default`** memiliki attack behaviour menggunakan **Pedang** dan defense behaviour **Armor**.
    
    >> c. `Mystic Adventurer` secara **`default`** memiliki attack behaviour menggunakan **Sihir** dan defense behaviour menggunakan **Perisai**.
    
    I . Adventurer <br>
    Berikut adalah contoh untuk salah satu snippet code `AgileAdventurer.java`, untuk class lain juga tampak kurang lebih seperti ini.
    ```java
    package id.ac.ui.cs.advprog.tutorial1.strategy.core;

    public class AgileAdventurer extends Adventurer {
        // TODO : Complete me
    }
    ```
    II. Attack/Defense Behavior <br>
    Bagian ini merepresentasikan attack/defense behavior yang ada dan sudah diberikan **interface** `AttackBehavior.java`, `DefenseBehaviour.java` dan `Strategy.java`, Contoh snippet code pada `AttackWithGun.java`. Disini kalian diharapkan dapat melengkapi implementasi attack maupun defense dari masing-masing behavior.
    ```java
    public class AttackWithGun implements AttackBehavior {
        // TODO : Complete me
    }
    ```
3. Pada package **service** terdapat file `AdventureServiceImpl.java` disini logic dari strategi dapat diubah, dan tugas kalian adalah melengkapi method `changeStrategy` sehingga setiap adventurer nantinya dapat merubah strategi sesuai rintangan quest yang diberikan.
    ```java
    ...
    @Override
    public void changeStrategy(String alias, String attackType, String defenseType) {
        // TODO: Complete me
    }
    ...
    ```
 4. Tahap terakhir, agar informasi dari tiap **adventurer** dapat dilihat oleh para penduduk sekitar karena penasaran dengan para strategi **adventurer**, maka kalian diberikan tugas tambahan, yaitu membuat/melengkapi template html pada file `home.html` pada folder **resources/template/strategy**.
 
## (Observer Pattern)
Setelah, para ***adventurer*** melakukan penyesuaian terhadap **`attack`** dan **`defense`** masing-masing, selanjutnya terdapat misi-misi yang harus dijalankan ***adventurer*** tersebut. Untuk setiap misi, hanya ***adventurer*** tertentu saja yang bisa mendapatkan misi yang diberikan sehingga dapat dipastikan tidak semua ***adventurer*** bisa mendapatkan misi tersebut, kecuali jika memang ada panggilan dari atasan untuk ikut Quest tersebut.

Kali ini para ***adventurer*** diberikan tugas untuk melaksanakan Quest, Quest tersebut dapat diisi melalui form yang telah disediakan. 
Terdapat 3 ***adventurer***, yaitu : **Agile**, **Knight**, **Mystic** yang siap menjalankan misi. Mereka disini akan menjalankan misi-misi yang telah diberikan sesuai form yang diisi sebelumnya. Form yang diisi tersebut terdiri dari **Judul Misi** dan **Kategori** dari Quest.
>> Catatan: tiap misi yang dijalankan oleh setiap **adventurer** tidak selalu dilakukan bersamaan.

>>> Penjelasan Kategori Quest:<br>
    - Delivery : Seluruh **adventurer** menjalankan Quest Delivery. <br>
    - Rumble   : **Adventurer** **Agile** dan **Knight** saja yang menjalankan Quest Rumble.<br>
    - Escort   : **Adventurer** **Knight** dan **Mystic** saja yang menjalan Quest Escort.<br>
    

Tugas kalian pada kali ini adalah melengkapi tiap implementasi yang ditandai oleh `//TODO: Complete me`.