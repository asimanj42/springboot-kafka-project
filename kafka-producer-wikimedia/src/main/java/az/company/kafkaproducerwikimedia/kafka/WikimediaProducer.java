package az.company.kafkaproducerwikimedia.kafka;

import az.company.kafkaproducerwikimedia.handler.WikimediaChangesHandler;
import com.launchdarkly.eventsource.EventHandler;
import com.launchdarkly.eventsource.EventSource;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.concurrent.TimeUnit;

@Service
@RequiredArgsConstructor
public class WikimediaProducer {

    @Value("${spring.kafka.topic.name}")
    private String wikimediaTopic;
    private static final Logger LOGGER = LoggerFactory.getLogger(WikimediaProducer.class);

    private final KafkaTemplate<String, String> kafkaTemplate;


    public void sendMessage() throws InterruptedException {
        EventHandler handler = new WikimediaChangesHandler(kafkaTemplate, wikimediaTopic);
        String url = "https://stream.wikimedia.org/v2/stream/recentchange";
        EventSource.Builder builder = new EventSource.Builder(handler,URI.create(url));
        EventSource eventSource =  builder.build();
        eventSource.start();
        TimeUnit.MINUTES.sleep(10);
    }



}
