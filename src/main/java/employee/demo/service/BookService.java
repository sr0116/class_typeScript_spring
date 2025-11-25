package employee.demo.service;

import employee.demo.dto.BookRequestDTO;
import employee.demo.dto.BookResponseDTO;

import java.util.List;

public interface BookService {

  BookResponseDTO create(BookRequestDTO dto);

  BookResponseDTO get(Long id);

  List<BookResponseDTO> getAll();

  BookResponseDTO update(Long id, BookRequestDTO dto);

  void delete(Long id);
}
