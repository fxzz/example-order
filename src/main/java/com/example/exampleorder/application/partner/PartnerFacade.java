package com.example.exampleorder.application.partner;

import com.example.exampleorder.domain.notification.NotificationService;
import com.example.exampleorder.domain.partner.PartnerCommand;
import com.example.exampleorder.domain.partner.PartnerInfo;
import com.example.exampleorder.domain.partner.PartnerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class PartnerFacade {
    private final PartnerService partnerService;
    private final NotificationService notificationService;

    public PartnerInfo registerPartner(PartnerCommand command) {
       var partnerInfo = partnerService.registerPartner(command);
       notificationService.sendEmail(partnerInfo.getEmail(), "title", "description");
       return partnerInfo;
    }
}
