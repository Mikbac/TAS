package ApiOne;

import ApiOne.Controllers.FacultyController;
import ApiOne.Controllers.TeacherController;
import ApiOne.Controllers.UniversityController;
import ApiOne.Controllers.VoteController;
import ApiOne.Entities.Faculty;
import ApiOne.Entities.Teacher;
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
    public CommandLineRunner demoData(UniversityController universityController, FacultyController facultyController, TeacherController teacherController, VoteController voteController) {
        return args -> {

            universityController.addUniversity(new University("Uniwersytet im. Adama Mickiewicza w Poznaniu", "Poznan"));
            universityController.addUniversity(new University("Akademia Wychowania Fizycznego", "Poznan"));
            universityController.addUniversity(new University("Uniwersytet Ekonomiczny w Poznaniu", "Poznan"));
            universityController.addUniversity(new University("Politechnika Poznańska", "Poznan"));
            universityController.addUniversity(new University("Akademia Sztuk Pięknych", "Poznan"));
            universityController.addUniversity(new University("Akademia Sztuk Pięknych", "Warszawa"));
            universityController.addUniversity(new University("Uniwersytet Warszawski", "Warszawa"));
            universityController.addUniversity(new University("Akademia Górniczo-Hutnicza im. Stanisława Staszica w Krakowie", "Kraków"));
            universityController.addUniversity(new University("Politechnika Wrocławska", "Wrocław"));
            universityController.addUniversity(new University("Uniwersytet Wrocławski", "Wrocław"));


            facultyController.addFaculty(new Faculty("Wydział Anglistyki", universityController.oneUniversity(1)));
            facultyController.addFaculty(new Faculty("Wydział Biologii", universityController.oneUniversity(1)));
            facultyController.addFaculty(new Faculty("Wydział Chemii", universityController.oneUniversity(1)));
            facultyController.addFaculty(new Faculty("Wydział Filologii Polskiej i Klasycznej", universityController.oneUniversity(1)));
            facultyController.addFaculty(new Faculty("Wydział Fizyki", universityController.oneUniversity(1)));
            facultyController.addFaculty(new Faculty("Wydział Historyczny", universityController.oneUniversity(1)));
            facultyController.addFaculty(new Faculty("Wydział Matematyki i Informatyki", universityController.oneUniversity(1)));
            facultyController.addFaculty(new Faculty("Wydział Nauk Geograficznych i Geologicznych", universityController.oneUniversity(1)));
            facultyController.addFaculty(new Faculty("Wydział Nauk Politycznych i Dziennikarstwa", universityController.oneUniversity(1)));
            facultyController.addFaculty(new Faculty("Wydział Nauk Społecznych", universityController.oneUniversity(1)));
            facultyController.addFaculty(new Faculty("Wydział Neofilologii", universityController.oneUniversity(1)));
            facultyController.addFaculty(new Faculty("Wydział Prawa i Administracji", universityController.oneUniversity(1)));
            facultyController.addFaculty(new Faculty("Wydział Studiów Edukacyjnych", universityController.oneUniversity(1)));
            facultyController.addFaculty(new Faculty("Wydział Teologiczny", universityController.oneUniversity(1)));
            facultyController.addFaculty(new Faculty("Wydział Pedagogiczno-Artystyczny w Kaliszu (podlega mu Stacja Naukowo-Dydaktyczna w Jarocinie)", universityController.oneUniversity(1)));

            facultyController.addFaculty(new Faculty("Wydział Wychowania Fizycznego", universityController.oneUniversity(2)));
            facultyController.addFaculty(new Faculty("Wydział Turystyki i Rekreacji", universityController.oneUniversity(2)));
            facultyController.addFaculty(new Faculty("Zamiejscowy Wydział Kultury Fizycznej w Gorzowie Wielkopolskim", universityController.oneUniversity(2)));

            facultyController.addFaculty(new Faculty("Wydział Ekonomii", universityController.oneUniversity(3)));
            facultyController.addFaculty(new Faculty("Wydział Gospodarki Międzynarodowej", universityController.oneUniversity(3)));
            facultyController.addFaculty(new Faculty("Wydział Informatyki i Gospodarki Elektronicznej", universityController.oneUniversity(3)));
            facultyController.addFaculty(new Faculty("Wydział Towaroznawstwa", universityController.oneUniversity(3)));
            facultyController.addFaculty(new Faculty("Wydział Zarządzania", universityController.oneUniversity(3)));


            teacherController.addTeacher(new Teacher("Jan", "Pug", facultyController.oneFaculty(1)));
            teacherController.addTeacher(new Teacher("Dominik", "Nowak", facultyController.oneFaculty(1)));
            teacherController.addTeacher(new Teacher("Alicja", "Kowalski", facultyController.oneFaculty(1)));
            teacherController.addTeacher(new Teacher("Judyta", "Owca", facultyController.oneFaculty(2)));
            teacherController.addTeacher(new Teacher("Andrzej", "Baran", facultyController.oneFaculty(2)));
            teacherController.addTeacher(new Teacher("Weronika", "Celka", facultyController.oneFaculty(3)));
            teacherController.addTeacher(new Teacher("Joanna", "Gawiej", facultyController.oneFaculty(3)));
            teacherController.addTeacher(new Teacher("Kazimierz", "Kowalski", facultyController.oneFaculty(3)));
            teacherController.addTeacher(new Teacher("Stanisław", "Owcarzak", facultyController.oneFaculty(4)));
            teacherController.addTeacher(new Teacher("Aneta", "Zientkiewicz", facultyController.oneFaculty(4)));
            teacherController.addTeacher(new Teacher("Dominika", "Ziętkowska", facultyController.oneFaculty(4)));
            teacherController.addTeacher(new Teacher("Klaudia", "Celka", facultyController.oneFaculty(4)));
            teacherController.addTeacher(new Teacher("Ewa", "Kowalska", facultyController.oneFaculty(5)));
            teacherController.addTeacher(new Teacher("Mikołaj", "Nowak", facultyController.oneFaculty(5)));
            teacherController.addTeacher(new Teacher("Damian", "Rumiński", facultyController.oneFaculty(5)));
            teacherController.addTeacher(new Teacher("Wiktor", "Kazmierczak", facultyController.oneFaculty(6)));
            teacherController.addTeacher(new Teacher("Barbara", "Banasiak", facultyController.oneFaculty(6)));
            teacherController.addTeacher(new Teacher("Natalia", "Kowalczyk", facultyController.oneFaculty(7)));
            teacherController.addTeacher(new Teacher("Hanna", "Marianska", facultyController.oneFaculty(7)));
            teacherController.addTeacher(new Teacher("Rita", "Polomska", facultyController.oneFaculty(7)));


            voteController.addVote(new Vote(10,10,10,10,10,10,"Wspanialy czlowiek.",teacherController.oneTeacher(1)));
            voteController.addVote(new Vote(9,4,3,3,2,3,"Ciekawe zajęcia.",teacherController.oneTeacher(1)));
            voteController.addVote(new Vote(8,5,4,4,3,4,"Świetna atmosfera.",teacherController.oneTeacher(1)));
            voteController.addVote(new Vote(7,6,5,5,4,5,"Świetna atmosfera.",teacherController.oneTeacher(4)));
            voteController.addVote(new Vote(6,7,6,6,5,6,"",teacherController.oneTeacher(5)));
            voteController.addVote(new Vote(5,8,3,4,6,4,"Ciekawe zajęcia.",teacherController.oneTeacher(6)));
            voteController.addVote(new Vote(4,9,4,5,3,5,"Wspanialy czlowiek.",teacherController.oneTeacher(7)));
            voteController.addVote(new Vote(3,3,5,6,4,4,"Ciekawe zajęcia.",teacherController.oneTeacher(8)));
            voteController.addVote(new Vote(2,4,6,7,5,5,"",teacherController.oneTeacher(9)));
            voteController.addVote(new Vote(1,5,3,4,6,6,"Wspanialy czlowiek.",teacherController.oneTeacher(3)));
            voteController.addVote(new Vote(6,6,5,5,3,7,"Ciekawe zajęcia.",teacherController.oneTeacher(4)));
            voteController.addVote(new Vote(4,7,7,6,4,3,"WŚwietna atmosfera.",teacherController.oneTeacher(5)));
            voteController.addVote(new Vote(3,8,5,7,5,4,"",teacherController.oneTeacher(6)));
            voteController.addVote(new Vote(6,2,6,5,6,5,"Wspanialy czlowiek.",teacherController.oneTeacher(7)));
            voteController.addVote(new Vote(7,3,3,4,7,6,"Świetna atmosfera.",teacherController.oneTeacher(4)));
            voteController.addVote(new Vote(3,4,5,6,4,7,"Ciekawe zajęcia.",teacherController.oneTeacher(3)));
            voteController.addVote(new Vote(4,5,7,7,5,4,"Wspanialy czlowiek.",teacherController.oneTeacher(5)));
            voteController.addVote(new Vote(8,6,5,3,6,5,"",teacherController.oneTeacher(7)));
            voteController.addVote(new Vote(2,3,4,4,7,6,"Świetna atmosfera.",teacherController.oneTeacher(8)));
            voteController.addVote(new Vote(4,4,5,5,4,4,"Ciekawe zajęcia.",teacherController.oneTeacher(9)));
            voteController.addVote(new Vote(8,5,3,6,5,5,"",teacherController.oneTeacher(4)));
        };
    }


    public static void main(String[] args) {
        SpringApplication.run(SpringBootWebApplication.class, args);
    }

}