package pruebasjpa;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.arcones.Models.Noticia;
import com.arcones.Repository.NoticiasRepository;

public class AppDeleteAll {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");

		NoticiasRepository repo = context.getBean("noticiasRepository", NoticiasRepository.class);

		repo.deleteAll();
		
		context.close();

	}

}
