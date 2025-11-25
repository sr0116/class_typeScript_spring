package employee.demo.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequestDTO {
  // 유저 이름
  private String userName;

  // 이메일(유니크)
  private String email;

  // 나이
  private Long age;
}
