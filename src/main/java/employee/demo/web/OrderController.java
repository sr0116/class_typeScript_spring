package employee.demo.web;


import employee.demo.entity.Book;
import employee.demo.entity.Order;
import employee.demo.entity.User;
import employee.demo.service.BookService;
import employee.demo.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/order")
public class OrderController {
    private final BookService bookService;
    private final OrderService orderService;

    // 조회
    @GetMapping
    public ResponseEntity<List<Order>> getAllBooks() {
//
        return ResponseEntity.ok().body(orderService.findAll());
    }

    // 주문 생성
    @PostMapping
    public Order createOrder(@RequestBody Order order){
        return orderService.save(order,order.getBook(), order.getUser());
    }

}
