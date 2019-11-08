package com.clay4seed.demo_.GraphQL.controller;

import com.clay4seed.demo_.GraphQL.utilization.DefaultExceptionAttributes;
import com.clay4seed.demo_.GraphQL.utilization.ExceptionAttributes;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.util.HashSet;
import java.util.Map;

/**
 * @author Kneotrino
 * @date 08/11/19
 */
@Slf4j
@Controller
@RestControllerAdvice
@RequestMapping("/API")
public class BaseController {

  private static final HashSet<String> endpointList;

  static {
    endpointList = new HashSet<>();
    endpointList.add("/graphiql");
  }

  // TODO: 08/11/19 list all endpoint in the project
  @GetMapping(value = "/endpoint")
  public ResponseEntity<HashSet<String>> index() {
    return new ResponseEntity<>(endpointList, HttpStatus.OK);
  }


  @ExceptionHandler(Exception.class)
  public ResponseEntity<Map<String, Object>> handleException(
      Exception exception, HttpServletRequest request) {

    log.error("> handleException");
    log.error("- Exception: ", exception);

    ExceptionAttributes exceptionAttributes = new DefaultExceptionAttributes();

    Map<String, Object> responseBody = exceptionAttributes
        .getExceptionAttributes(exception, request, HttpStatus.INTERNAL_SERVER_ERROR);

    log.error("< handleException");
    return new ResponseEntity<Map<String, Object>>(responseBody, HttpStatus.INTERNAL_SERVER_ERROR);
  }
}
