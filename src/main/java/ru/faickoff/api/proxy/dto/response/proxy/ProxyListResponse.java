package ru.faickoff.api.proxy.dto.response.proxy;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProxyListResponse {

    private List<ProxyResponse> proxies;
}
