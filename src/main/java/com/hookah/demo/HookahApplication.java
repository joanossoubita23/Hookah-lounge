package com.hookah.demo;

import com.hookah.demo.entity.Hookah;
import com.hookah.demo.repository.DrinkRepository;
import com.hookah.demo.repository.HookahRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HookahApplication implements CommandLineRunner {
	@Autowired
	private HookahRepository hookahRepository;
	@Autowired
	private DrinkRepository drinkRepository;
	private  static final Logger logger= LoggerFactory.getLogger(HookahApplication.class);

	public static void main(String[] args) {


		SpringApplication.run(HookahApplication.class, args);
		logger.info("Application start");

	}

	@Override
	public void run(String... args) throws Exception {
		Hookah hookah=new Hookah("cierra","mango",34.89);
		Hookah hookah1=new Hookah("lache","mint",56.90);
		hookahRepository.save(hookah);
		hookahRepository.save(hookah1);

	}
}
