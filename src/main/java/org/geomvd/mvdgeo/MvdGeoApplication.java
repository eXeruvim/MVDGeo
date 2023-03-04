package org.geomvd.mvdgeo;

import org.geomvd.mvdgeo.config.WebSecurityConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class MvdGeoApplication {
    static final Logger log = LoggerFactory.getLogger(MvdGeoApplication.class);
    public static void main(String[] args) {
        log.info("Запуск приложения");
        SpringApplication.run(MvdGeoApplication.class, args);
    }

}
