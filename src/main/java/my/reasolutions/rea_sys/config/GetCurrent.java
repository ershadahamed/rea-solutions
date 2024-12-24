package my.reasolutions.rea_sys.config;

import lombok.RequiredArgsConstructor;
import my.reasolutions.rea_sys.user.User;
import my.reasolutions.rea_sys.user.UserService;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetCurrent {
    private final UserService userService;

    public User user (){
        Authentication AUTH = SecurityContextHolder.getContext().getAuthentication();
        if (AUTH == null ||
                !AUTH.isAuthenticated() ||
                AUTH instanceof AnonymousAuthenticationToken) {
            return null;
        }
        return (User) AUTH.getPrincipal();
    }

    public User user(Long userId) {
        return userService.findById(userId);
    }
}
