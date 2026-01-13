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
}
