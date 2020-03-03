package co.closeit.assignment.examplebackend;

import co.closeit.assignment.examplebackend.persistence.ToDoEntry;
import co.closeit.assignment.examplebackend.persistence.ToDoEntryRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class ExampleBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExampleBackendApplication.class, args);
	}

	@EventListener()
	// initial Data
	public void contextRefreshedEvent(ContextRefreshedEvent event) {
		ApplicationContext applicationContext = ((ContextRefreshedEvent) event).getApplicationContext();
		ToDoEntryRepository toDoEntryRepository = applicationContext.getBean(ToDoEntryRepository.class);

		toDoEntryRepository.save(ToDoEntry.builder().description("study computer science").done(true).build());
		toDoEntryRepository.save(ToDoEntry.builder().description("buy a car").done(false).build());
		toDoEntryRepository.save(ToDoEntry.builder().description("call mum").done(false).build());
	}

}
