package ch.bfh.bti7051.phototraveler.service.dto;

public class AttachmentDTO {

    private Long id;

    private String filename;

    private Boolean filetype;

    private Byte[] data;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public Boolean getFiletype() {
        return filetype;
    }

    public void setFiletype(Boolean filetype) {
        this.filetype = filetype;
    }

    public Byte[] getData() {
        return data;
    }

    public void setData(Byte[] data) {
        this.data = data;
    }
}
