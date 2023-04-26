# DatabaseTestingWithJDBC

a) Projenin amacı : JDBC kullanarak yazılan SQL sorgusuyla ApachePOI ile TechnoStudyDB' den veriyi excele aktarma.

b) Proje detayları:

    * Projede java programlama dili kullanılarak Maven repostory üzerinden ihtiyaç duyulan dependency eklenerek pom tabanlı çalşıldı.

    * MySQL Connections üzerinden TechnoStudyDB'de mevcut tablolardaki verilerle çalışıldı.

    * DB_Utility class da DBConnectionOpen() methodu ile connection işlemi, DBConnectionClose() methodu ile close işlemi gerçekleştirildi.

    * test1() methodunda yazılan sorguyla 'actor' tablosundaki tüm veriler, ApachePOI kullanarak hafızada excel oluşturuldu,
      sonrasında oluşturulan excel deki 'actor1' isimli sheete create edilerek SQL sorgusuyla çekilen bilgler 'actor1' e yazdırıldı.

    * test2() methodunda yazılan SQL sorgusuyla actor tablosundaki first_name 'A' ile başlayan kişiler alfabetik sıraya göre ve
      last_name bilgileriyle beraber test1() de oluşturulan excele create edilen 'actor2' sheete yazdırıldı.
     
c) Proje test package da DatabaseTest Class dan çalıştırılır.   
      
