package uz.pdp.pcmarketdatarest.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.pdp.pcmarketdatarest.entity.Product;

@Projection(name = "product", types = Product.class)
public interface ProductProjection {
    Long getId();
    String getName();
    Integer getCount();
    Double getPrice();
    BrandProjection getBrand();
    CategoryProjection getCategory();
}
