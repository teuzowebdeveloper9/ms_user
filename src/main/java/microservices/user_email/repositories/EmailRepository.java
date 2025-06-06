package microservices.user_email.repositories;

import microservices.user_email.models.EmailModels;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EmailRepository  extends JpaRepository<EmailModels, UUID> {


}
