package ch.bfh.bti7051.phototraveler.repository;

import ch.bfh.bti7051.phototraveler.model.Attachment;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;

import static org.junit.Assert.*;

/**
 * Created by Kaspar on 17.11.2015.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/persistenceContext.xml")
public class AttachmentRepositoryTest {

    @Inject
    private AttachmentRepository attachmentRepository;

    @Test
    public void test() {

        // Create
        Attachment newAttachment = new Attachment();
        newAttachment.setFilename("Test");
        attachmentRepository.save(newAttachment);

        // Read
        Attachment readAttachment = attachmentRepository.findOne(newAttachment.getId());
        org.junit.Assert.assertTrue(newAttachment.getFilename().equals(readAttachment.getFilename()));

        // Update
        readAttachment.setFilename("Test2");
        readAttachment = attachmentRepository.save(readAttachment);
        Attachment updatedAttachment = attachmentRepository.findOne(readAttachment.getId());
        org.junit.Assert.assertTrue(readAttachment.getFilename().equals(updatedAttachment.getFilename()));

        // Delete
        attachmentRepository.delete(updatedAttachment);
        Attachment deletedBook = attachmentRepository.findOne(readAttachment.getId());
        org.junit.Assert.assertNull(deletedBook);
    }

}