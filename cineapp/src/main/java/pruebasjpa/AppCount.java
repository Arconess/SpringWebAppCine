package pruebasjpa;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.arcones.Repository.NoticiasRepository;

public class AppCount {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");

		NoticiasRepository repo = context.getBean("noticiasRepository", NoticiasRepository.class);

		long num = repo.count();

		System.out.println("Se encontraron: " + num + " registros.");

		context.close();

	}

}
