package uz.pdp.pcmarketdatarest.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.pdp.pcmarketdatarest.entity.Comment;

@Projection(name = "comment", types = Comment.class)
public interface CommentProjection {
    Long getId();
    String getText();
    Byte getRating();
    String getName();
    String getEmail();
}
