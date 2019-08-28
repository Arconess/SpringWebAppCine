package pruebasjpa;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.arcones.Models.Noticia;
import com.arcones.Repository.NoticiasRepository;

public class AppFindAll {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");

		NoticiasRepository repo = context.getBean("noticiasRepository", NoticiasRepository.class);

		Iterable<Noticia> it = repo.findAll();
		
		for(Noticia n : it) {
			System.out.println(n);
		}

		context.close();

	}

}
