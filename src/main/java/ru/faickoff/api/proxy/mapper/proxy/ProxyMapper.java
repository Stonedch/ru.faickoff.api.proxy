package ru.faickoff.api.proxy.mapper.proxy;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import ru.faickoff.api.proxy.dto.response.proxy.ProxyListResponse;
import ru.faickoff.api.proxy.dto.response.proxy.ProxyResponse;
import ru.faickoff.api.proxy.model.Proxy;

@Component
@RequiredArgsConstructor
public class ProxyMapper {

    public ProxyResponse toProxyResponse(Proxy proxy) {
        return ProxyResponse.builder()
                .address(proxy.getAddress())
                .httpPort(proxy.getHttpPort())
                .socks5Port(proxy.getSocks5Port())
                .username(proxy.getUsername())
                .password(proxy.getPassword())
                .createdAt(proxy.getCreatedAt())
                .build();
    }

    public List<ProxyResponse> toProxyResponses(List<Proxy> proxies) {
        return proxies.stream().map(this::toProxyResponse).collect(Collectors.toList());
    }

    public ProxyListResponse toProxyListResponse(List<Proxy> proxies) {
        return ProxyListResponse.builder().proxies(this.toProxyResponses(proxies)).build();
    }
}
