   package com.example.anycompmarketplace.repository;

   import com.example.anycompmarketplace.model.Item;
   import org.springframework.data.jpa.repository.JpaRepository;

   public interface ItemRepository extends JpaRepository<Item, Long> {
   }
// This interface extends JpaRepository, which provides CRUD operations for the Item entity.
// The Long type parameter indicates that the ID of the Item entity is of type Long.