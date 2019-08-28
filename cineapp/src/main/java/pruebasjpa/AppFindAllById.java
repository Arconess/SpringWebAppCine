package pruebasjpa;

import java.util.LinkedList;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.arcones.Models.Noticia;
import com.arcones.Repository.NoticiasRepository;

public class AppFindAllById {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");

		NoticiasRepository repo = context.getBean("noticiasRepository", NoticiasRepository.class);
		
		List<Integer> ids = new LinkedList<Integer>();
		ids.add(2);
		ids.add(6);
		ids.add(8);

		Iterable<Noticia> it = repo.findAllById(ids);
		
		for(Noticia n : it) {
			System.out.println(n);
		}

		context.close();

	}

}
