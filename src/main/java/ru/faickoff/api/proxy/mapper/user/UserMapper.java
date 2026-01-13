package ru.faickoff.api.proxy.mapper.user;

import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ru.faickoff.api.proxy.model.Role;
import ru.faickoff.api.proxy.model.User;

import java.util.*;
import java.util.stream.Collectors;

@Slf4j
@Component
public class UserMapper {

    public User toUser(Claims claims) {
        return User.builder()
                .id(claims.get("id", Long.class))
                .username(claims.get("username", String.class))
                .roles(parseRoles(claims.get("roles")))
                .build();
    }

    private Set<Role> parseRoles(Object rolesClaim) {
        if (rolesClaim instanceof List) {
            return ((List<?>) rolesClaim).stream()
                    .map(this::parseRoleItem)
                    .filter(Optional::isPresent)
                    .map(Optional::get)
                    .collect(Collectors.toSet());
        }

        return Collections.emptySet();
    }

    private Optional<Role> parseRoleItem(Object roleItem) {
        if (roleItem instanceof Map) {
            @SuppressWarnings("unchecked")
            Map<String, Object> map = (Map<String, Object>) roleItem;
            Object authority = map.get("authority");

            if (authority instanceof String) {
                return Optional.of(Role.builder()
                        .authority((String) authority)
                        .build());
            }
        }

        return Optional.empty();
    }
}