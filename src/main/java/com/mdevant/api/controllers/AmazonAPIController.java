package com.mdevant.api.controllers;

import com.mdevant.api.models.AmazonItem;
import com.mdevant.api.services.AmazonService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/bestsellers")
public class AmazonAPIController {
    private final AmazonService amazonService;
    public AmazonAPIController(AmazonService amazonService) {
        this.amazonService = amazonService;
    }
    @GetMapping("/fashion")
    public List<AmazonItem> getAmazonItem() {
        return amazonService.getFashionBestSellers();
    }
}
