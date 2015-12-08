package ch.bfh.bti7051.phototraveler.service;

import ch.bfh.bti7051.phototraveler.service.dto.ItemDTO;
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
        ItemDTO newItem = new ItemDTO();
        newItem.setVisited(true);
        newItem = service.create(newItem);

        // Read
        ItemDTO readItem = service.read(newItem.getId());
        Assert.assertTrue(newItem.getVisited().equals(readItem.getVisited()));

        // Update
        readItem.setVisited(false);
        readItem = service.update(readItem);
        ItemDTO updatedAttachment = service.read(readItem.getId());
        Assert.assertTrue(readItem.getVisited().equals(updatedAttachment.getVisited()));

        // Delete
        service.delete(updatedAttachment);
        ItemDTO deletedAttachment = service.read(readItem.getId());
        Assert.assertNull(deletedAttachment);
    }

}