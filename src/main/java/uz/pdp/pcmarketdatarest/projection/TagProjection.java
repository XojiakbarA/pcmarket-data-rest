package uz.pdp.pcmarketdatarest.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.pdp.pcmarketdatarest.entity.Tag;

@Projection(name = "tag", types = Tag.class)
public interface TagProjection {
    Long getId();
    String getName();
}
