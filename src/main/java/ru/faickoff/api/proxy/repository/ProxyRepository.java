package ru.faickoff.api.proxy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ru.faickoff.api.proxy.model.Proxy;

@Repository
public interface ProxyRepository extends JpaRepository<Proxy, Long> {
}
