package com.example.exampleorder.infrastructure.item.optiongroup;

import com.example.exampleorder.domain.item.optiongroup.ItemOptionGroup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemOptionGroupRepository extends JpaRepository<ItemOptionGroup, Long> {
}