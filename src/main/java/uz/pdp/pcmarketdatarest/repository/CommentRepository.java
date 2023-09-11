package uz.pdp.pcmarketdatarest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import uz.pdp.pcmarketdatarest.entity.Comment;
import uz.pdp.pcmarketdatarest.projection.CommentProjection;

@RepositoryRestResource(excerptProjection = CommentProjection.class)
public interface CommentRepository extends JpaRepository<Comment, Long> {
}
