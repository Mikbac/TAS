package ApiOne;

import ApiOne.Entities.Faculty;
import ApiOne.Entities.University;
import ApiOne.Entities.Vote;
import ApiOne.Repositories.FacultyRepository;
import ApiOne.Repositories.UniversityRepository;
import ApiOne.Repositories.VoteRepository;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableJpaRepositories("ApiOne.Repositories")
@EnableSwagger2
public class SpringBootWebApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(SpringBootWebApplication.class);
    }

    @Bean
    public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter() {
        MappingJackson2HttpMessageConverter jsonConverter = new MappingJackson2HttpMessageConverter();
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        jsonConverter.setObjectMapper(objectMapper);
        return jsonConverter;
    }

    @Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select().apis(RequestHandlerSelectors.basePackage("ApiOne.Controllers"))
                .build();
    }

    @Bean
    public CommandLineRunner demoData1(UniversityRepository universityRepository, FacultyRepository facultyRepository) {
        return args -> {

            universityRepository.save(new University("UAM","Poznan"));
            universityRepository.save(new University("UAM","Poznan"));
            universityRepository.save(new University("UAM","Poznan"));
            universityRepository.save(new University("UAM","Poznan"));
            universityRepository.save(new University("UAM","Poznan"));
            universityRepository.save(new University("UAM","Poznan"));

            facultyRepository.save(new Faculty("WMI", universityRepository.findByUniversityId(1)));
            facultyRepository.save(new Faculty("WMI", universityRepository.findByUniversityId(2)));

        };
    }




    public static void main(String[] args) {
        SpringApplication.run(SpringBootWebApplication.class, args);
    }

}