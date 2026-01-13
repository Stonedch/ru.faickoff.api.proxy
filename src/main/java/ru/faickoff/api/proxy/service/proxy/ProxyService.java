package ru.faickoff.api.proxy.service.proxy;

import java.util.List;

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

    public Proxy getByIdAndUid(Long id, Long uid) {
        return this.proxyRepository.findByIdAndUid(id, uid)
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
}
