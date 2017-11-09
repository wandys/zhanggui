package com.shuidi.zhanggui.api;

import com.alibaba.fastjson.JSONObject;
import com.shuidi.commons.enums.Degree;
import com.shuidi.commons.exception.CheckedException;
import com.shuidi.commons.resource.CollectsResource;
import com.shuidi.commons.resource.SingleResource;
import com.shuidi.zhanggui.service.bl.CategoryService;
import com.shuidi.zhanggui.service.dal.entity.Category;
import com.shuidi.zhanggui.service.dal.entity.Shop;
import org.apache.commons.lang.StringUtils;
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

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

@Controller
@RequestMapping(value = "/category")
@ExposesResourceFor(Category.class)
@EnableEntityLinks
@EnableHypermediaSupport(type = EnableHypermediaSupport.HypermediaType.HAL)
public class CategoryApi {

  @Autowired
  private EntityLinks entityLinks;

  @Autowired
  private CategoryService categoryService;

  /**
   * 根据id获取分类信息.
   *
   * @return
   */
  @RequestMapping(value = "/{id}",method = RequestMethod.GET)
  @ResponseBody
  public ResponseEntity getCategory(@PathVariable Long id) throws InterruptedException, ExecutionException, TimeoutException {
    if (id == null) {
      throw new CheckedException("id can't be null");
    }
    Category category = categoryService.getById(id);
    Link selfLink = entityLinks.linkToSingleResource(Category.class, "${id}");
    SingleResource<JSONObject> resource = SingleResource.resource(category);
    resource.add(selfLink);
    return ResponseEntity.ok(resource);
  }

  /**
   * 根据id获取下级分类.
   *
   * @return
   */
  @RequestMapping(value = "/{degree}/{id}",method = RequestMethod.GET)
  @ResponseBody
  public ResponseEntity getCategorys(@PathVariable Long id,@PathVariable Degree degree) throws InterruptedException, ExecutionException, TimeoutException {
    if (degree == null) {
      throw new CheckedException("degree can't be null");
    } else if ((degree == Degree.SECOND ||degree == Degree.THIRD ) && id == null) {
      throw new CheckedException("id or category degree can't be null");
    }

    Map<String,Object> search = new HashMap<>();
    if (degree == Degree.FIRST) {
      search.put("firstDegree",id);
    } else if (degree == Degree.SECOND) {
      search.put("firstCategoryId",id);
    } else if (degree == Degree.THIRD) {
      search.put("secondCategoryId",id);
    }
    List<Category> categories = categoryService.findCategoryList(search);
    Link selfLink = entityLinks.linkToSingleResource(Category.class, "${id}");
    Link collectionLink = entityLinks.linkToCollectionResource(Category.class);
    CollectsResource<JSONObject> resource = CollectsResource.resource(categories);
    resource.add(selfLink,collectionLink);
    return ResponseEntity.ok(resource);
  }

  /**
   * 新增分类.
   *
   * @return
   */
  @RequestMapping(value = "/",method = RequestMethod.POST)
  @ResponseBody
  public ResponseEntity addCategory(@RequestBody Category category) throws InterruptedException, ExecutionException, TimeoutException {
    if (category == null) {
      throw new CheckedException("category info can't be null");
    }
    if (StringUtils.isBlank(category.getCategroyName())) {
      throw new CheckedException("category name can't be null");
    }
    Long categoryId = categoryService.insertCategory(category);
    category.setId(categoryId);
    Link selfLink = entityLinks.linkToSingleResource(Category.class, categoryId);
    SingleResource<JSONObject> resource = SingleResource.resource(category);
    resource.add(selfLink);
    return ResponseEntity.ok(resource);
  }
  /**
   * 更新分类.
   *
   * @return
   */
  @RequestMapping(value = "/",method = RequestMethod.PUT)
  @ResponseBody
  public ResponseEntity changeCategory(@RequestBody Category category) throws InterruptedException, ExecutionException, TimeoutException {
    if (category == null || category.getId() == null) {
      throw new CheckedException("change category info can't be null");
    }
    categoryService.updateCategory(category);
    Link selfLink = entityLinks.linkToSingleResource(Category.class, category.getId());
    SingleResource<JSONObject> resource = SingleResource.resource(category);
    resource.add(selfLink);
    return ResponseEntity.ok(resource);
  }



}


