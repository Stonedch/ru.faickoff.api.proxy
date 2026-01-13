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

    public Proxy getById(Long id) {
        User currentUser = this.currentUserService.get();
        return this.proxyService.getByIdAndUid(id, currentUser.getId());
    }

    public Proxy create(Proxy creating) {
        User currentUser = this.currentUserService.get();
        creating.setUid(currentUser.getId());
        Proxy created = this.proxyService.create(creating);
        return created;
    }

    public void deleteById(Long id) {
        User currentUser = this.currentUserService.get();
        Proxy deleting = this.proxyService.getByIdAndUid(id, currentUser.getId());
        this.proxyService.delete(deleting);
    }

    public Proxy put(Proxy updating) {
        User currentUser = this.currentUserService.get();

        if (this.proxyService.findByIdAndUid(updating.getId(), currentUser.getId()).isEmpty()) {
            throw new IllegalArgumentException("Proxy by current id and uid not found");
        }

        updating.setUid(currentUser.getId());

        return this.proxyService.put(updating);
    }

    public Proxy patch(Proxy updating) {
        User currentUser = this.currentUserService.get();

        if (this.proxyService.findByIdAndUid(updating.getId(), currentUser.getId()).isEmpty()) {
            throw new IllegalArgumentException("Proxy by current id and uid not found");
        }

        updating.setUid(currentUser.getId());

        return this.proxyService.patch(updating);
    }
}
