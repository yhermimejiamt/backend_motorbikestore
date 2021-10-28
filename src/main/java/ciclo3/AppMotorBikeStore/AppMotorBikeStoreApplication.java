package ciclo3.AppMotorBikeStore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
@EntityScan(basePackages = {"ciclo3.AppMotorBikeStore.Model"})
public class AppMotorBikeStoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(AppMotorBikeStoreApplication.class, args);
    }

}
