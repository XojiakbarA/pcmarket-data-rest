package uz.pdp.pcmarketdatarest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import uz.pdp.pcmarketdatarest.entity.Category;
import uz.pdp.pcmarketdatarest.projection.CategoryProjection;

@RepositoryRestResource(excerptProjection = CategoryProjection.class)
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
