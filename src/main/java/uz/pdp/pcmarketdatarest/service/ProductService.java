package uz.pdp.pcmarketdatarest.service;

import uz.pdp.pcmarketdatarest.entity.Product;

public interface ProductService {
    Product findById(Long id);
    Product save(Product product);
}
