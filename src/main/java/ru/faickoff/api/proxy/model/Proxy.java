package ru.faickoff.api.proxy.model;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "proxies")
public class Proxy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "uid", nullable = false)
    private Long uid;

    @Column(name = "address", nullable = false, length = 31)
    private String address;

    @Column(name = "http_port", nullable = false)
    private Integer httpPort;

    @Column(name = "socks5_port", nullable = false)
    private Integer socks5Port;

    @Column(name = "username", nullable = false, length=255)
    private String username;

    @Column(name = "password", nullable = false, length=255)
    private String password;
    
    @CreationTimestamp
    @Column(name = "created_at", nullable = false)
    private Date createdAt;
}
