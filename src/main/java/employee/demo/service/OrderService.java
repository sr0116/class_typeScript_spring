package employee.demo.service;

import employee.demo.dto.OrderRequestDTO;
import employee.demo.dto.OrderResponseDTO;

import java.util.List;

public interface OrderService {


  OrderResponseDTO createOrder(OrderRequestDTO dto);


  OrderResponseDTO getOrder(Long orderId);


  List<OrderResponseDTO> getAllOrders();


  OrderResponseDTO updateStatus(Long orderId, String status);
}