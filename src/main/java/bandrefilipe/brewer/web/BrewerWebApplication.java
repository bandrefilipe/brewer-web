package bandrefilipe.brewer.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Locale;

import static bandrefilipe.brewer.web.GlobalConstants.LOCALE_EN_US;

@SpringBootApplication
public class BrewerWebApplication {

    public static void main(final String[] args) {
        Locale.setDefault(LOCALE_EN_US);
        SpringApplication.run(BrewerWebApplication.class, args);
    }
}
