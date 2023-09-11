package uz.pdp.pcmarketdatarest.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.pdp.pcmarketdatarest.entity.Category;

@Projection(name = "category", types = Category.class)
public interface CategoryProjection {
    Long getId();
    String getName();
}
