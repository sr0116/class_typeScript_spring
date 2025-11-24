package employee.demo.service;

import employee.demo.entity.Book;
import employee.demo.entity.Order;
import employee.demo.entity.User;
import employee.demo.repository.BookRepository;
import employee.demo.repository.OrderRepository;
import employee.demo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final BookRepository bookRepository;
    private  final UserRepository userRepository;

    public List<Order> findAll(){
        return orderRepository.findAll();
    }

    public Order save(Order order , Book book, User user){
//        Optional<Book> bookId = bookRepository.findById(book.getBookId());
        order.setBook(book);
        order.setUser(user);

        return  orderRepository.save(order);
    }
    public void delete(Order order){
        orderRepository.delete(order);
    }
}
