package uz.pdp.pcmarketdatarest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import uz.pdp.pcmarketdatarest.entity.AttributeValue;
import uz.pdp.pcmarketdatarest.projection.AttributeValueProjection;

@RepositoryRestResource(excerptProjection = AttributeValueProjection.class)
public interface AttributeValueRepository extends JpaRepository<AttributeValue, Long> {
}
