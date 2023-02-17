# 🎯 Jaeger Nedir ?

<img src="kapak2">

* Jaeger, dağıtık sistemlerde kullanılan performans izleme ve sorun giderme aracıdır. Jaeger, OpenTracing
  standartlarına uygun olarak çalışan bir çözümdür ve Microservices mimarisinde yer alan uygulamaların, uygulama
  içi ve uygulama arası olaylarını izleyerek, sorunların hızlıca tespit edilmesine ve çözülmesine yardımcı olur.

* Jaeger, her bir isteği bir dizi "span" adı verilen kayıtla izler. Span'lar, bir isteğin farklı aşamalarını temsil
  eden bilgileri içerir ve bu aşamaların ne kadar sürdüğünü, ne kadar kaynak tükettiğini ve hangi hata mesajlarıyla
  karşılaşıldığını belirleyebilir. Jaeger, her bir isteğin izlenebilirliğini artırır ve sorun tespitini hızlandırır.

* Jaeger, Açık Kaynak kodlu bir projedir ve Kubernetes, Docker ve Istio gibi birçok farklı platformda kullanılabilir.
  Ayrıca, Jaeger, REST API ve UI aracılığıyla izlenebilirlik verilerinin toplanması ve analizi için de kullanılabilir.

* Jaeger, birçok büyük ölçekli şirket tarafından kullanılmaktadır ve çeşitli uygulama geliştirme platformlarıyla
  entegre olabilmesi nedeniyle, birçok uygulama geliştiricisi tarafından da tercih edilmektedir.

# 🎯 Span Nedir ?

* Jaeger, OpenTracing standardına uygun olarak, dağıtık sistemlerdeki istekleri izlemek ve sorunları tespit etmek için
  bir dizi kayıt tutar. Bu kayıtlar, "span" adı verilen birimler tarafından temsil edilir.

* Bir span, bir isteğin farklı aşamalarını temsil eden bir kayıttır. Bir istek, bir dizi span ile izlenir ve her bir
  span, isteğin belli bir aşamasını veya işlemini temsil eder. Örneğin, bir web uygulamasında, bir HTTP isteği, bir span
  tarafından başlatılır ve bu span, isteğin alındığı zaman dilimini temsil eder. Daha sonra, istek birkaç farklı mikro
  hizmet tarafından işlenirken, her bir mikro hizmet, bir span oluşturarak isteğin farklı aşamalarını izler. Son olarak,
  sonuç, bir span ile temsil edilen istek tamamlandığında, bir sonlandırma span'ı tarafından temsil edilir.

* Her bir span, aşağıdaki özellikleri içerir:

* Span adı: Span'in hangi işleve ait olduğunu belirten bir isimdir.
* Span başlangıç ve bitiş zamanları: Span'in başladığı ve bittiği zaman aralığını belirler.
* Span durumu: Span'in başarı durumunu belirtir.
* Span etiketleri: Span hakkında ekstra bilgi sağlar.
* Span baglantıları: Span'lar arasındaki parent-child bağlantılarını belirtir.

* Span'lar, bir isteğin izlenebilirliğini arttırır ve sorunların tespitini hızlandırır. Ayrıca, performans
  sorunlarını belirlemede ve iyileştirmede de kullanılır.

<img src="jaeger4">

* Bu, bir span için benzersiz bir tanımlayıcı olan ve "Trace ID", "Span ID" ve "Parent Span ID" olarak adlandırılan üç
  bölümden oluşan bir dizgidir.

* Trace ID: Bir grup Span'i tanımlamak için kullanılan benzersiz bir tanımlayıcıdır. Bir isteğin tüm işlemleri boyunca
  değişmez ve bir isteğin işlemlerinin hiyerarşisini oluşturur.

* Span ID: Bir Span'ı tanımlayan benzersiz bir tanımlayıcıdır. Her Span, kendisini oluşturan işlem veya olayı temsil
  eder.

* Parent Span ID: İşlemlerin bir hiyerarşisi oluşturulduğunda, her bir span, bir önceki span'in altında yer alır ve bir
  parent span'e sahiptir. Parent span ID, bu hiyerarşik ilişkiyi tanımlamak için kullanılır.

# 🎯 Monolithic ve Microservice Mimarisi ?

<img src="jaeger2">

# 🎯 Distributed Tracing Nedir ?

* Distributed tracing, birden fazla bağımsız mikro servisin oluşturduğu dağıtık sistemlerde, bir isteğin tüm
  aşamalarının izlenebilirliğini sağlayan bir izleme yöntemidir.

* Distributed tracing ile her bir istek, birden fazla mikro servis tarafından işlenir ve isteğin geçtiği her bir
  servisin yaptığı işlemler, harcadığı zaman, hata verip vermediği vb. bilgiler izlenerek kaydedilir. Bu bilgiler daha
  sonra bir arayüz üzerinden analiz edilebilir ve sistemdeki sorunlar hızlı bir şekilde tespit edilebilir.

* Distributed tracing, birçok açıdan yararlıdır. Örneğin:

* Performans sorunlarının tespit edilmesini kolaylaştırır.
* Sorunların neden kaynaklandığını daha hızlı bir şekilde belirleyebilirsiniz.
* Sistemdeki farklı servisler arasındaki bağımlılıkların belirlenmesine yardımcı olur.
* Servisler arasındaki iletişim ve veri akışı hakkında daha detaylı bilgi sağlar.

* Distributed tracing, birçok popüler araç ve platform tarafından desteklenmektedir. Bunlar arasında Jaeger, Zipkin,
  AppDynamics ve Dynatrace gibi araçlar yer alır. Bu araçlar, uygulama geliştiricilerinin ve sistem yöneticilerinin,
  dağıtık sistemlerin performansını takip etmelerine ve sorunları hızlı bir şekilde tespit etmelerine yardımcı olur.

## 📌 Gerçek Zamanlı Kullanım Örneği

<img src="jaeger1">

* Örneğin, bir ödeme işlemi birden fazla nedenden dolayı başarısız olmuş olabilir; yanlış kullanıcı girişi, ödeme ağ
  geçidindeki sorun veya arka uçtaki bir veritabanı bileşeni arızası kadar basit olabilir.

* Başarısızlığa neyin neden olduğunu belirlemek için, verilerin ilgili işlemde yer alan tüm birbirine bağlı hizmetler
  arasında ilişkilendirilmesi gerekir. Bu, loglar arasında gezinmek, zaman damgasını ve hizmetler arasındaki verileri
  eşleştirmek saatlerce sürebilirken, dağıtılmış izleme, hizmetlerinizdeki API akışını izler ve tek bir işlem hatasının
  temel nedenini belirlemeyi kolaylaştırır.

# 🎯 Jaeger Basic Kavramlar ?

<img src="jaeger3">

* Span: Bir isteğin farklı aşamalarını temsil eden bir kayıttır. Bir istek, bir dizi span ile izlenir ve her bir span,
  isteğin belli bir aşamasını veya işlemini temsil eder. Her bir span, span adı, başlangıç ve bitiş zamanları, durumu,
  etiketleri ve bağlantıları gibi özellikleri içerir.

* Tracer: Jaeger'ın ana bileşenidir ve span'ların toplanmasından, işlenmesinden ve saklanmasından sorumludur. Tracer,
  span'lar arasındaki ilişkileri takip eder ve kaydedilen verileri analiz ederek sorunları tespit etmeye yardımcı olur.

* Service: Bir servis, bir uygulamanın farklı bölümlerini veya işlevlerini temsil eder. Örneğin, bir web uygulamasında,
  bir servis kullanıcı girişleriyle ilgilenirken, diğer bir servis veritabanı işlemlerini gerçekleştirir.

* Trace: Bir isteğin tüm aşamalarını temsil eden bir kayıttır. Bir trace, birden fazla span içerir ve bir isteğin tüm
  yönleriyle izlenmesini sağlar.

* Baggage: Bir span içinde taşınan, istek boyunca taşınması gereken meta verilerdir. Baggage, isteğin farklı aşamaları
  boyunca kullanılabilecek verileri içerir.

* Context: Bir istekle ilgili verilerin taşındığı yapıdır. Context, bir span'in başlatılmasından, sonlandırılmasına
  kadar olan süre boyunca taşınan verileri içerir.

## 📌 Maven Dependencies

```xml

<dependency>
    <groupId>io.opentracing.contrib</groupId>
    <artifactId>opentracing-spring-jaeger-cloud-starter</artifactId>
    <version>3.3.1</version>
</dependency>
```

## 📌 Docker Compose

```yaml

version: '3.8'
services:
  user-service:
    image: rasitesdmr1486/user-service:1.0
    container_name: user-service-app
    restart: always
    ports:
      - "2000:2000"
    environment:
      - SPRING_APPLICATION_NAME
      - SPRINGDOC_SWAGGER_UI_PATH
      - SPRING_API_DOCS_PATH
      - SPRING_JPA_HIBERNATE_DDL_AUTO
      - SPRING_JPA_SHOW_SQL
      - SPRING_JPA_OPEN_IN_VIEW
      - OPENTRACING_JAEGER_ENABLE
      - OPENTRACING_JAEGER_SERVICE_NAME
      - OPENTRACING_JAEGER_UDP_SENDER_HOST
      - OPENTRACING_JAEGER_UDP_SENDER_PORT
      - OPENTRACING_JAEGER_LOG_SPANS
      - SPRING_DATASOURCE_URL
      - SPRING_DATASOURCE_DRIVERCLASSNAME
      - SPRING_DATASOURCE_USERNAME
      - SPRING_DATASOURCE_PASSWORD
      - SPRING_JPA_DATABASE_PLATFORM
      - SPRING_H2_CONSOLE_ENABLED
      - RESILIENCE4J_SLIDING_WINDOWS_TYPE
      - RESILIENCE4J_SLIDING_WINDOWS_SIZE
      - RESILIENCE4J_MINIMUM_NUMBER_OF_CALLS
      - RESILIENCE4J_PERMITTED_NUMBER_OF_CALLS_IN_HALFOPENSTATE
      - RESILIENCE4J_WAITDURATIONINOPENSTATE
      - RESILIENCE4J_FAILURERATETHRESHOLD
      - RESILIENCE4J_REGISTERHEALTHINDICATOR
      - RESILIENCE4J_EVENTCONSUMERBUFFERSIZE
      - RESILIENCE4J_AUTOMITCTRANSITIONFROM
      - CIRCUITBREAKERS_ENABLED
      - EXPOSURE_INCLUDE
      - HEALTH_SHOW_DETAILS
    depends_on:
      - jaeger
    networks:
      - my-network

  department-service:
    image: rasitesdmr1486/department-service:1.0
    restart: always
    ports:
      - "2001:2001"
    environment:
      - SPRINGDOC_SWAGGER_UI_PATH
      - SPRING_API_DOCS_PATH
      - SPRING_JPA_HIBERNATE_DDL_AUTO
      - SPRING_JPA_SHOW_SQL
      - SPRING_JPA_OPEN_IN_VIEW
      - OPENTRACING_JAEGER_ENABLE
      - OPENTRACING_JAEGER_SERVICE_NAME
      - OPENTRACING_JAEGER_UDP_SENDER_HOST
      - OPENTRACING_JAEGER_UDP_SENDER_PORT
      - OPENTRACING_JAEGER_LOG_SPANS
      - SPRING_DATASOURCE_URL
      - SPRING_DATASOURCE_DRIVERCLASSNAME
      - SPRING_DATASOURCE_USERNAME
      - SPRING_DATASOURCE_PASSWORD
      - SPRING_JPA_DATABASE_PLATFORM
      - SPRING_H2_CONSOLE_ENABLED
      - SPRING_APPLICATION_NAME
    depends_on:
      - jaeger
    networks:
      - my-network
  jaeger:
    image: jaegertracing/all-in-one:latest
    ports:
      - "6831:6831/udp"
      - "16686:16686"
    networks:
      - my-network

  hotrod:
    image: jaegertracing/example-hotrod:latest
    ports:
      - "8080:8080"
    command: [ "all" ]
    environment:
      - JAEGER_AGENT_HOST=jaeger
      - JAEGER_AGENT_PORT=6831
    networks:
      - my-network
    depends_on:
      - jaeger
networks:
  my-network:
    driver: bridge

```

## 📌 docker-compose.yaml

```yaml
docker-compose up --build -d
```

```yaml
docker-compose down -v
```

<img src="docker1">
<img src="jaeger5">
<img src="jaeger6">
<img src="jaeger7">
<img src="jaeger8">