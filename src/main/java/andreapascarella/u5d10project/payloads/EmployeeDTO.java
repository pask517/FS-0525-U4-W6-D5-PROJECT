package andreapascarella.u5d10project.payloads;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record EmployeeDTO(
        @NotBlank(message = "Lo username è un campo obbligatorio!")
        @Size(min = 2, max = 30, message = "Lo username deve essere tra i 2 e i 30 caratteri!")
        String username,

        @NotBlank(message = "Il nome proprio è un campo obbligatorio!")
        @Size(min = 2, max = 20, message = "Il nome proprio deve essere tra i 2 e i 20 caratteri!")
        String name,

        @NotBlank(message = "Il cognome è un campo obbligatorio!")
        @Size(min = 2, max = 20, message = "Il cognome deve essere tra i 2 e i 20 caratteri!")
        String surname,

        @NotBlank(message = "L'email è obbligatoria!")
        @Email(message = "L'indirizzo email inserito non è nel formato corretto!")
        String email) {
}
