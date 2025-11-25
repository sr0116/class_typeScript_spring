package employee.demo.web;


import employee.demo.dto.OrderRequestDTO;
import employee.demo.dto.OrderResponseDTO;
import employee.demo.entity.Order;
import employee.demo.service.BookService;
import employee.demo.service.OrderService;
import employee.demo.service.OrderServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    // 조회
    @GetMapping
    public ResponseEntity<List<OrderResponseDTO>> getAllOrders() {

        List<OrderResponseDTO> orders = orderService.getAllOrders();

        return ResponseEntity.ok(orders);
    }
    // 단일 조회
    @GetMapping("/{orderId}")
    public ResponseEntity<OrderResponseDTO> getOrder(
            @PathVariable Long orderId) {

        OrderResponseDTO dto = orderService.getOrder(orderId);

        return ResponseEntity.ok(dto);
    }

    // 주문 생성
    @PostMapping
    public ResponseEntity<OrderResponseDTO> createOrder(
            @RequestBody OrderRequestDTO dto) {

        OrderResponseDTO created = orderService.createOrder(dto);

        return ResponseEntity.ok(created);
    }
    // 수정
    @PutMapping("/{orderId}")
    public ResponseEntity<OrderResponseDTO> updateStatus(
            @PathVariable Long orderId,
            @RequestBody StatusRequest statusRequest) {

        OrderResponseDTO updated =
                orderService.updateStatus(orderId, statusRequest.getStatus());

        return ResponseEntity.ok(updated);
    }
    static class StatusRequest {
        private String status;

        public String getStatus() {
            return status;
        }
        public void setStatus(String status) {
            this.status = status;
        }
    }

}
