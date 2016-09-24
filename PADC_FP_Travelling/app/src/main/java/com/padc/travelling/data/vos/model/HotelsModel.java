package com.padc.travelling.data.vos.model;

import com.padc.travelling.data.vos.HotelsVO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dellpc on 24-Sep-16.
 */
public class HotelsModel extends BaseModel {

    public static final String BROADCAST_DATA_LOADED = "BROADCAST_DATA_LOADED";
    public List<HotelsVO> hotelsVOList;
    private static TourPackageModel hotelsModel;

    public HotelsModel() {
        super();
        hotelsVOList = new ArrayList<>();
        dataAgent.
    }
}
