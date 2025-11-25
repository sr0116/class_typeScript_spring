package employee.demo.service;


import employee.demo.dto.UserRequestDTO;
import employee.demo.dto.UserResponseDTO;

import java.util.List;

public interface UserService {
  // 유저 생성
  UserResponseDTO create(UserRequestDTO dto);

  // 단일 조회
  UserResponseDTO get(Long id);

  // 전체 회원
  List<UserResponseDTO> getAll();

  // 유저 수정
  UserResponseDTO update(Long id, UserRequestDTO dto);

  // 삭제
  void delete(Long id);


}