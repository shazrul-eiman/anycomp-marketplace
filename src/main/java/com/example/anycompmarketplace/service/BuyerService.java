   package com.example.anycompmarketplace.service;

   import com.example.anycompmarketplace.model.Buyer;
   import com.example.anycompmarketplace.repository.BuyerRepository;
   import org.springframework.beans.factory.annotation.Autowired;
   import org.springframework.stereotype.Service;

   import java.util.List;

   @Service
   public class BuyerService {
       @Autowired
       private BuyerRepository buyerRepository;

       public List<Buyer> getAllBuyers() {
           return buyerRepository.findAll();
       }

       public Buyer getBuyerById(Long id) {
           return buyerRepository.findById(id).orElse(null);
       }

       public Buyer createBuyer(Buyer buyer) {
           return buyerRepository.save(buyer);
       }

       public Buyer updateBuyer(Long id, Buyer buyer) {
           buyer.setId(id);
           return buyerRepository.save(buyer);
       }

       public void deleteBuyer(Long id) {
           buyerRepository.deleteById(id);
       }
   }
// This service class provides methods to manage buyers in the marketplace.
// It includes methods to get all buyers, get a buyer by ID, create a new buyer,
// update an existing buyer, and delete a buyer by ID.