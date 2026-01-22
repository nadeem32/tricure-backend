package com.tricure.backend.repository;

import com.tricure.backend.entity.ProductDemoPage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProductDemoPageRepository extends JpaRepository<ProductDemoPage, Long> {
    List<ProductDemoPage> findByProductIdOrderBySortOrderAsc(Long productId);
}
