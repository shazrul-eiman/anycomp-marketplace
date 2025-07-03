package com.example.anycompmarketplace.service;

import com.example.anycompmarketplace.model.Item;
import com.example.anycompmarketplace.model.Purchase;
import com.example.anycompmarketplace.repository.ItemRepository;
import com.example.anycompmarketplace.repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PurchaseService {
    @Autowired
    private PurchaseRepository purchaseRepository;

    @Autowired
    private ItemRepository itemRepository;

    public Purchase createPurchase(Purchase purchase) {
        // Check if the item is available
        Item item = itemRepository.findById(purchase.getItem().getId()).orElse(null);
        if (item != null && item.getQuantity() >= purchase.getQuantity()) {
            // Deduct quantity from item stock
            item.setQuantity(item.getQuantity() - purchase.getQuantity());
            itemRepository.save(item);
            return purchaseRepository.save(purchase);
        } else {
            throw new RuntimeException("Item not available or insufficient quantity.");
        }
    }

    public List<Purchase> getAllPurchases() {
        return purchaseRepository.findAll();
    }

    public Purchase getPurchaseById(Long id) {
        return purchaseRepository.findById(id).orElse(null);
    }
}
