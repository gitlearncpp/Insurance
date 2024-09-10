package com.example.insurance.controller;

import com.example.insurance.model.Asset;
import com.example.insurance.service.AssetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/assets")
public class AssetController {

    @Autowired
    private AssetService assetService;

    @PostMapping
    public Asset calculateAndSaveAsset(@RequestBody Asset asset) {
        return assetService.calculatePremium(asset);
    }
}