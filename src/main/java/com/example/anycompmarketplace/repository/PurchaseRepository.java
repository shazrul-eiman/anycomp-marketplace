   package com.example.anycompmarketplace.repository;

   import com.example.anycompmarketplace.model.Purchase;
   import org.springframework.data.jpa.repository.JpaRepository;

   public interface PurchaseRepository extends JpaRepository<Purchase, Long> {
   }
// This interface extends JpaRepository, which provides CRUD operations for the Purchase entity.
// The Long type parameter indicates that the ID of the Purchase entity is of type Long.