package com.shuidi.zhanggui.api;

import com.shuidi.commons.resource.CollectsResource;
import com.shuidi.zhanggui.service.bl.CountryAreaService;
import com.shuidi.zhanggui.service.dal.entity.CountryArea;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.hateoas.EntityLinks;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.config.EnableEntityLinks;
import org.springframework.hateoas.config.EnableHypermediaSupport;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wandy on 17-8-6.
 */
@Controller
@RequestMapping(value = "/area")
@ExposesResourceFor(CountryArea.class)
@EnableEntityLinks
@EnableHypermediaSupport(type = EnableHypermediaSupport.HypermediaType.HAL)
public class CountryAreaApi {
  @Autowired
  private CountryAreaService countryAreaService;

  @Autowired
  private EntityLinks entityLinks;


  @RequestMapping(value = {"/"}, method = RequestMethod.GET)
  @ResponseBody
  public ResponseEntity findAreas(String areaNo) {

    Map<String, Object> searchMap = new HashMap<>();
    searchMap.put("pInfos", areaNo == null ? "" : areaNo);

    List<CountryArea> areas = countryAreaService.findAreas(searchMap);
    CollectsResource<CountryArea> resource = new CollectsResource<>(areas);
    Link link = entityLinks.linkToSingleResource(CountryArea.class, areaNo);
    resource.add(link);
    return ResponseEntity.ok(resource);

  }

}
