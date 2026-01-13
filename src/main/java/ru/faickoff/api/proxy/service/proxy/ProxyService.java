package ru.faickoff.api.proxy.service.proxy;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import ru.faickoff.api.proxy.model.Proxy;
import ru.faickoff.api.proxy.repository.ProxyRepository;

@Service
@RequiredArgsConstructor
public class ProxyService {

    private final ProxyRepository proxyRepository;

    public List<Proxy> getAllByUid(Long uid) {
        return this.proxyRepository.findAllByUid(uid);
    }

    public Proxy getById(Long id) {
        return this.proxyRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Proxy by current id not found"));
    }

    public Optional<Proxy> findByIdAndUid(Long id, Long uid) {
        return this.proxyRepository.findByIdAndUid(id, uid);
    }

    public Proxy getByIdAndUid(Long id, Long uid) {
        return this.findByIdAndUid(id, uid)
                .orElseThrow(() -> new IllegalArgumentException("Proxy by current id and uid not found"));
    }

    public Proxy save(Proxy proxy) {
        return this.proxyRepository.save(proxy);
    }

    public Proxy create(Proxy proxy) {
        return this.save(proxy);
    }

    public void deleteByIdAndUid(Long id, Long uid) {
        this.proxyRepository.deleteByIdAndUid(id, uid);
    }

    public void delete(Proxy proxy) {
        this.proxyRepository.delete(proxy);
    }

    public Proxy put(Proxy updating) {
        Proxy proxy = this.getById(updating.getId());

        proxy.setUid(updating.getUid());
        proxy.setAddress(updating.getAddress());
        proxy.setHttpPort(updating.getHttpPort());
        proxy.setSocks5Port(updating.getSocks5Port());
        proxy.setUsername(updating.getUsername());
        proxy.setPassword(updating.getPassword());

        return this.save(proxy);
    }

    public Proxy patch(Proxy updating) {
        Proxy proxy = this.getById(updating.getId());

        Optional.ofNullable(updating.getUid())
                .ifPresent((uid) -> proxy.setUid(uid));
        Optional.ofNullable(updating.getAddress())
                .ifPresent((address) -> proxy.setAddress(address));
        Optional.ofNullable(updating.getHttpPort())
                .ifPresent((httpPort) -> proxy.setHttpPort(httpPort));
        Optional.ofNullable(updating.getSocks5Port())
                .ifPresent((socks5Port) -> proxy.setSocks5Port(socks5Port));
        Optional.ofNullable(updating.getUsername())
                .ifPresent((username) -> proxy.setUsername(username));
        Optional.ofNullable(updating.getPassword())
                .ifPresent((password) -> proxy.setPassword(password));

        return this.save(proxy);
    }
}
