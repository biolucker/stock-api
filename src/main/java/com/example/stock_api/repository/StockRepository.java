package com.example.stock_api.repository;
import com.example.stock_api.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface StockRepository extends JpaRepository<Stock, Long> {

    @Procedure(procedureName = "upsert_stock")
    void upsertStock(
            @Param("p_product_id") Long productId,
            @Param("p_stock") int stock,
            @Param("p_sells") int sells,
            @Param("p_ingress") int ingress
    );

    @Procedure(procedureName = "add_sell")
    void addSell(
            @Param("p_product_id") Long productId,
            @Param("p_quantity") int quantity
    );

    @Procedure(procedureName = "add_ingress")
    void addIngress(
            @Param("p_product_id") Long productId,
            @Param("p_quantity") int quantity
    );

    @Query(value = "SELECT get_stock_total(:productId)", nativeQuery = true)
    Integer getTotal(@Param("productId") Long productId);
}