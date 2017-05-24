package com.shuidi.zhanggui.api;

import org.junit.Test;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by wandy on 2017-05-24.
 */
public class UcUserApiTest extends ApiDbunitBaseTest{
    @Test
    public void getUser() throws Exception {
        RequestBuilder request = null;

        //测试获取车辆列表
        request = MockMvcRequestBuilders.get("/user/10");
        MvcResult result = mvc.perform(request).andExpect(status().isOk()).andReturn();
               // .andExpect(content().json("{\"id\":4292,\"licensePlate\":\"冀R81120\",\"departmentId\":2016,\"truckBrand\":\"QITA\",\"plateRegDate\":null,\"buyingPrice\":null,\"weight\":null,\"auditStatus\":\"NOTAUDIT\",\"status\":\"ENABLED\",\"note\":null,\"enterpriseId\":639,\"serviceLife\":null,\"type\":\"TRACTOR\",\"gpsStatus\":null,\"createTime\":1492887267000,\"updateTime\":1492887267000,\"operateId\":-2,\"maxTravelSpeed\":null,\"noloadLength\":null,\"noloadWidth\":null,\"noloadHeight\":null,\"inspectionCycle\":null,\"disableNote\":\"\",\"orderBy\":null,\"licensePlateLike\":null,\"truckBrandLike\":null,\"plateRegDateBegin\":null,\"plateRegDateEnd\":null,\"auditStatusLike\":null,\"statusLike\":null,\"noteLike\":null,\"typeLike\":null,\"gpsStatusLike\":null,\"createTimeBegin\":null,\"createTimeEnd\":null,\"updateTimeBegin\":null,\"updateTimeEnd\":null,\"disableNoteLike\":null,\"createTimeCharAll\":\"2017-04-23 02:54:27\",\"createTimeChar\":\"2017-04-23\",\"plateRegDateCharAll\":\"\",\"plateRegDateChar\":\"\",\"updateTimeCharAll\":\"2017-04-23 02:54:27\",\"updateTimeChar\":\"2017-04-23\"}"));
        System.out.println("UcUserApiTest.getUser().get");
    }

}