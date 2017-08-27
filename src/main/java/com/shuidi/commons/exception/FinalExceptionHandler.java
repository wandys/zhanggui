package com.shuidi.commons.exception;

import org.apache.tomcat.util.bcel.Const;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by wandy on 17-8-21.
 */
//@RestController
public class FinalExceptionHandler implements ErrorController {

  /*//@RequestMapping(value = "/error", produces = Const.MIME.JSON)
  public MatrixResponse error(HttpServletResponse resp, HttpServletRequest req) {
    // 错误处理逻辑

    return new MatrixResponse(ErrorCode.INTERNAL_ERROR);
  }*/
  @Override
  public String getErrorPath() {
    return "/error";
  }
}
