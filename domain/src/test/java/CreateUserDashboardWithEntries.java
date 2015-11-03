import ch.bfh.bti7051.phototraveler.model.Dashboard;
import ch.bfh.bti7051.phototraveler.model.Item;
import ch.bfh.bti7051.phototraveler.model.ItemCollection;
import ch.bfh.bti7051.phototraveler.model.User;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by webel3 on 03.11.2015.
 */
public class CreateUserDashboardWithEntries {

    @Test
    public void test() {

        // create a new user
        User user = new User();
        user.setEmail("webel3@bfh.ch");
        user.setName("Lukas Weber");
        user.setPassword("1234");

        // create some items
        Item item1 = new Item("item-1");
        item1.setNotes("notiz-1");
        Item item2 = new Item("item-2");
        Item item3 = new Item("item-3");
        Item item4 = new Item("item-4");

        // create two lists with some items each
        List<Item> list1 = new LinkedList<Item>();
        list1.add(item1);
        list1.add(item2);

        List<Item> list2 = new LinkedList<Item>();
        list2.add(item3);
        list2.add(item4);

        // create an item-collection with a list of items
        ItemCollection coll1 = new ItemCollection();
        coll1.addItems(list2);

        // create a new dashboard
        Dashboard board = new Dashboard();

        // add standalone items to board
        board.addItems(list1);

        // add the collection of items to the board
        board.addCollection(coll1);

        // set board to the created user
        user.setDashboard(board);

        EntityManager em = Persistence.createEntityManagerFactory(
                AllTestsRunner.PERSISTENCE_NAME).createEntityManager();

        // it is enough to just persist the user because
        // all relationships have cascade type "ALL" => another test.
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
    }
}
