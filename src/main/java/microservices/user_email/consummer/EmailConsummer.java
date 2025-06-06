package microservices.user_email.consummer;

import microservices.user_email.dtos.EmailsDTO;
import microservices.user_email.models.EmailModel;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.BeanUtils;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class EmailConsummer {

    @RabbitListener(queues =  "${broker.queue.email.name}")
    public void  ListennerEmailQueue(@Payload EmailsDTO emailsDTO){
        var emailModels = new EmailModel();
        BeanUtils.copyProperties(emailsDTO, emailModels);

    }
}
