package microservices.user_email.repositories;

import microservices.user_email.models.EmailModel;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.messaging.handler.annotation.Payload;

import java.util.UUID;

public interface EmailRepository  extends JpaRepository<EmailModel, UUID> {

 
}
