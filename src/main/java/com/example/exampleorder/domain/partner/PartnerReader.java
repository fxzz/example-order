package com.example.exampleorder.domain.partner;

public interface PartnerReader {
   Partner getPartner(Long partnerId);
   Partner getPartner(String partnerToken);
}