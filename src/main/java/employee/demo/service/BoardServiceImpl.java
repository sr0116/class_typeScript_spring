package employee.demo.service;


import employee.demo.dto.BoardRequestDTO;
import employee.demo.dto.BoardResponseDTO;
import employee.demo.entity.Board;
import employee.demo.entity.Book;
import employee.demo.entity.User;
import employee.demo.repository.BoardRepository;
import employee.demo.repository.BookRepository;
import employee.demo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

  private final BoardRepository boardRepository;
  private final UserRepository userRepository;
  private final BookRepository bookRepository;

  @Override
  public BoardResponseDTO create(BoardRequestDTO dto) {

    User user = userRepository.findById(dto.getUserId())
            .orElseThrow(() -> new IllegalArgumentException("User not found"));

    Book book = bookRepository.findById(dto.getBookId())
            .orElseThrow(() -> new IllegalArgumentException("Book not found"));

    Board board = Board.builder()
            .title(dto.getTitle())
            .content(dto.getContent())
            .user(user)
            .book(book)
            .build();

    Board saved = boardRepository.save(board);

    return toResponse(saved);
  }

  @Override
  public BoardResponseDTO get(Long id) {
    Board board = boardRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Board not found"));
    return toResponse(board);
  }

  @Override
  public List<BoardResponseDTO> getAll() {
    return boardRepository.findAll()
            .stream()
            .map(this::toResponse)
            .collect(Collectors.toList());
  }

  @Override
  public BoardResponseDTO update(Long id, BoardRequestDTO dto) {

    Board board = boardRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Board not found"));

    User user = userRepository.findById(dto.getUserId())
            .orElseThrow(() -> new IllegalArgumentException("User not found"));

    Book book = bookRepository.findById(dto.getBookId())
            .orElseThrow(() -> new IllegalArgumentException("Book not found"));

    board.setTitle(dto.getTitle());
    board.setContent(dto.getContent());
    board.setUser(user);
    board.setBook(book);

    Board updated = boardRepository.save(board);

    return toResponse(updated);
  }

  @Override
  public void delete(Long id) {
    if (!boardRepository.existsById(id)) {
      throw new IllegalArgumentException("Board not found");
    }
    boardRepository.deleteById(id);
  }

  private BoardResponseDTO toResponse(Board board) {

    BoardResponseDTO dto = new BoardResponseDTO();

    dto.setId(board.getId());
    dto.setTitle(board.getTitle());
    dto.setContent(board.getContent());

    dto.setUserId(board.getUser().getId());
    dto.setUserName(board.getUser().getUserName());

    dto.setBookId(board.getBook().getId());
    dto.setBookName(board.getBook().getBookName());

    dto.setCreatedAt(board.getCreatedAt());

    return dto;
  }
}
