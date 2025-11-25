package employee.demo.web;


import employee.demo.dto.UserRequestDTO;
import employee.demo.dto.UserResponseDTO;
import employee.demo.entity.User;
import employee.demo.service.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/users")
@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserServiceImpl userService;

    // 전체 조회
   @GetMapping
  public ResponseEntity< List<UserResponseDTO>> getAll() {
     return ResponseEntity.ok(userService.getAll());
   }

   @GetMapping("/{id}")
  public ResponseEntity< UserResponseDTO> getOne(@PathVariable Long id) {
     return ResponseEntity.ok(userService.get(id));
   }

   @PostMapping
  public ResponseEntity<UserResponseDTO> create(@RequestBody UserRequestDTO dto) {
     return ResponseEntity.ok(userService.create(dto));
   }

   @PutMapping("/{id}")
  public ResponseEntity<UserResponseDTO> update(@RequestBody UserRequestDTO dto, @PathVariable Long id) {
     return ResponseEntity.ok(userService.update(id, dto));
   }

   @DeleteMapping("/{id}")
  public ResponseEntity<UserResponseDTO> delete(@PathVariable Long id) {
     userService.delete(id);
     return ResponseEntity.ok().build();
   }

}
