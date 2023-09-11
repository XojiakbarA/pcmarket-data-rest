package uz.pdp.pcmarketdatarest.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.pdp.pcmarketdatarest.entity.Brand;

@Projection(name = "brand", types = Brand.class)
public interface BrandProjection {
    Long getId();
    String getName();
}
