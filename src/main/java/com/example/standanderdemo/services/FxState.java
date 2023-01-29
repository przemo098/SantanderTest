package com.example.standanderdemo.services;

import com.example.standanderdemo.model.Instrument;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
class FxState {
    public Map<String, Instrument> Instruments = new HashMap<String, Instrument>();
    public String[] Subscribers = new String[] {};
}
