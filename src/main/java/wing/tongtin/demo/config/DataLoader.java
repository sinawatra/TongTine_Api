package wing.tongtin.demo.config;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataLoader {

    @Bean
    CommandLineRunner loadData() {
        return args -> {
            System.out.println("E-Tontine system started");
        };
    }

}
