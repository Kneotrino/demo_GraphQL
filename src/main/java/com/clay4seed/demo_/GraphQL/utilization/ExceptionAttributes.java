package com.clay4seed.demo_.GraphQL.utilization;

import org.springframework.http.HttpStatus;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author Kneotrino
 * @date 08/11/19
 */
public interface ExceptionAttributes {
  Map<String, Object> getExceptionAttributes(Exception exception, HttpServletRequest httpRequest, HttpStatus httpStatus);
}