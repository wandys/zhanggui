package com.shuidi.zhanggui.api;

import com.shuidi.zhanggui.service.bl.BrandService;
import com.shuidi.zhanggui.service.dal.entity.Brand;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wandy on 17-8-6.
 */
//@RestControlle
@Controller
@RequestMapping(value = "/brand")
public class BrandApi {
  @Autowired
  private BrandService brandService;

  @RequestMapping(value = "/",method = RequestMethod.GET)
  @ResponseBody
  public List<Brand> findBrands(Long id,String brandNo) {
    Map<String,Object> param = new HashMap<>();
    param.put("id",id);
    param.put("brandNo",brandNo);
    Brand brand = new Brand();
    brand.setId(id);
    brand.setBrandNo(brandNo);
    List<Brand> brands = brandService.findBrandList(param);
    return brands;

  }

}
