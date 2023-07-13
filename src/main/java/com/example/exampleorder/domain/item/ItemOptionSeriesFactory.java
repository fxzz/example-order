package com.example.exampleorder.domain.item;

import com.example.exampleorder.domain.item.optiongroup.ItemOptionGroup;

import java.util.List;

public interface ItemOptionSeriesFactory {
    List<ItemOptionGroup> store(ItemCommand.RegisterItemRequest request, Item item);
}