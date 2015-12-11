package ch.bfh.bti7051.phototraveler.service;

import ch.bfh.bti7051.phototraveler.service.dto.AttachmentDTO;
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
        AttachmentDTO newAttachment = new AttachmentDTO();
        newAttachment.setFilename("testfile");
        newAttachment = service.create(newAttachment);

        // Read
        AttachmentDTO readAttachment = service.read(newAttachment.getId());
        Assert.assertTrue(newAttachment.getFilename().equals(readAttachment.getFilename()));

        // Update
        readAttachment.setFilename("fineName2");
        readAttachment = service.update(readAttachment);
        AttachmentDTO updatedAttachment = service.read(readAttachment.getId());
        Assert.assertTrue(readAttachment.getFilename().equals(updatedAttachment.getFilename()));

        // Delete
        service.delete(updatedAttachment);
        AttachmentDTO deletedAttachment = service.read(readAttachment.getId());
        Assert.assertNull(deletedAttachment);
    }

}