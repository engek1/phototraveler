package ch.bfh.bti7051.phototraveler.service;

import ch.bfh.bti7051.phototraveler.model.Attachment;
import ch.bfh.bti7051.phototraveler.service.services.AttachmentService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/serviceContext.xml")
public class AttachmentServiceIT {

    @Inject
    private AttachmentService service;

    @Test
    public void test() {

        // Create
        Attachment newAttachment = new Attachment();
        newAttachment.setName("testfile");
        newAttachment = service.create(newAttachment);

        // Read
        Attachment readAttachment = service.read(newAttachment.getId());
        Assert.assertTrue(newAttachment.getName().equals(readAttachment.getName()));

        // Update
        readAttachment.setName("fineName2");
        readAttachment = service.update(readAttachment);
        Attachment updatedAttachment = service.read(readAttachment.getId());
        Assert.assertTrue(readAttachment.getName().equals(updatedAttachment.getName()));

        // Delete
        service.delete(updatedAttachment.getId());
        Attachment deletedAttachment = service.read(readAttachment.getId());
        Assert.assertNull(deletedAttachment);
    }

}