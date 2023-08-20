package az.company.kafkaproducerwikimedia;

import az.company.kafkaproducerwikimedia.kafka.WikimediaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KafkaProducerWikimediaApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(KafkaProducerWikimediaApplication.class, args);
    }

    @Autowired
    private WikimediaProducer wikimediaProducer;


    @Override
    public void run(String... args) throws Exception {
        wikimediaProducer.fetchDataWithRestTemplate();
    }
}