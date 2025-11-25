package employee.demo.service;

import employee.demo.dto.OrderRequestDTO;
import employee.demo.dto.OrderResponseDTO;
import employee.demo.en.OrderStatus;

import java.util.List;

public interface OrderService {

  OrderResponseDTO create(OrderRequestDTO dto);

  OrderResponseDTO get(Long id);

  List<OrderResponseDTO> getAll();

  OrderResponseDTO updateStatus(Long id, OrderStatus status);

  void delete(Long id);
}
