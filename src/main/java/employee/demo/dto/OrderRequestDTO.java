package employee.demo.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class OrderRequestDTO {

  private Long bookId;
  private Long userId;
  // 주문 수량
  private int quantity;
}
