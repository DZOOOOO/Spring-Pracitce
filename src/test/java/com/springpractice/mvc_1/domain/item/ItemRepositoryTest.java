package com.springpractice.mvc_1.domain.item;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ItemRepositoryTest {

    ItemRepository itemRepository = new ItemRepository();

    @AfterEach
    public void afterEach() {
        itemRepository.clearStore();
    }

    @Test
    void save() {
        // given
        Item item = new Item("itemA", 1000, 10);

        // then
        Item savedItem = itemRepository.save(item);

        // when
        Item findItem = itemRepository.findById(savedItem.getId());
        assertThat(findItem).isEqualTo(savedItem);
    }

    @Test
    void findAll() {
        // given
        Item item1 = new Item("itemA", 1000, 10);
        Item item2 = new Item("itemB", 2000, 15);
        Item item3 = new Item("itemC", 3000, 20);

        // then
        itemRepository.save(item1);
        itemRepository.save(item2);
        itemRepository.save(item3);

        // when
        List<Item> items = itemRepository.findAll();
        assertThat(items.size()).isEqualTo(3);
        assertThat(items).contains(item1, item2);
    }

    @Test
    void update() {
        // given
        Item item1 = new Item("itemA", 1000, 10);
        Item savedItem = itemRepository.save(item1);
        Long itemId = savedItem.getId();

        // then
        Item updateParam = new Item("item2", 2000, 30);
        itemRepository.update(itemId, updateParam);

        Item findItem = itemRepository.findById(itemId);

        assertThat(findItem.getItemName()).isEqualTo(updateParam.getItemName());
        assertThat(findItem.getPrice()).isEqualTo(updateParam.getPrice());
        assertThat(findItem.getQuantity()).isEqualTo(updateParam.getQuantity());

    }
}