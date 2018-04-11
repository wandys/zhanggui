package com.shuidi.zhanggui.service.bl.impl;

import com.shuidi.zhanggui.service.bl.CountryAreaService;
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
public class CountryAreaServiceImplTest extends ServiceBaseTest {

  @Autowired

  private CountryAreaService countryAreaService;

  @Test
  public void findAreas() throws Exception {

  }

  @Test
  //@Rollback(false)
  public void insert() throws Exception {
    /*File file = new File("/home/wandy/Desktop/ChinaCountry");
    Reader reader = new FileReader(file);
    BufferedReader bufferedReader = new BufferedReader(reader);
    String line = "";
    String shengNo = "";
    String shiNo = "";
    List<CountryArea> countryAreas = new ArrayList<>();
    while (StringUtils.isNotBlank(line = bufferedReader.readLine())) {
      String[] datas = line.split(",");
      String name = datas[1];
      String no = "";
      String pNo = "";
      String pInfos = "";
      if (datas[0].startsWith("sec")) {
        no = datas[0].replace("sec", "");
        shiNo = no;//缓存市编码
        pNo = shengNo;
        pInfos = shengNo;
      } else if (datas[0].startsWith("third")) {
        no = datas[0].replace("third", "");
        pNo = shiNo;
        pInfos = shengNo + "," + shiNo;
      } else {
        no = datas[0];
        shengNo = no;//缓存省编码
        //初始化数据
        shiNo = "";
      }
      CountryArea area = new CountryArea();
      area.setAreaNo(no);
      area.setName(name);
      area.setpNo(pNo);
      area.setpInfos(pInfos);
      countryAreas.add(area);
    }
    countryAreas.forEach(countryArea -> System.out.println("No:" + countryArea.getAreaNo()
        + "   name:" + countryArea.getName() + "  pNO:" + countryArea.getpNo() + "   pInfos:" + countryArea.getpInfos()));
    countryAreaService.insertAreas(countryAreas);*/
  }

}