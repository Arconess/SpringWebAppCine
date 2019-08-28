package pruebasjpa;

import java.util.Optional;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.arcones.Models.Noticia;
import com.arcones.Repository.NoticiasRepository;

public class AppUpdate {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");

		NoticiasRepository repo = context.getBean("noticiasRepository", NoticiasRepository.class);

		Optional<Noticia> optional = repo.findById(1);

		if (optional.isPresent()) {
			Noticia noticia = optional.get();
			noticia.setEstatus("Inactiva");

			repo.save(noticia);

		}

		context.close();

	}

}
