package employee.demo.dto;

import employee.demo.en.OrderStatus;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
public class OrderResponseDTO {

  private Long id;
  private String bookName;
  private String userName;

  private int quantity;
  private Long totalPrice;

  private OrderStatus status;

  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;
}
