/*
 * Created by wandy on 2018-05-08.
 */

package com.shuidi.commons.utils;

import java.io.File;
import java.io.FileOutputStream;

/**
 * @author wandy
 * @version 0.0.1
 * @since 0.0.1 2018-05-08
 */
public class FileUtil {

  public static void uploadFile(byte[] file, String filePath, String fileName) throws Exception {
    File targetFile = new File(filePath);
    if(!targetFile.exists()){
      targetFile.mkdirs();
    }
    FileOutputStream out = new FileOutputStream(filePath+fileName);
    out.write(file);
    out.flush();
    out.close();
  }
}