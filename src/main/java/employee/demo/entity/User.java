package employee.demo.entity;


import jakarta.persistence.*;
import lombok.*;
import lombok.extern.log4j.Log4j;

@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
//@Log4j
@Builder
public class User {


    @Id
    @Column(name = "user_id" )
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_name", nullable = false, length = 50)
    private String userName;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private Long age;

}
