package com.github.lych.notification.service.domain.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

/**
 * The type Email session config.
 */
@Configuration
public class EmailSessionConfig {

    /**
     * Mail properties properties.
     *
     * @param authEnabled the auth enabled
     * @param tlsEnabled  the tls enabled
     * @param sslEnabled  the ssl enabled
     * @param host        the host
     * @param port        the port
     * @return the properties
     */
    @Bean
    public Properties mailProperties(@Value("${mail.smtp.auth-enabled}") final String authEnabled,
                                     @Value("${mail.smtp.tls-enabled}") final String tlsEnabled,
                                     @Value("${mail.smtp.ssl-enabled}") final String sslEnabled,
                                     @Value("${mail.smtp.host}") final String host,
                                     @Value("${mail.smtp.port}") final Integer port) {
        final Properties properties = new Properties();
        properties.put("mail.smtp.auth", authEnabled);
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", port);

        final boolean tls = Boolean.parseBoolean(tlsEnabled);
        final boolean ssl = Boolean.parseBoolean(sslEnabled);
        if (ssl) {
            properties.put("mail.smtp.socketFactory.port", port);
            properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        } else if (tls) {
            properties.put("mail.smtp.starttls.enable", tlsEnabled);
        }

        return properties;
    }
}
