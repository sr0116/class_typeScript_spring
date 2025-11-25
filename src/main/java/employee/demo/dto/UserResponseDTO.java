package employee.demo.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponseDTO {

  private Long id;         // PK
  private String userName;
  private String email;
  private Long age;
}
