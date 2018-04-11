package com.shuidi.commons.exception;

import org.springframework.boot.web.servlet.error.ErrorController;

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
