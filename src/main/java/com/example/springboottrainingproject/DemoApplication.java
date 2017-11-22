package com.example.springboottrainingproject;

import com.example.springboottrainingproject.domain.Category;
import com.example.springboottrainingproject.domain.Journal;
import com.example.springboottrainingproject.repository.CategoryRepository;
import com.example.springboottrainingproject.repository.JournalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.*;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner{

	@Autowired
	CategoryRepository categoryRepository;

	@Autowired
	JournalRepository journalRepository;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Category category = new Category();

		Journal journal = new Journal();
		journal.setCreated(Calendar.getInstance().getTime());
		journal.setTitle("title 1");
		journal.setSummary("summary 1");

		Journal journal2 = new Journal();
		journal2.setTitle("title 2");
		journal2.setSummary("sdasdad");
		journal2.setCreated(Calendar.getInstance().getTime());

		category.setEntries(new HashSet<Journal>(){{
			add(journal);
			add(journal2);
		}});
		journal.setCategory(category);
		journal2.setCategory(category);

		categoryRepository.save(category);
	}
}
