import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import org.json.simple.JSONObject;

import java.util.*;

public class Kafka_producer {

    public static void main(String[] args) {

        Properties config = new Properties();

        config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"local:9092");
        config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, new StringSerializer().getClass().getName());
        config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, new StringSerializer().getClass().getName());

        Producer producer = new KafkaProducer<String, String>(config);



        JSONObject json = new JSONObject();

        json.put("name", "ugur");
        json.put("surname", "buyukyildiz");
        json.put("age", "24");

        ProducerRecord<String, String> rec = new ProducerRecord<>("topic", json.toJSONString());
        producer.send(rec);
        producer.close(); // 1 den fazla veri gondereceksen kapat
        System.out.println("message sent to kafka");



        }


    }

