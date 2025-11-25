package employee.demo.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * 주문 생성/수정 시 클라이언트가 넘겨주는 DTO
 */
@Getter
@Setter
public class OrderRequestDTO {

  private Long bookId;  // 어떤 책을 주문했는가
  private Long userId;  // 누가 주문했는가
  private int quantity; // 주문 수량
}
