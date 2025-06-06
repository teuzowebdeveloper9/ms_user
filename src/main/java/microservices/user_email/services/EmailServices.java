package microservices.user_email.services;


import microservices.user_email.enums.StatusEmail;
import microservices.user_email.models.EmailModel;
import microservices.user_email.repositories.EmailRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class EmailServices {

    final EmailRepository emailRepository;
    final JavaMailSender javaMailSender;

    public EmailServices(EmailRepository emailRepository, JavaMailSender javaMailSender) {
        this.emailRepository = emailRepository;
        this.javaMailSender = javaMailSender;
    }


    @Value(value = "${broker.queue.email.name}")
    private  String emailFrom;

    @Transactional
    public EmailModel sendEmail(EmailModel emailModel){
        try{
            emailModel.setCreateTime(LocalDateTime.now());
            emailModel.setEmailTo(emailFrom);


            SimpleMailMessage message = new SimpleMailMessage();

            message.setTo(emailModel.getEmailTo());
            message.setSubject(emailModel.getSubject());
            message.setText(emailModel.getText());

            javaMailSender.send(message);

            emailModel.setStatusEmail(StatusEmail.SENT);
        }catch (MailException e){
            emailModel.setStatusEmail(StatusEmail.ERROR);
        }finally {
            return emailRepository.save(emailModel);
        }

    }


}
