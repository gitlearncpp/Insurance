package com.example.insurance.service;

import com.example.insurance.model.Asset;
import com.example.insurance.repository.AssetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AssetService {

    @Autowired
    private AssetRepository assetRepository;

    public Asset calculatePremium(Asset asset) {
        double multiplier = 1.0; // Logika do określania mnożnika na podstawie lokalizacji
        asset.setPremium((asset.getBuildingValue() + asset.getContentValue()) * multiplier);
        return assetRepository.save(asset);
    }
}