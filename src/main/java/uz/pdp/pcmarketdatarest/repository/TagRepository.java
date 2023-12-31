package uz.pdp.pcmarketdatarest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import uz.pdp.pcmarketdatarest.entity.Tag;
import uz.pdp.pcmarketdatarest.projection.TagProjection;

@RepositoryRestResource(excerptProjection = TagProjection.class)
public interface TagRepository extends JpaRepository<Tag, Long> {
}
