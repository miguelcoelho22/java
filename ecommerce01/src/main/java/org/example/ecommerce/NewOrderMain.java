package org.example.ecommerce;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;

import scala.util.Properties;

public class NewOrderMain {

    public static void main(String[] args) {
        var producer = new KafkaProducer<String, String>(properties());
    }

    private static Properties properties() {
        var properties = new Properties();
        properties.setProp(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "192.0.0.1:9092");
        properties.setProp(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.ge)
        return properties;
    }
}
