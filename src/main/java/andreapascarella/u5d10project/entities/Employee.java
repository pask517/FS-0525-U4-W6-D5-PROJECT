package andreapascarella.u5d10project.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "employees")
@NoArgsConstructor
@ToString
public class Employee {

    @Id
    @GeneratedValue
    @Setter(AccessLevel.NONE)
    private UUID employeeId;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String surname;

    @Column(nullable = false)
    private String email;

    private String avatarURL;

    public Employee(String username, String name, String surname, String email) {
        this.username = username;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.avatarURL = "https://ui-avatars.com/api?name=" + this.getName() + "+" + this.getSurname();
    }
}
