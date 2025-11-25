package employee.demo.dto;

import employee.demo.entity.OrderStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderResponseDTO {

  private Long orderId;
  private String bookName;
  private String userName;
  private int quantity;
  private OrderStatus status;
}