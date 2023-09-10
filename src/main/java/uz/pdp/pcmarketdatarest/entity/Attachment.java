package uz.pdp.pcmarketdatarest.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity(name = "attachments")
public class Attachment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String contentType;

    @Column(nullable = false)
    private Long size;

    @ManyToOne(fetch = FetchType.LAZY)
    private Product product;

    @OneToOne(mappedBy = "attachment", fetch = FetchType.LAZY)
    private AttachmentContent attachmentContent;
}
