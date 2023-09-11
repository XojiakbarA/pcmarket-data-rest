package uz.pdp.pcmarketdatarest.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.pdp.pcmarketdatarest.entity.AttributeName;

@Projection(name = "attributeName", types = AttributeName.class)
public interface AttributeNameProjection {
    Long getId();
    String getName();
}
