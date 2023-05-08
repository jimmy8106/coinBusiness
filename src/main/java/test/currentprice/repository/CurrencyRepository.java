package test.currentprice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import test.currentprice.model.Currency;

public interface CurrencyRepository extends JpaRepository<Currency, String> {

    @Modifying
    @Query(value = "insert into currency (code,name) VALUES (:code,:name)", nativeQuery = true)
    void insert(@Param("code") String code, @Param("name") String name);

}
