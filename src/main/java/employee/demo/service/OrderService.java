package employee.demo.service;

import employee.demo.repository.BookRepository;
import employee.demo.repository.OrderRepository;
import employee.demo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final BookRepository bookRepository;
    private  final UserRepository userRepository;

}
