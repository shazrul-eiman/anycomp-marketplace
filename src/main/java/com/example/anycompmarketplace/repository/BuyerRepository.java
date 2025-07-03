   package com.example.anycompmarketplace.repository;

   import com.example.anycompmarketplace.model.Buyer;
   import org.springframework.data.jpa.repository.JpaRepository;

   public interface BuyerRepository extends JpaRepository<Buyer, Long> {
   }
// This interface extends JpaRepository, which provides CRUD operations for the Buyer entity.
// The Long type parameter indicates that the ID of the Buyer entity is of type Long.