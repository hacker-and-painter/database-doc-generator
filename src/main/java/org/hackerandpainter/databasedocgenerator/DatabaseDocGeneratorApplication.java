package org.hackerandpainter.databasedocgenerator;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableSwagger2Doc
public class DatabaseDocGeneratorApplication {

    public static void main(String[] args) {
        SpringApplication.run(DatabaseDocGeneratorApplication.class, args);
    }

}
