package uz.pdp.pcmarketdatarest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import uz.pdp.pcmarketdatarest.entity.Supplier;

@RepositoryRestResource
public interface SupplierRepository extends JpaRepository<Supplier, Long> {
}
