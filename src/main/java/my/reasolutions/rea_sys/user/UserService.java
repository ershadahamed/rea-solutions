package my.reasolutions.rea_sys.user;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User findById(Long userId) {
        return userRepository
                .findById(userId)
                .orElseThrow(
                        () -> new UsernameNotFoundException("User not found with id: " + userId)
                );
    }
}
