package org.springframework.samples.petclinic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RepoWithSingleVulnerabilityApplication {
  private static final String OPEN_AI_T = "sk-1234567890abcdef1234567890abcdef1234567890abcdef";

	public static void main(String[] args) {
    System.out.println(OPEN_AI_T);
		SpringApplication.run(RepoWithSingleVulnerabilityApplication.class, args);
	}
}