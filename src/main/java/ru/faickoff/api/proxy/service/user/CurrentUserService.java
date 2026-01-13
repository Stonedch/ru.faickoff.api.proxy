package ru.faickoff.api.proxy.service.user;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import ru.faickoff.api.proxy.model.User;

@Service
public class CurrentUserService {

    public User get() {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        Authentication authentication = securityContext.getAuthentication();
        User currentUser = (User) authentication.getPrincipal();
        return currentUser;
    }
}
