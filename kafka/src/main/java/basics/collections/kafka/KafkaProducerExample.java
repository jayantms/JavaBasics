package basics.collections.kafka; 

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.*;

import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

public class KafkaProducerExample {
    private static final String TOPIC = "testtopic-1";
    private static final String BOOTSTRAP_SERVERS = "localhost:9092";

    public static void main(String[] args) {
        Properties props = new Properties();
        props.put("bootstrap.servers", BOOTSTRAP_SERVERS);
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

		List<Employee> llinkedList = new LinkedList<Employee>();
        Employee l1 = new Employee(1,"Abcd"); 
        Employee l2 = new Employee(2,"Pqrs"); 
        Employee l3 = new Employee(3,"rstv"); 
        Employee l4 = new Employee(4,"lmno"); 

        llinkedList.add(l1);
        llinkedList.add(l2);
        llinkedList.add(l3);
        llinkedList.add(l4);
        
        try (Producer<String, String> producer = new KafkaProducer<>(props)) {
            for (int i = 0; i < 4; i++) {
                String key = Integer.toString(i);
                String value = "message again - " + i;
                
                Employee e1 = llinkedList.get(i); 
                
                producer.send(new ProducerRecord<>(TOPIC, key, e1.toString()),
                    (metadata, exception) -> {
                        if (exception == null) {
                            System.out.printf("Sent message: key=%s, value=%s%n", key, e1.toString());
                        } else {
                            exception.printStackTrace();
                        }
                    });
            }
        }
    }
}
