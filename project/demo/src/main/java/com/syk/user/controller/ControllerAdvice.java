package com.syk.user.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.syk.user.component.exception.ResourceConflictException;
import com.syk.user.component.exception.ResourceNotFoundException;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import jp.co.tpj.backendcomponent.responsemodel.BadRequestInvalidParamsResponseModel;
import jp.co.tpj.backendcomponent.responsemodel.BadRequestResponseModel;
import lombok.extern.slf4j.Slf4j;

import org.apache.shiro.ShiroException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.util.ObjectUtils;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.thymeleaf.util.StringUtils;

/**
 * 统一异常处理类.
 */
@Slf4j
@RestControllerAdvice
public class ControllerAdvice extends ResponseEntityExceptionHandler {

  private static final String ABOUT_BLANK = "about:blank";

  private static final String BAD_REQUEST = "Bad Request";

  /**
   * 接收ResourceNotFoundException时的例外处理.
   *
   * @param ex ResourceNotFoundException
   * @return HTTP Status 404
   */
  @ExceptionHandler(ResourceNotFoundException.class)
  public ResponseEntity<Object> handleResourceNotFound(ResourceNotFoundException ex) {
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
  }

  /**
   * 发生重复错误时的例外处理.
   *
   * @param ex 资源重复例外
   * @return
   */
  @ExceptionHandler(ResourceConflictException.class)
  public ResponseEntity<Object> handleResourceConflict(ResourceConflictException ex) {
    return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
  }

  /**
   * 发生重复错误时的例外处理.
   *
   * @param ex 重复错误
   * @return
   */
  @ExceptionHandler(DuplicateKeyException.class)
  public ResponseEntity<Object> handleDuplicateKeyException(DuplicateKeyException ex) {
    log.error("", ex);
    return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
  }

  /**
   * 发生参照错误时的例外处理.
   */
  @ExceptionHandler(DataIntegrityViolationException.class)
  public ResponseEntity<Object> handleDataIntegrityViolation(DataIntegrityViolationException ex) {
    log.error("", ex);
    return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
  }

  /**
   * 发生验证错误时的例外处理.
   *
   * @param ex 资源重复例外
   * @return
   */
  @ExceptionHandler(InvalidParameterException.class)
  public ResponseEntity<Object> handleInvalidParameter(InvalidParameterException ex) {
    List<BadRequestInvalidParamsResponseModel> errors = new ArrayList<>();
    errors.add(new BadRequestInvalidParamsResponseModel().reason(ex.getLocalizedMessage()));
    return getBadRequestResonseModel(errors);
  }

  /**
   * shiro异常的例外处理.
   *
   * @param ex shiro异常例外
   * @return
   */
  @ExceptionHandler(ShiroException.class)
  public ResponseEntity<Object> handleShiroException(ShiroException ex) {

    log.error("shiro异常", ex);
    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
  }

  /**
   * 接收参数时发生了验证错误时的处理.
   *
   * @param ex      ConstraintViolationException
   * @param request WebRequest
   * @return
   */
  @ExceptionHandler(ConstraintViolationException.class)
  protected ResponseEntity<Object> handleConstraintViolation(
      ConstraintViolationException ex, WebRequest request) {

    if (ObjectUtils.isEmpty(ex.getConstraintViolations()) == false) {
      List<BadRequestInvalidParamsResponseModel> errors = new ArrayList<>();
      for (ConstraintViolation<?> violation : ex.getConstraintViolations()) {
        if (violation.getInvalidValue() != null
            && StringUtils.isEmpty(violation.getInvalidValue().toString()) == false) {
          errors.add(new BadRequestInvalidParamsResponseModel()
              .name(violation.getInvalidValue().toString())
              .reason(violation.getMessage()));
        }
      }

      return getBadRequestResonseModel(errors);
    }

    List<BadRequestInvalidParamsResponseModel> errors = new ArrayList<>();
    errors.add(new BadRequestInvalidParamsResponseModel().reason(ex.getMessage()));
    return getBadRequestResonseModel(errors);
  }

  /**
   * 在RequestBody接收到的Model中存在验证错误时的处理.
   *
   * @param ex      资源重复例外
   * @param headers HttpHeaders
   * @param status  HttpStatus
   * @param request WebRequest
   * @return
   */
  @Override
  public ResponseEntity<Object> handleMethodArgumentNotValid(
      MethodArgumentNotValidException ex,
      HttpHeaders headers,
      HttpStatus status,
      WebRequest request) {

    if (ex.getBindingResult() != null
        && ObjectUtils.isEmpty(ex.getBindingResult().getFieldErrors()) == false) {
      List<BadRequestInvalidParamsResponseModel> errors = new ArrayList<>();
      for (FieldError error : ex.getBindingResult().getFieldErrors()) {
        errors.add(new BadRequestInvalidParamsResponseModel()
            .name(error.getField()).reason(error.getDefaultMessage()));
      }

      return getBadRequestResonseModel(errors);
    }

    List<BadRequestInvalidParamsResponseModel> errors = new ArrayList<>();
    errors.add(new BadRequestInvalidParamsResponseModel().reason(ex.getMessage()));
    return getBadRequestResonseModel(errors);
  }

  /**
   * 发生请求主体的JSON读取错误时的处理.
   *
   * @param ex      HttpMessageNotReadableException
   * @param headers HttpHeaders
   * @param status  HttpStatus
   * @param request WebRequest
   * @return
   */
  @Override
  protected ResponseEntity<Object> handleHttpMessageNotReadable(
      HttpMessageNotReadableException ex,
      HttpHeaders headers,
      HttpStatus status,
      WebRequest request) {

    // 在JSON格式错误是原因的情况下，确认是否有InvalidFormtException异常
    if (ex.getCause() != null) {
      Throwable cause = ex.getCause();
      if (cause instanceof JsonMappingException) {
        JsonMappingException formatException = (JsonMappingException) cause;
        List<BadRequestInvalidParamsResponseModel> errors = new ArrayList<>();
        errors.add(new BadRequestInvalidParamsResponseModel()
            .name(formatException.getLocation().toString())
            .reason(formatException.getOriginalMessage()));

        return getBadRequestResonseModel(errors);
      } else if (cause instanceof JsonProcessingException) {
        JsonProcessingException formatException = (JsonProcessingException) cause;
        List<BadRequestInvalidParamsResponseModel> errors = new ArrayList<>();
        errors.add(new BadRequestInvalidParamsResponseModel()
            .name(formatException.getLocation().toString())
            .reason(formatException.getOriginalMessage()));
        return getBadRequestResonseModel(errors);
      }
    }

    List<BadRequestInvalidParamsResponseModel> errors = new ArrayList<>();
    errors.add(new BadRequestInvalidParamsResponseModel().name(ex.getMessage()));
    return getBadRequestResonseModel(errors);
  }

  /**
   * 在DTO接收参数时发生了验证错误时的处理.
   *
   * @param ex      BindExcpetion
   * @param headers HttpHeaders
   * @param status  HttpStatus
   * @param request WebRequest
   * @return
   */
  @Override
  protected ResponseEntity<Object> handleBindException(
      BindException ex,
      HttpHeaders headers,
      HttpStatus status,
      WebRequest request) {

    if (ex.getBindingResult() != null
        && ObjectUtils.isEmpty(ex.getBindingResult().getFieldErrors()) == false) {
      List<BadRequestInvalidParamsResponseModel> errors = new ArrayList<>();
      for (FieldError error : ex.getBindingResult().getFieldErrors()) {
        errors.add(new BadRequestInvalidParamsResponseModel()
            .name(error.getField()).reason(error.getDefaultMessage()));
      }

      return getBadRequestResonseModel(errors);
    }

    List<BadRequestInvalidParamsResponseModel> errors = new ArrayList<>();
    errors.add(new BadRequestInvalidParamsResponseModel().reason(ex.getMessage()));
    return getBadRequestResonseModel(errors);
  }

  /**
   * 发生参数类型转换错误时的处理.
   *
   * @param ex      BindExcpetion
   * @param headers HttpHeaders
   * @param status  HttpStatus
   * @param request WebRequest
   * @return
   */
  @Override
  protected ResponseEntity<Object> handleTypeMismatch(TypeMismatchException ex,
      HttpHeaders headers, HttpStatus status, WebRequest request) {

    BadRequestInvalidParamsResponseModel error = new BadRequestInvalidParamsResponseModel();
    if (ex.getValue() != null && ex.getValue().toString() != null) {
      error.setName(ex.getValue().toString());
    }

    error.setReason(ex.getLocalizedMessage());
    List<BadRequestInvalidParamsResponseModel> errors = new ArrayList<>();
    errors.add(error);

    return getBadRequestResonseModel(errors);
  }

  private static ResponseEntity<Object> getBadRequestResonseModel(
      List<BadRequestInvalidParamsResponseModel> paramsResponseModels) {
    BadRequestResponseModel result = new BadRequestResponseModel();
    result.setTitle(BAD_REQUEST);
    result.setType(ABOUT_BLANK);
    result.setInvalidParams(paramsResponseModels);
    return ResponseEntity
        .status(HttpStatus.BAD_REQUEST)
        .contentType(MediaType.APPLICATION_PROBLEM_JSON)
        .body(result);
  }
}
