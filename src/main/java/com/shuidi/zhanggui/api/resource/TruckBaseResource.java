package com.shuidi.zhanggui.api.resource;


import com.shuidi.zhanggui.service.dal.entity.TruckBase;
import org.springframework.hateoas.ResourceSupport;

import java.util.ArrayList;
import java.util.List;

/**
 * hateoas中对应的车辆基础信息的资源类
 *
 * Created by wandy on 2017-05-17.
 */
public class TruckBaseResource extends ResourceSupport {


    private List<TruckBase> truckBases;

    public TruckBaseResource(TruckBase truckBase){
        List<TruckBase> truckBaseList = new ArrayList<>();
        truckBaseList.add(truckBase);
        truckBases = truckBaseList;
    }

    public TruckBaseResource(List<TruckBase> truckBases){
        this.truckBases = truckBases;
    }

    public void setTruckBases(List<TruckBase> truckBases) {
        this.truckBases = truckBases;
    }

    public List<TruckBase> getTruckBases() {
        return truckBases;
    }
}
