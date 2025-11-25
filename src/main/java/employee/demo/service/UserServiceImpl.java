package employee.demo.service;

import employee.demo.dto.UserRequestDTO;
import employee.demo.dto.UserResponseDTO;
import employee.demo.entity.User;
import employee.demo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
//@Log4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private  final UserRepository userRepository;

    @Override
    public UserResponseDTO create(UserRequestDTO dto) {
        User user = new User();

        user.setUserName(dto.getUserName());
        user.setEmail(dto.getEmail());
        user.setAge(dto.getAge());

        User savedUser = userRepository.save(user);
        return toResponseDTO(savedUser);
    }

    @Override
    public UserResponseDTO get(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("유저 정보 없음"));
        return toResponseDTO(user);
    }

    @Override
    public List<UserResponseDTO> getAll() {

        return userRepository.findAll()
                .stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public UserResponseDTO update(Long id, UserRequestDTO dto) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("회원 정보를 찾을 수 없습니다"));

        user.setUserName(dto.getUserName());
        user.setEmail(dto.getEmail());
        user.setAge(dto.getAge());

        User updateUser = userRepository.save(user);

        return toResponseDTO(updateUser);
    }

    @Override
    public void delete(Long id) {
        if (userRepository.existsById(id)) {
            throw new IllegalArgumentException("회원 정보 찾을 수 없습니다");
        }
        userRepository.deleteById(id);

    }

    private UserResponseDTO toResponseDTO(User user) {
        UserResponseDTO dto = new UserResponseDTO();

        dto.setId(user.getId());
        dto.setUserName(user.getUserName());
        dto.setEmail(user.getEmail());
        dto.setAge(user.getAge());

        return dto;
    }
}
