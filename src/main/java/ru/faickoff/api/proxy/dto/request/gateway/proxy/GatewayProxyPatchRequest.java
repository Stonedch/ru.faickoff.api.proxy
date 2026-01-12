package ru.faickoff.api.proxy.dto.request.gateway.proxy;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GatewayProxyPatchRequest {

    private Long uid;

    @Size(max = 31, message = "The \"address\" field must be no more than 31")
    private String address;

    private Integer httpPort;

    private Integer socks5Port;

    private String username;

    private String password;
}
