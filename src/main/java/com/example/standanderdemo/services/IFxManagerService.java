package com.example.standanderdemo.services;

import com.example.standanderdemo.model.FxAdjustment;

import java.util.List;

public interface IFxManagerService {
    void Update(List<FxAdjustment> newInstruments);
}
