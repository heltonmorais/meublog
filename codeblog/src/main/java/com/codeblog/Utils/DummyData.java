package com.codeblog.Utils;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.codeblog.model.BlogModel;
import com.codeblog.repository.BlogRepository;

@Component
public class DummyData {

	@Autowired
	BlogRepository blogRepository;
	
	//@PostConstruct
	public void saveBlogModels() {
		
		List<BlogModel> blogModelList = new ArrayList<>();
		BlogModel blogModel1 = new BlogModel();
		blogModel1.setAutor("Helton Morais");
		blogModel1.setData(LocalDate.now());
		blogModel1.setTitulo("Aprendendo Java Spring Boot");
		blogModel1.setTexto("Aprendizado Iniciado em 05/02/22, através do canal Michelli Brito");
		
		BlogModel blogModel2 = new BlogModel();
		blogModel2.setAutor("Helton Morais");
		blogModel2.setData(LocalDate.now());
		blogModel2.setTitulo("Trilha Spring Boot");
		blogModel2.setTexto("Aprendizado: JPA, Validation, Mysql, Postgres, Thymeleaf, Security, API REST e Restful, HATEOS(Hipermidias) e a IDE STS");
		
		blogModelList.add(blogModel1);
		blogModelList.add(blogModel2);

        for(BlogModel blogModel: blogModelList){
        	BlogModel blogModelSaved = blogRepository.save(blogModel);
            System.out.println(blogModelSaved.getId());
        }
				
	}
}
