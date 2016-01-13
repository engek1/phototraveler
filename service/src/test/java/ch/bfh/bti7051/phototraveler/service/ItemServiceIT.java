package ch.bfh.bti7051.phototraveler.service;

import ch.bfh.bti7051.phototraveler.model.Item;
import ch.bfh.bti7051.phototraveler.service.services.ItemService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/serviceContext.xml")
public class ItemServiceIT {

    @Inject
    private ItemService service;

    @Test
    public void test() {

        // Create
        Item newItem = new Item();
        newItem.setVisited(true);
        newItem = service.create(newItem);

        // Read
        Item readItem = service.read(newItem.getId());
        Assert.assertTrue(newItem.getVisited().equals(readItem.getVisited()));

        // Update
        readItem.setVisited(false);
        readItem = service.update(readItem);
        Item updatedAttachment = service.read(readItem.getId());
        Assert.assertTrue(readItem.getVisited().equals(updatedAttachment.getVisited()));

        // Delete
        service.delete(updatedAttachment.getId());
        Item deletedAttachment = service.read(readItem.getId());
        Assert.assertNull(deletedAttachment);
    }

}