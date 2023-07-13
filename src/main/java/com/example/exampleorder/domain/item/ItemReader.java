package com.example.exampleorder.domain.item;

import java.util.List;

public interface ItemReader {
    Item getItemBy(String itemToken);
    List<ItemInfo.ItemOptionGroupInfo> getItemOptionSeries(Item item);
}