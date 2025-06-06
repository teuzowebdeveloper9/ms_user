package microservices.user_email.consummer;

import microservices.user_email.dtos.EmailsDTO;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class EmailConsummer {

    @RabbitListener(queues =  "${broker.queue.email.name}")
    public void  ListennerEmailQueue(@Payload EmailsDTO emailsDTO){
        System.out.println(emailsDTO.email());

    }
}
