package ru.faickoff.api.proxy.service.proxy;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import ru.faickoff.api.proxy.model.Proxy;
import ru.faickoff.api.proxy.model.User;
import ru.faickoff.api.proxy.service.user.CurrentUserService;

@Service
@RequiredArgsConstructor
public class CurrentUserProxyService {

    private final ProxyService proxyService;
    private final CurrentUserService currentUserService;

    public List<Proxy> getAll() {
        User currentUser = this.currentUserService.get();
        return this.proxyService.getAllByUid(currentUser.getId());
    }
}
