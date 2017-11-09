package com.shuidi.zhanggui.service.bl.impl;

import com.shuidi.zhanggui.service.bl.CategoryService;
import com.shuidi.zhanggui.service.bl.CountryAreaService;
import com.shuidi.zhanggui.service.dal.entity.Category;
import com.shuidi.zhanggui.service.dal.entity.CountryArea;
import org.apache.commons.lang.StringUtils;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wandy on 17-8-29.
 */
public class CategoryServiceImplTest extends ServiceBaseTest {

  @Autowired

  private CategoryService categoryService;

  @Test
  public void findAreas() throws Exception {

  }

  @Test
  //@Rollback(false)
  public void insert() throws Exception {
    File file = new File("/home/wandy/Desktop/分类合集/output.txt");
    Reader reader = new FileReader(file);
    BufferedReader bufferedReader = new BufferedReader(reader);
    String line = "";
    Long oneNo = null;
    Long twoNo = null;
    List<Category> countryAreas = new ArrayList<>();
    Long id = 1L;
    Step step = Step.first;
    while (StringUtils.isNotBlank(line = bufferedReader.readLine())) {
      //String datas = line.split(",");
      //String name = datas[1];
      String no;
      if (line.startsWith("111")) {
        no = line.replace("111", "");
        oneNo = id;//缓存市编码
        twoNo = null;
        step = Step.first;
       // pInfos = shengNo;
      } else if (line.startsWith("222")) {
        no = line.replace("222", "");
        twoNo = id;
        step = Step.second;
      } else {
        no = line.replace("333", "");
        step = Step.third;
      }
      Category category = new Category();
      category.setCategroyName(no);
      if (step == Step.second) {
        category.setFirstCategoryId(oneNo);
      }
      if (step == Step.third) {
        category.setFirstCategoryId(oneNo);
        category.setSecondCategoryId(twoNo);
      }
      countryAreas.add(category);
      id++;
    }
    countryAreas.forEach(countryArea -> System.out.println("name:" + countryArea.getCategroyName()
        + "   fistId:" + countryArea.getFirstCategoryId() + "  secondId:" + countryArea.getSecondCategoryId()));
    //countryAreaService.insertAreas(countryAreas);
    categoryService.insertCategorys(countryAreas);
  }

  @Test
  //@Rollback(false)
  public void test() {
    //List<Integer> one = new ArrayList();
   // List<Integer> two = new ArrayList();
   // one.stream().
  }


  private enum Step {
    first,
    second,
    third
  }

}