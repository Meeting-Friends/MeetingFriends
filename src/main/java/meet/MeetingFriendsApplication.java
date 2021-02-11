package meet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan("meet")
@EnableJpaRepositories("meet.dao")
@EntityScan("meet.model.domain")
public class MeetingFriendsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MeetingFriendsApplication.class, args);
	}

}
