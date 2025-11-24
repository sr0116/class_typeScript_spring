package employee.demo.service;

import employee.demo.entity.Book;
import employee.demo.repository.BookRepository;
import employee.demo.repository.OrderRepository;
import employee.demo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {
    private final OrderRepository orderRepository;
    private final BookRepository bookRepository;
    private  final UserRepository userRepository;


    // 전체 조회
    public List<Book> findAll( ) {
        return bookRepository.findAll();
    }
//    아이디에 맞게 조회
    public Book findById (Book book){
        return bookRepository.getOne(book.getBookId());
    }

//     생성
    public Book save(Book book){
        return bookRepository.save(book);
    }

    // 삭제 (객체로 받을 때)
    public void delete(Book book){
        bookRepository.delete(book);
    }

    // 아이디만 받을 때
    @Transactional
    public void deleteById(Long bookId) throws IllegalAccessException {
        if (!bookRepository.existsById(bookId)) {
            throw new IllegalAccessException();
        }
         bookRepository.deleteById(bookId);
    }
}
