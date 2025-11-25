package employee.demo.web;

import employee.demo.dto.BoardRequestDTO;
import employee.demo.dto.BoardResponseDTO;
import employee.demo.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/boards")
@RequiredArgsConstructor
public class BoardController {

  private final BoardService boardService;

  @GetMapping
  public ResponseEntity<List<BoardResponseDTO>> getAll() {
    return ResponseEntity.ok(boardService.getAll());
  }

  @GetMapping("/{id}")
  public ResponseEntity<BoardResponseDTO> get(@PathVariable Long id) {
    return ResponseEntity.ok(boardService.get(id));
  }

  @PostMapping
  public ResponseEntity<BoardResponseDTO> create(@RequestBody BoardRequestDTO dto) {
    return ResponseEntity.ok(boardService.create(dto));
  }

  @PutMapping("/{id}")
  public ResponseEntity<BoardResponseDTO> update(
          @PathVariable Long id,
          @RequestBody BoardRequestDTO dto
  ) {
    return ResponseEntity.ok(boardService.update(id, dto));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(@PathVariable Long id) {
    boardService.delete(id);
    return ResponseEntity.ok().build();
  }
}
