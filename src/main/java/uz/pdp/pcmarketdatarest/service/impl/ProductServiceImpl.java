package uz.pdp.pcmarketdatarest.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uz.pdp.pcmarketdatarest.repository.ProductRepository;
import uz.pdp.pcmarketdatarest.entity.Product;
import uz.pdp.pcmarketdatarest.exception.ResourceNotFoundException;
import uz.pdp.pcmarketdatarest.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product findById(Long id) {
        return productRepository.findById(id).orElseThrow(
            () -> new ResourceNotFoundException(Product.class.getSimpleName(), id)
        );
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }
    
}
