package com.example.exampleorder.domain.partner;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Builder
@Getter
@ToString
public class PartnerCommand {

    private final String partnerName;
    private final String businessNo;
    private final String email;

    public Partner toEntity() {
        return Partner.builder()
                .partnerName(partnerName)
                .businessNo(businessNo)
                .email(email)
                .build();
    }
}
