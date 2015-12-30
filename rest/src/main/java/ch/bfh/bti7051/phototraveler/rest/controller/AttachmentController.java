package ch.bfh.bti7051.phototraveler.rest.controller;

import ch.bfh.bti7051.phototraveler.model.Attachment;
import ch.bfh.bti7051.phototraveler.service.dto.AttachmentDTO;
import ch.bfh.bti7051.phototraveler.service.services.AttachmentService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.Collection;

/**
 * Kaspar
 */
@Controller
@RequestMapping("/attachment")
public class AttachmentController {

    @Inject
    private AttachmentService attachmentService;

    /**
     * Create
     */
    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public AttachmentDTO createAttachment(@RequestBody AttachmentDTO attachment) {
        AttachmentDTO createdAttachment = this.attachmentService.create(attachment);
        System.out.println("Attachment created with id = " + createdAttachment.getId());
        return createdAttachment;
    }

    /**
     * Read
     */
    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    @ResponseBody
    public AttachmentDTO getAttachment(@PathVariable long id) {
        System.out.println("Attachment requested with id = " + id);
        //return attachmentService.read(id);
        AttachmentDTO dummy = new AttachmentDTO();
        dummy.setFilename("blume");
        dummy.setFiletype("pdf");
        return dummy;
    }

    /**
     * ReadAll
     */
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public Collection<AttachmentDTO> getAttachments() {
        return attachmentService.list();
    }

    /**
     * Update
     */
    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    @ResponseBody
    public AttachmentDTO updateAttachment(@RequestBody AttachmentDTO attachment) {
        AttachmentDTO updatedAttachment = attachmentService.update(attachment);
        System.out.println("Attachment updated with id = " + updatedAttachment.getId());
        return updatedAttachment;
    }

    /**
     * Delete
     */
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void deleteAttachment(@PathVariable long id) {
        AttachmentDTO attachment = attachmentService.read(id);
        attachmentService.delete(attachment);
        System.out.println("Delete Attachment with id = " + id);
    }

}
