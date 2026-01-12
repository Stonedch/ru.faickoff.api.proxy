package ru.faickoff.api.proxy.dto.request.proxy;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProxyPutRequest {

    @NotNull(message = "The \"address\" field cannot be null")
    @Size(max = 31, message = "The \"address\" field must be no more than 31")
    private String address;

    @NotNull(message = "The \"httpPort\" field cannot be null")
    private Integer httpPort;

    @NotNull(message = "The \"socks5Port\" field cannot be null")
    private Integer socks5Port;

    @NotNull(message = "The \"username\" field cannot be null")
    private String username;

    @NotNull(message = "The \"password\" field cannot be null")
    private String password;
}
