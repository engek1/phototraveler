/**
 * 
 */

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import ch.bfh.bti7051.phototraveler.model.Author;
import org.junit.Test;

/**
 * @author rovi
 * 
 */
public class DeleteIT {


	@Test
	public void test() {

		EntityManager em = Persistence.createEntityManagerFactory(
				"ch.bfh.bti7515.phototraveler.domain").createEntityManager();

		Query q = em.createQuery("select a from Author a");
		@SuppressWarnings("unchecked")
		List<Author> foundAuthors = q.getResultList();
		Author firstAuthor = foundAuthors.get(0);
		// Assert.assertTrue(firstAuthor.getLastname().equals("Tolkien"));

		// Write access needs a transaction
		em.getTransaction().begin();
		em.remove(firstAuthor);
		em.getTransaction().commit();
	}

}