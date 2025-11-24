package employee.demo.web;


import employee.demo.entity.Book;
import employee.demo.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/books")
public class BookController {
    private final BookService bookService;

    // 조회
    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {
//        bookService.findAll();
        return ResponseEntity.ok().body(bookService.findAll());
    }

    // 등록
    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody Book book) {
        return ResponseEntity.ok().body(bookService.save(book));
    }

    // 삭제
    @DeleteMapping("/{bookId}")
    public ResponseEntity<Book> deleteBook(@PathVariable Long bookId) throws IllegalAccessException {
        bookService.deleteById(bookId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
