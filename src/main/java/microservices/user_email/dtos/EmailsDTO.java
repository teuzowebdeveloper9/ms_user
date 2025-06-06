package microservices.user_email.dtos;


import java.util.UUID;

public record EmailsDTO(UUID id,
                        String email,
                        String subject,
                        String message) {
}
