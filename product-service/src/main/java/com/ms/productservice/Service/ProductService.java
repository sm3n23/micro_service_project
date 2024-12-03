package com.ms.productservice.Service;

import com.ms.productservice.dto.ProductRequest;
import com.ms.productservice.dto.ProductResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    public ProductResponse createProduct(ProductRequest productRequest);

    public List<ProductResponse> getAllProducts();
}
