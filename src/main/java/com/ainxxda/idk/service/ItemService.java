package com.ainxxda.idk.service;

import com.ainxxda.idk.model.Item;
import com.ainxxda.idk.repository.ItemRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService {

    private final ItemRepository itemRepository;

    // Внедрение через конструктор
    @Autowired
    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    // Получение всех предметов
    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    // Получение предмета по ID
    public Optional<Item> getItemById(Long id) {
        return itemRepository.findById(id);
    }

    // Создание нового предмета
    public Item createItem(Item item) {
        return itemRepository.save(item);
    }

    // Обновление предмета по ID
    public Optional<Item> updateItem(Long id, Item newItemData) {
        return itemRepository.findById(id)
                .map(existingItem -> {
                    existingItem.setName(newItemData.getName());
                    existingItem.setDescription(newItemData.getDescription());
                    existingItem.setPrice(newItemData.getPrice());
                    return itemRepository.save(existingItem);
                });
    }

    // Удаление предмета по ID
    public void deleteItem(Long id) {
        itemRepository.deleteById(id);
    }
}
