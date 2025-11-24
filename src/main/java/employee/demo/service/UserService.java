package employee.demo.service;

import employee.demo.entity.User;
import employee.demo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
//@Log4j
@RequiredArgsConstructor
public class UserService {

    private  final UserRepository userRepository;



    // 조회
    public List<User> findAll() {
        return userRepository.findAll();
    }
    // 등록
    public User createUser(User user) {
        return userRepository.save(user);
    }
    // 삭제
    @Transactional
    public void deleteUser(Long userId) {
        if (!userRepository.existsById(userId)) {
            throw new IllegalArgumentException("이미 삭제되었거나 존재하지 않는 유저입니다.");
        }

        userRepository.deleteById(userId);
    }

    public User getUserName(String userName) {
        return userRepository.findByUserName(userName);
    }



}
