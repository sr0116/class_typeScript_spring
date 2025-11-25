package employee.demo.service;

import employee.demo.dto.OrderRequestDTO;
import employee.demo.dto.OrderResponseDTO;
import employee.demo.en.OrderStatus;
import employee.demo.entity.Book;
import employee.demo.entity.Order;
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
    public OrderResponseDTO create(OrderRequestDTO dto) {

        Book book = bookRepository.findById(dto.getBookId())
                .orElseThrow(() -> new IllegalArgumentException("Book not found"));

        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        // 총 금액 계산
        Long totalPrice = book.getPrice() * dto.getQuantity();

        Order order = Order.builder()
                .book(book)
                .user(user)
                .quantity(dto.getQuantity())
                .totalPrice(totalPrice)
                .status(OrderStatus.PENDING)
                .build();

        Order saved = orderRepository.save(order);

        return toResponse(saved);
    }

    @Override
    public OrderResponseDTO get(Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Order not found"));

        return toResponse(order);
    }

    @Override
    public List<OrderResponseDTO> getAll() {
        return orderRepository.findAll()
                .stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public OrderResponseDTO updateStatus(Long id, OrderStatus status) {

        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Order not found"));

        order.setStatus(status);

        Order updated = orderRepository.save(order);

        return toResponse(updated);
    }

    @Override
    public void delete(Long id) {
        if (!orderRepository.existsById(id)) {
            throw new IllegalArgumentException("Order not found");
        }
        orderRepository.deleteById(id);
    }

    private OrderResponseDTO toResponse(Order order) {

        OrderResponseDTO dto = new OrderResponseDTO();

        dto.setId(order.getId());
        dto.setBookName(order.getBook().getBookName());
        dto.setUserName(order.getUser().getUserName());
        dto.setQuantity(order.getQuantity());
        dto.setTotalPrice(order.getTotalPrice());
        dto.setStatus(order.getStatus());
        dto.setCreatedAt(order.getCreatedAt());

        return dto;
    }
}
