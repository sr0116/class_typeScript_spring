package employee.demo.service;

import employee.demo.dto.BookRequestDTO;
import employee.demo.dto.BookResponseDTO;
import employee.demo.entity.Book;
import employee.demo.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Override
    public BookResponseDTO create(BookRequestDTO dto) {

        Book book = Book.builder()
                .bookName(dto.getBookName())
                .author(dto.getAuthor())
                .publisher(dto.getPublisher())
                .price(dto.getPrice())
                .description(dto.getDescription())
                .stock(dto.getStock())
                .category(dto.getCategory())
                .isbn(dto.getIsbn())
                .build();

        Book saved = bookRepository.save(book);

        return toResponse(saved);
    }

    @Override
    public BookResponseDTO get(Long id) {

        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Book not found"));

        return toResponse(book);
    }

    @Override
    public List<BookResponseDTO> getAll() {
        return bookRepository.findAll()
                .stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public BookResponseDTO update(Long id, BookRequestDTO dto) {

        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Book not found"));

        book.setBookName(dto.getBookName());
        book.setAuthor(dto.getAuthor());
        book.setPublisher(dto.getPublisher());
        book.setPrice(dto.getPrice());
        book.setDescription(dto.getDescription());
        book.setStock(dto.getStock());
        book.setCategory(dto.getCategory());
        book.setIsbn(dto.getIsbn());

        Book updated = bookRepository.save(book);

        return toResponse(updated);
    }

    @Override
    public void delete(Long id) {

        if (!bookRepository.existsById(id)) {
            throw new IllegalArgumentException("Book not found");
        }

        bookRepository.deleteById(id);
    }

    private BookResponseDTO toResponse(Book book) {

        BookResponseDTO dto = new BookResponseDTO();

        dto.setId(book.getId());
        dto.setBookName(book.getBookName());
        dto.setAuthor(book.getAuthor());
        dto.setPublisher(book.getPublisher());
        dto.setPrice(book.getPrice());
        dto.setDescription(book.getDescription());
        dto.setStock(book.getStock());
        dto.setCategory(book.getCategory());
        dto.setIsbn(book.getIsbn());
        dto.setCreatedAt(book.getCreatedAt());

        return dto;
    }
}
