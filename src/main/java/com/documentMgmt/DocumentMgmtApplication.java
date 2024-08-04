package com.documentMgmt;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableAsync;

import com.documentMgmt.domain.RequestContext;
import com.documentMgmt.entity.RolesEntity;
import com.documentMgmt.enumeration.Authority;
import com.documentMgmt.repository.RoleRepository;

@SpringBootApplication
@EnableJpaAuditing
@EnableAsync
public class DocumentMgmtApplication {

	public static void main(String[] args) {
		SpringApplication.run(DocumentMgmtApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(RoleRepository reolRepository){
		return args ->{
			// RequestContext.setUserId(0L);
			// var userRole = new RolesEntity();
			// userRole.setName(Authority.USER.name());
			// userRole.setAuthorities(Authority.USER);
			// reolRepository.save(userRole);

			// var adminRole = new RolesEntity();
			// adminRole.setName(Authority.ADMIN.name());
			// adminRole.setAuthorities(Authority.ADMIN);
			// reolRepository.save(adminRole);
			// RequestContext.start();
		};
	}



}
