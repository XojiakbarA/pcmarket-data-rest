package uz.pdp.pcmarketdatarest.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.pdp.pcmarketdatarest.entity.AttributeValue;

@Projection(name = "attributeValue", types = AttributeValue.class)
public interface AttributeValueProjection {
    Long getId();
    Long getValue();
}
