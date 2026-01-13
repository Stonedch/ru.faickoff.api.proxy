package ru.faickoff.api.proxy.controller.api.v1.proxy;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import ru.faickoff.api.proxy.dto.request.proxy.ProxyCreateRequest;
import ru.faickoff.api.proxy.dto.response.proxy.ProxyListResponse;
import ru.faickoff.api.proxy.dto.response.proxy.ProxyResponse;
import ru.faickoff.api.proxy.mapper.proxy.ProxyMapper;
import ru.faickoff.api.proxy.model.Proxy;
import ru.faickoff.api.proxy.service.logger.LoggerHttpServletRequestService;
import ru.faickoff.api.proxy.service.proxy.CurrentUserProxyService;

@RestController
@RequestMapping("/api/v1/proxy")
@RequiredArgsConstructor
public class ProxyController {

    private final LoggerHttpServletRequestService logger;
    private final CurrentUserProxyService currentUserProxyService;
    private final ProxyMapper proxyMapper;

    @GetMapping
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public ResponseEntity<ProxyListResponse> getAll(HttpServletRequest servletRequest) {
        this.logger.info(servletRequest);
        List<Proxy> proxies = this.currentUserProxyService.getAll();
        ProxyListResponse responseBody = this.proxyMapper.toProxyListResponse(proxies);
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public ResponseEntity<ProxyResponse> getById(
            HttpServletRequest servletRequest,
            @PathVariable Long id) {
        this.logger.info(servletRequest);
        Proxy proxy = this.currentUserProxyService.getById(id);
        ProxyResponse responseBody = this.proxyMapper.toProxyResponse(proxy);
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }

    @PostMapping
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public ResponseEntity<ProxyResponse> create(
            HttpServletRequest servletRequest,
            @Valid @RequestBody ProxyCreateRequest proxyCreateRequest) {
        Proxy creating = this.proxyMapper.toProxy(proxyCreateRequest);
        Proxy created = this.currentUserProxyService.create(creating);
        ProxyResponse responseBody = this.proxyMapper.toProxyResponse(created);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseBody);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public ResponseEntity<Void> deleteById(
            HttpServletRequest servletRequest,
            @PathVariable Long id) {
        this.currentUserProxyService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
