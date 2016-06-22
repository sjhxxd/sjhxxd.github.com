package bishe;

import com.mangofactory.swagger.plugin.EnableSwagger;
import org.jsondoc.spring.boot.starter.EnableJSONDoc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
// Sprint Boot Auto Configuration
@EnableJSONDoc
@EnableSwagger
// auto generation of API docs
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}


