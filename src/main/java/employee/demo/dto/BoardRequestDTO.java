package employee.demo.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardRequestDTO {
  private String title;
  private String content;

  // 작성자
  private Long userId;

  // 대상 책
  private Long bookId;
}
