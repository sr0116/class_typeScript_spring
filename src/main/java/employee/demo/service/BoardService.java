package employee.demo.service;


import employee.demo.dto.BoardRequestDTO;
import employee.demo.dto.BoardResponseDTO;

import java.util.List;

public interface BoardService {

  BoardResponseDTO create(BoardRequestDTO dto);

  BoardResponseDTO get(Long id);

  List<BoardResponseDTO> getAll();

  BoardResponseDTO update(Long id, BoardRequestDTO dto);

  void delete(Long id);
}