package az.company.kafkaconsumerwikimedia.kafka;

import az.company.kafkaconsumerwikimedia.model.Wikimedia;
import az.company.kafkaconsumerwikimedia.repository.WikimediaRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaConsumerWikimedia {
    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumerWikimedia.class);
    private final WikimediaRepository wikimediaRepository;


    @KafkaListener(topics = "${spring.kafka.topic.name}", groupId = "${spring.kafka.consumer.group-id}")
    public void consume(String message) {
        LOGGER.info(String.format("Message in Consumer: %s", message));
        Wikimedia wikimedia = new Wikimedia();
        wikimedia.setWikimediaData(message);
        wikimediaRepository.save(wikimedia);
    }

}
