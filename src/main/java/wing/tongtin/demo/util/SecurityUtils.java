package wing.tongtin.demo.util;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class SpringSecurityBatch1Application implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityBatch1Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println(new BCryptPasswordEncoder().encode("123456"));
    }
}
