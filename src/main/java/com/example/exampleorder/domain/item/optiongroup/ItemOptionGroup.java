package com.example.exampleorder.domain.item.optiongroup;

import com.example.exampleorder.common.exception.InvalidParamException;
import com.example.exampleorder.domain.AbstractEntity;
import com.example.exampleorder.domain.item.Item;
import com.example.exampleorder.domain.item.option.ItemOption;
import com.google.common.collect.Lists;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import javax.persistence.*;
import java.util.List;

@Slf4j
@Getter
@Entity
@NoArgsConstructor
@Table(name = "item_option_groups")
public class ItemOptionGroup extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;
    private Integer ordering;
    private String itemOptionGroupName;

    // FetchType.LAZY 불필요한 로딩을 막아줘서 성능이 좋아지는 설정
    // CascadeType.PERSIST 하위 객체가 지워졌으면 같이 지워지고 같이 저장하는 옵션 설정
    // @JoinColumn(name = "item_id") : 별도의 매핑 테이블 생성 없이 기존 테이블에 컬럼 추가
    // mappedBy = "" : 참조관계의 주인이 되는 컬럼에 설정해야 정확하게 연결 시켜줌

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "itemOptionGroup", cascade = CascadeType.PERSIST)
    private List<ItemOption> itemOptionList = Lists.newArrayList();

    @Builder
    public ItemOptionGroup(Item item, Integer ordering, String itemOptionGroupName) {
        if (item == null) throw new InvalidParamException("ItemOptionGroup.item");
        if (ordering == null) throw new InvalidParamException("ItemOptionGroup.ordering");
        if (StringUtils.isBlank(itemOptionGroupName))
            throw new InvalidParamException("ItemOptionGroup.itemOptionGroupName");

        this.item = item;
        this.ordering = ordering;
        this.itemOptionGroupName = itemOptionGroupName;
    }

    public ItemOptionGroup addItemOption(ItemOption itemOption) {
        this.itemOptionList.add(itemOption);
        return this;
    }
}