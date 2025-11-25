package employee.demo.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class BoardResponseDTO {

  private Long id;
  private String title;
  private String content;

  // 작성자 정보
  private Long userId;
  private String userName;

  // 책 정보
  private Long bookId;
  private String bookName;

  private LocalDateTime createdAt;
}