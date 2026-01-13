package ru.faickoff.api.proxy.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ru.faickoff.api.proxy.model.Proxy;

@Repository
public interface ProxyRepository extends JpaRepository<Proxy, Long> {

    public List<Proxy> findAllByUid(Long uid);

    public Optional<Proxy> findByIdAndUid(Long id, Long uid);
}
