package ru.faickoff.api.proxy.dto.response.gateway.proxy;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GatewayProxyResponse {

    private Long id;

    private Long uid;

    private String address;

    private Integer httpPort;

    private Integer socks5Port;

    private String username;

    private String password;

    private Date createdAt;
}
