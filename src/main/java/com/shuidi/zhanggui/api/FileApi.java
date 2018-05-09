package com.shuidi.zhanggui.api;

import com.shuidi.commons.resource.SingleResource;
import com.shuidi.commons.utils.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.hateoas.EntityLinks;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.config.EnableHypermediaSupport;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by wandy on 17-8-6.
 */
//@RestControlle
@Controller
@RequestMapping(value = "/file")
@ExposesResourceFor(String.class)
@EnableHypermediaSupport(type = EnableHypermediaSupport.HypermediaType.HAL)
public class FileApi extends BaseApi {

  @Autowired
  private EntityLinks entityLinks;


  @Value("${img.location}")
  private String location;
  @Value("${img.url}")
  private String imgUrl;

/*  @RequestMapping(value = "/{name}", method = RequestMethod.GET)
  @ResponseBody
  public ResponseEntity getBrand(@PathVariable String name) {
    if (id == null) {
      throw new CheckedException("id can't be null");
    }

    return ResponseEntity.ok(resource);
  }*/


  @RequestMapping(value = "/", method = RequestMethod.POST)
  @ResponseBody
  public ResponseEntity uploadImg(MultipartFile file) throws Exception {
    String contentType = file.getContentType();
    String fileName = file.getOriginalFilename();
    FileUtil.uploadFile(file.getBytes(), location, fileName);
    Link selfLink = entityLinks.linkToSingleResource(String.class, "");
    SingleResource<String> resource = new SingleResource(imgUrl + fileName);
    resource.add(selfLink);
    return ResponseEntity.ok(resource);
  }

}
