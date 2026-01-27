package com.tricure.backend.controller;

import com.tricure.backend.entity.Product;
import com.tricure.backend.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
//@CrossOrigin(origins = "*")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productRepository.save(product);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        return productRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product productDetails) {
        return productRepository.findById(id)
                .map(product -> {
                    product.setName(productDetails.getName());
                    product.setDescription(productDetails.getDescription());
                    product.setCategory(productDetails.getCategory());
                    product.setStatus(productDetails.getStatus());
                    product.setPrice(productDetails.getPrice());
                    return ResponseEntity.ok(productRepository.save(product));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        if (productRepository.existsById(id)) {
            productRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
    @Autowired
    private com.tricure.backend.repository.ProductDemoPageRepository productDemoPageRepository;

    @GetMapping("/{id}/pages")
    public List<com.tricure.backend.entity.ProductDemoPage> getProductPages(@PathVariable Long id) {
        return productDemoPageRepository.findByProductIdOrderBySortOrderAsc(id);
    }

    @PostMapping("/{id}/pages")
    public com.tricure.backend.entity.ProductDemoPage addProductPage(@PathVariable Long id, @RequestBody com.tricure.backend.entity.ProductDemoPage page) {
        return productRepository.findById(id).map(product -> {
            page.setProduct(product);
            return productDemoPageRepository.save(page);
        }).orElseThrow(() -> new RuntimeException("Product not found"));
    }

    @DeleteMapping("/pages/{pageId}")
    public ResponseEntity<Void> deleteProductPage(@PathVariable Long pageId) {
        if (productDemoPageRepository.existsById(pageId)) {
            productDemoPageRepository.deleteById(pageId);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
