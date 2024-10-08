package Simple.API.config;

import Simple.API.entity.SiswaEntity;
import Simple.API.repo.SiswaRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SiswaConfig {

    @Bean
    CommandLineRunner commandLineRunner(
            SiswaRepository repository){
        return args -> {

            //input data siswa
            SiswaEntity eza = new SiswaEntity(
                    31234567,
                    "Eza",
                    "Blok D4, No.36",
                    "XII RPL 2"
            );
            SiswaEntity ibnu = new SiswaEntity(
                    31234567,
                    "Ibnu",
                    "Ciharashas",
                    "XII RPL 3"
            );
            SiswaEntity rehan = new SiswaEntity(
                    31234567,
                    "Rehan",
                    "Padasuka",
                    "XII RPL 4"
            );
            SiswaEntity ahza = new SiswaEntity(
                    31234567,
                    "Ahza",
                    "Padalarang",
                    "XII RPL 1"
            );

            repository.saveAll(
                    List.of(eza,ibnu, rehan, ahza)
            );
        };
    }
}
