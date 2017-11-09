package com.shuidi.zhanggui.api;

import com.alibaba.fastjson.JSONObject;
import com.shuidi.commons.exception.CheckedException;
import com.shuidi.commons.resource.CollectsResource;
import com.shuidi.commons.resource.OnlyResource;
import com.shuidi.commons.resource.SingleResource;
import com.shuidi.zhanggui.service.bl.BrandService;
import com.shuidi.zhanggui.service.dal.entity.Brand;
import com.shuidi.zhanggui.service.dal.entity.Category;
import com.shuidi.zhanggui.service.dal.entity.Shop;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityLinks;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.config.EnableEntityLinks;
import org.springframework.hateoas.config.EnableHypermediaSupport;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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
@ExposesResourceFor(Brand.class)
@EnableHypermediaSupport(type = EnableHypermediaSupport.HypermediaType.HAL)
public class BrandApi extends BaseApi {

  @Autowired
  private EntityLinks entityLinks;

  @Autowired
  private BrandService brandService;

  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  @ResponseBody
  public ResponseEntity getBrand(@PathVariable Long id) {
    if (id == null) {
      throw new CheckedException("id can't be null");
    }
    Brand brand = brandService.getById(id);
    Link selfLink = entityLinks.linkToSingleResource(Brand.class, "${id}");
    SingleResource<JSONObject> resource = SingleResource.resource(brand);
    resource.add(selfLink);
    return ResponseEntity.ok(resource);
  }

  @RequestMapping(value = "/no/{no}", method = RequestMethod.GET)
  @ResponseBody
  public ResponseEntity getBrandByNo(@PathVariable String no) {
    if (StringUtils.isBlank(no)) {
      throw new CheckedException("brand no can't be null");
    }
    Map<String, Object> search = new HashMap<>();
    search.put("branNo", no);
    List<Brand> brands = brandService.findBrandList(search);
    Brand brand = brands.size() > 0 ? brands.get(0) : null;
    Link selfLink = entityLinks.linkToSingleResource(Brand.class, "${id}");
    SingleResource<JSONObject> resource = SingleResource.resource(brand);
    resource.add(selfLink);
    return ResponseEntity.ok(resource);
  }

  @RequestMapping(value = "/", method = RequestMethod.GET)
  @ResponseBody
  public ResponseEntity getBrands(String name) {
    Map<String, Object> search = new HashMap<>();
    search.put("brandName", name);

    List<Brand> brands = brandService.findBrandList(search);
    //Link selfLink = entityLinks.linkToSingleResource(Brand.class, "${id}");
    //Link collectionLink = entityLinks.linkToCollectionResource(Brand.class);
    CollectsResource<JSONObject> resource = CollectsResource.resource(brands);
    resource.add(getResultLink(null));
    return ResponseEntity.ok(resource);
  }

  @RequestMapping(value = "/", method = RequestMethod.POST)
  @ResponseBody
  public ResponseEntity addBrand(@RequestBody Brand brand) {
    if (brand == null
        || StringUtils.isBlank(brand.getBrandName())) {
      throw new CheckedException("brand name can't be null");
    }

    Long brandId = brandService.insertBrand(brand);
    brand.setId(brandId);
    SingleResource<JSONObject> resource = SingleResource.resource(brand);
    resource.add(getResultLink(brandId));
    return ResponseEntity.ok(resource);
  }

  @RequestMapping(value = "/", method = RequestMethod.PUT)
  @ResponseBody
  public ResponseEntity updateBrand(@RequestBody Brand brand) {
    if (brand == null
        || brand.getId() == null) {
      throw new CheckedException("brand or brand id can't be null");
    }

    brandService.updateBrand(brand);
    OnlyResource resource = OnlyResource.resource();
    resource.add(getResultLink(brand.getId()));
    return ResponseEntity.ok(resource);
  }

  /**
   * 获取链接.
   *
   * @param selfId 单资源id
   * @return
   */
  private Link[] getResultLink(Object selfId) {
    if (selfId == null) {
      selfId = "${id}";
    }
    Link selfLink = entityLinks.linkToSingleResource(Brand.class, selfId);
    Link collectionLink = entityLinks.linkToCollectionResource(Brand.class);
    return new Link[]{selfLink, collectionLink};
  }

}
