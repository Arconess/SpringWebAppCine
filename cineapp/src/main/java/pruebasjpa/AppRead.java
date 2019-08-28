package pruebasjpa;

import java.util.Optional;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.arcones.Models.Noticia;
import com.arcones.Repository.NoticiasRepository;

public class AppRead {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");

		NoticiasRepository repo = context.getBean("noticiasRepository", NoticiasRepository.class);

		Optional<Noticia> noticia = repo.findById(1);

		System.out.println(noticia.get());

		context.close();
	}

}
