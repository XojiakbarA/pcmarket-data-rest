package uz.pdp.pcmarketdatarest.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity(name = "attachment_contents")
public class AttachmentContent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private byte[] bytes;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Attachment attachment;
}
