//package ch.bfh.bti7051.phototraveler.rest.controller;
//
//import ch.bfh.bti7051.phototraveler.model.Attachment;
//import ch.bfh.bti7051.phototraveler.service.dto.AttachmentDTO;
//import ch.bfh.bti7051.phototraveler.service.services.AttachmentService;
//import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.annotation.*;
//
//import javax.inject.Inject;
//import javax.ws.rs.Consumes;
//import java.util.Collection;
//
///**
// * Kaspar
// */
//@RestController
//@RequestMapping("/attachment")
//public class AttachmentController {
//
//    @Inject
//    private AttachmentService attachmentService;
//
//    /**
//     * Create
//     */
//    @RequestMapping(method = RequestMethod.POST)
//    public AttachmentDTO createAttachment(@RequestBody AttachmentDTO attachment) {
//        AttachmentDTO createdAttachment = this.attachmentService.create(attachment);
//        System.out.println("Attachment created with id = " + createdAttachment.getId());
//        return createdAttachment;
//    }
//
//    /**
//     * Read
//     */
//    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
//    public AttachmentDTO getAttachment(@PathVariable long id) {
//        System.out.println("Attachment requested with id = " + id);
//        return attachmentService.read(id);
//    }
//
//    /**
//     * ReadAll
//     */
////    @RequestMapping(method = RequestMethod.GET)
////    public Collection<AttachmentDTO> getAttachments() {
////        return attachmentService.list();
////    }
//    @RequestMapping(method = RequestMethod.GET)
//    public Collection<Attachment> getAttachments() {
//        System.out.println("works!");
//        return attachmentService.list2();
//    }
//
//    @RequestMapping(method = RequestMethod.POST, value = "/test")
//    @Consumes("application/json")
//    public Attachment test(@RequestBody Attachment attachment) {
//        return attachmentService.create2(attachment);
//    }
//
//    /**
//     * Update
//     */
//    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
//    public AttachmentDTO updateAttachment(@RequestBody AttachmentDTO attachment) {
//        AttachmentDTO updatedAttachment = attachmentService.update(attachment);
//        System.out.println("Attachment updated with id = " + updatedAttachment.getId());
//        return updatedAttachment;
//    }
//
//    /**
//     * Delete
//     */
//    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
//    @ResponseStatus(HttpStatus.OK)
//    public void deleteAttachment(@PathVariable long id) {
//        AttachmentDTO attachment = attachmentService.read(id);
//        attachmentService.delete(attachment);
//        System.out.println("Delete Attachment with id = " + id);
//    }
//
//}
