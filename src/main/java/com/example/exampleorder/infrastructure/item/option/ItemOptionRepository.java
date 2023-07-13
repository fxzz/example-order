package com.example.exampleorder.infrastructure.item.option;

import com.example.exampleorder.domain.item.option.ItemOption;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemOptionRepository extends JpaRepository<ItemOption, Long> {
}