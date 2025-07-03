package com.example.anycompmarketplace.service;

import com.example.anycompmarketplace.model.Item;
import com.example.anycompmarketplace.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {
    @Autowired
    private ItemRepository itemRepository;

    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    public Item getItemById(Long id) {
        return itemRepository.findById(id).orElse(null);
    }

    public Item createItem(Item item) {
        return itemRepository.save(item);
    }

    public Item updateItem(Long id, Item item) {
        item.setId(id);
        return itemRepository.save(item);
    }

    public void deleteItem(Long id) {
        itemRepository.deleteById(id);
    }

    public List<Item> getItemsBySellerId(Long sellerId) {
        return itemRepository.findAll().stream()
                .filter(item -> item.getSeller() != null && item.getSeller().getId().equals(sellerId))
                .toList();
    }
}
// This service class provides methods to interact with the ItemRepository.