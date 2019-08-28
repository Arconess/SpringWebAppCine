package pruebasjpa;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.arcones.Repository.NoticiasRepository;

public class AppDelete {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");

		NoticiasRepository repo = context.getBean("noticiasRepository", NoticiasRepository.class);

		int idNoticia = 1;

		if (repo.existsById(idNoticia)) {
			repo.deleteById(idNoticia);
		}

		context.close();

	}

}
