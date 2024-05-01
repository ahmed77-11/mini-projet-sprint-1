package com.ahmed.motos;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.spring6.view.ThymeleafViewResolver;
import org.thymeleaf.spring6.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.templateresolver.ITemplateResolver;

import com.ahmed.motos.entities.Moto;
import com.ahmed.motos.service.MotoService;

import org.thymeleaf.templatemode.TemplateMode;

@SpringBootApplication
public class MotosApplication implements CommandLineRunner{
	
	@Autowired
	private RepositoryRestConfiguration repositoryRestConfiguration;

	public static void main(String[] args) {
		SpringApplication.run(MotosApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		repositoryRestConfiguration.exposeIdsFor(Moto.class);
		
	}
	/*
	 * @Bean public ViewResolver viewResolver(SpringTemplateEngine templateEngine) {
	 * ThymeleafViewResolver resolver = new ThymeleafViewResolver();
	 * resolver.setTemplateEngine(templateEngine); return resolver; }
	 * 
	 * @Bean public SpringTemplateEngine templateEngine(ITemplateResolver
	 * templateResolver) { SpringTemplateEngine engine = new SpringTemplateEngine();
	 * engine.setTemplateResolver(templateResolver); return engine; }
	 * 
	 * @Bean public ITemplateResolver templateResolver() {
	 * SpringResourceTemplateResolver resolver = new
	 * SpringResourceTemplateResolver();
	 * resolver.setPrefix("classpath:/templates/"); resolver.setSuffix(".html");
	 * resolver.setTemplateMode(TemplateMode.HTML); return resolver; }
	 */
}
