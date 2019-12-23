package com.yvaganet.soberano;

import com.yvaganet.soberano.domains.Note;
import com.yvaganet.soberano.repositories.NoteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class SoberanosApplication {
	public static void main(String[] args) {
		SpringApplication.run(SoberanosApplication.class, args);
	}


	@Bean
	public CommandLineRunner noteDemo(NoteRepository noteRepository) {
		return (args) -> {

			// create notes
			noteRepository.save(new Note("Welcome to Spring Boot", "Basic Introduction", new Date()));
			noteRepository.save(new Note("Learn Spring Data JPA", "Java Persistence Layer", new Date()));
			noteRepository.save(new Note("Learn Spring Security", "Build Secure Web Apps", new Date()));

			// fetch all notes
			System.out.println("Notes found with findAll():");
			System.out.println("---------------------------");
			for (Note note : noteRepository.findAll()) {
				System.out.println(note.toString());
			}
			System.out.println();



			// total notes in DB
			System.out.println("Total notes in DB:");
			System.out.println("------------------");
			System.out.println(noteRepository.count());
			System.out.println();

			// delete all notes
			noteRepository.deleteAll();
		};
	}
}