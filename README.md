# Yaani Arama Motoru Projesi
Yaani Arama Motoru için Input parametresi olarak alınacak olan web sitelerinin sitemap xml url’lerine HTTP GET request’i gönderilip dönen xml dosyasındaki tüm url’lerin parse edilmesi sağlandı. 

## Getting Started

STS, Java 8, Spring Boot (version 2.6.2), Jpa, Hibernate, H2Database kullanıldı.

### Prerequisites

- Geliştirmeler STS(Spring Tool Suite - Version: 3.9.11.RELEASE) IDE yapıldı. 
- Maven plugin, Spring boot starter, Hibernate, H2Database, jpa, httpclient depenceylerin pom.xml dosyasına eklenilmelidir. 

### Installing

- Proje içi gereksinimler eklendikten sonra proje çalıştırılır. 
- Proje çalıştıktan sonra parse edeceğimiz örnek sitemap leri url ye yazıyoruz. 
- http://localhost:8080/api/url?= (parse olacak sitemap url linkini ekleyip çalıştırmalıdır).
- http://localhost:8080/api/url?url=https://www.hurriyet.com.tr/sitemaps/newssitemap.xml
- http://localhost:8080/h2-console database dataların kontrollerini sağlıyoruz.

  http://localhost:8080/api/url?url=https://www.hurriyet.com.tr/sitemaps/newssitemap.xml

![image](https://user-images.githubusercontent.com/7461070/151677832-fcb1942e-e33b-468a-abb8-d67599bf8b15.png)

![image](https://user-images.githubusercontent.com/7461070/151677864-dfb29dd9-7ebb-45ec-9ba5-1382bb70c422.png)

![image](https://user-images.githubusercontent.com/7461070/151677947-a49b0e6b-8d3c-4977-bd66-31f37daf6cbf.png)


  http://localhost:8080/api/url?url=https://www.woorank.com/sitemap.xml

![image](https://user-images.githubusercontent.com/7461070/151677975-55031d10-12b6-4aa9-94b6-d2deb2ca3244.png)

![image](https://user-images.githubusercontent.com/7461070/151677985-827d1665-4ac2-4b23-be7a-cd6272ddbf37.png)

![image](https://user-images.githubusercontent.com/7461070/151677998-53a20ed7-6e00-4f52-b455-845377717693.png)


## Diğer örnekler 
 http://localhost:8080/api/url?url=https://www.xml-sitemaps.com/download/moz.com-94293da3/sitemap.xml?view=1
 http://localhost:8080/api/url?url=https://www.xml-sitemaps.com/download/artwebtasarim.com.tr-be3958342/sitemap.xml?view=1



