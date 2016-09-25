package com.padc.travelling.data.vos.model;

import com.padc.travelling.data.vos.agents.TourPackageDataAgent;
import com.padc.travelling.data.vos.agents.retrofit.RetrofitDataAgent;

import de.greenrobot.event.EventBus;

//import org.greenrobot.eventbus.EventBus;


/**
 * Created by aung on 7/15/16.
 */
public abstract class BaseModel {

    private static final int INIT_DATA_AGENT_RETROFIT = 1;

    protected RetrofitDataAgent dataAgent;

    public BaseModel() {
        initDataAgent(INIT_DATA_AGENT_RETROFIT);

        EventBus eventBus = EventBus.getDefault();
        if (!eventBus.isRegistered(this)) {
            eventBus.register(this);
        }
    }

    private void initDataAgent(int initType) {
        switch (initType) {
               case INIT_DATA_AGENT_RETROFIT:
                dataAgent = RetrofitDataAgent.getInstance();
                break;
        }
    }

    public void onEventMainThread(Object obj) {

    }
}
