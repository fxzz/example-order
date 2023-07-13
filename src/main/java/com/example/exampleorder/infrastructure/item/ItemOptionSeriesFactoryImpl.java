package com.example.exampleorder.infrastructure.item;

import com.example.exampleorder.domain.item.Item;
import com.example.exampleorder.domain.item.ItemCommand;
import com.example.exampleorder.domain.item.ItemOptionSeriesFactory;
import com.example.exampleorder.domain.item.option.ItemOptionStore;
import com.example.exampleorder.domain.item.optiongroup.ItemOptionGroup;
import com.example.exampleorder.domain.item.optiongroup.ItemOptionGroupStore;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Component
@RequiredArgsConstructor
public class ItemOptionSeriesFactoryImpl implements ItemOptionSeriesFactory {
    private final ItemOptionGroupStore itemOptionGroupStore;
    private final ItemOptionStore itemOptionStore;

    @Override
    public List<ItemOptionGroup> store(ItemCommand.RegisterItemRequest command, Item item) {
        var itemOptionGroupRequestList = command.getItemOptionGroupRequestList();
        if (CollectionUtils.isEmpty(itemOptionGroupRequestList)) return Collections.emptyList();

        return itemOptionGroupRequestList.stream()
                .map(requestItemOptionGroup -> {
                    // itemOptionGroup store
                    var initItemOptionGroup = requestItemOptionGroup.toEntity(item);
                    var itemOptionGroup = itemOptionGroupStore.store(initItemOptionGroup);

                    // itemOption store
                    requestItemOptionGroup.getItemOptionRequestList().forEach(requestItemOption -> {
                        var initItemOption = requestItemOption.toEntity(itemOptionGroup);
                        itemOptionStore.store(initItemOption);
                    });

                    return itemOptionGroup;
                }).collect(Collectors.toList());
    }
}