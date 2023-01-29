package com.example.standanderdemo.services;

import com.example.standanderdemo.model.FxAdjustment;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
//@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE,
//        proxyMode = ScopedProxyMode.TARGET_CLASS)
public final class FxManagerService implements IFxManagerService {
    private FxState fxState;
    private FxManagerService(FxState fxState) {
        this.fxState = fxState;
    }

    private void UpdateInstrument(FxAdjustment newInstrument){
        var existingInstrument = fxState.Instruments.get(newInstrument.GetName());
        if(existingInstrument != null){
            existingInstrument.Adjust(newInstrument);
        } else {
            fxState.Instruments.put(newInstrument.GetName(), newInstrument);
        }
    }

    void NotifySubscribers(String[] subscribers){
        // TODO: to implement
    }

    @Override
    public void Update(List<FxAdjustment> newInstruments){
        for (var instrument : newInstruments)
        {
            UpdateInstrument(instrument);
        }

        NotifySubscribers(fxState.Subscribers);
    }
}

