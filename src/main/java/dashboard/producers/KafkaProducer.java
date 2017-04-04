package dashboard.producers;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

public class KafkaProducer{
	private static final Logger logger = Logger.getLogger(KafkaProducer.class);
	
	
	@Autowired
	private KafkaTemplate<Integer, String> kafkaTemplate;

	public KafkaProducer(){}

	public KafkaProducer(String test){
		kafkaTemplate = new  KafkaProducerFactory().kafkaTemplate();
	}
	
	public void send(String topic, String data) {
		ListenableFuture<SendResult<Integer, String>> future = kafkaTemplate.send(topic, data);
		future.addCallback(new ListenableFutureCallback<SendResult<Integer, String>>() {
			@Override
			public void onSuccess(SendResult<Integer, String> result) {
				logger.info("Success on sending message \"" + data + "\" to topic " + topic);
			}
			
			@Override
			public void onFailure(Throwable ex) {
				logger.error("Error on sending message \"" + data + "\", stacktrace" + ex.getMessage());
			}
		});
	}
}
