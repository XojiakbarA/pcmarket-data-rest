package uz.pdp.pcmarketdatarest.projection;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;
import uz.pdp.pcmarketdatarest.entity.Attribute;

@Projection(name = "attribute", types = Attribute.class)
public interface AttributeProjection {
    Long getId();

    @Value("#{target.attributeName.name}")
    String getName();

    @Value("#{target.attributeValue.value}")
    String getValue();
}
