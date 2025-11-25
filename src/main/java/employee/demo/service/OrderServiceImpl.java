package employee.demo.service;

import employee.demo.dto.OrderRequestDTO;
import employee.demo.dto.OrderResponseDTO;
import employee.demo.entity.Book;
import employee.demo.entity.Order;
import employee.demo.entity.OrderStatus;
import employee.demo.entity.User;
import employee.demo.repository.BookRepository;
import employee.demo.repository.OrderRepository;
import employee.demo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final BookRepository bookRepository;
    private final UserRepository userRepository;

    @Override
    public OrderResponseDTO createOrder(OrderRequestDTO dto) {

        Book book = bookRepository.findById(dto.getBookId())
                .orElseThrow(() -> new IllegalArgumentException("Book not found"));

        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        Order order = new Order();
        order.setBook(book);
        order.setUser(user);
        order.setQuantity(dto.getQuantity());
        order.setStatus(OrderStatus.PENDING);  // 기본 상태

        Order saved = orderRepository.save(order);

        return convertToResponseDTO(saved);
    }


    @Override
    public OrderResponseDTO getOrder(Long orderId) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new IllegalArgumentException("Order not found"));

        return convertToResponseDTO(order);
    }


    @Override
    public List<OrderResponseDTO> getAllOrders() {
        return orderRepository.findAll()
                .stream()
                .map(this::convertToResponseDTO)
                .collect(Collectors.toList());
    }


    @Override
    public OrderResponseDTO updateStatus(Long orderId, String status) {

        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new IllegalArgumentException("Order not found"));


        order.setStatus(OrderStatus.valueOf(status.toUpperCase()));

        Order saved = orderRepository.save(order);

        return convertToResponseDTO(saved);
    }

    private OrderResponseDTO convertToResponseDTO(Order order) {
        OrderResponseDTO dto = new OrderResponseDTO();

        dto.setOrderId(order.getOrderId());
        dto.setBookName(order.getBook().getBookName());
        dto.setUserName(order.getUser().getUserName());
        dto.setQuantity(order.getQuantity());
        dto.setStatus(order.getStatus());

        return dto;
    }
}
