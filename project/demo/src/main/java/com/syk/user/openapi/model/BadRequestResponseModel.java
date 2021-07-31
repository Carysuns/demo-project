package com.syk.user.openapi.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.syk.user.openapi.model.BadRequestInvalidParamsResponseModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * HTTP Status 400 Bad Request
 */
@ApiModel(description = "HTTP Status 400 Bad Request")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-07-31T23:05:28.614729900+08:00[Asia/Shanghai]")

public class BadRequestResponseModel   {
  @JsonProperty("type")
  private String type;

  @JsonProperty("title")
  private String title;

  @JsonProperty("invalid-params")
  @Valid
  private List<BadRequestInvalidParamsResponseModel> invalidParams = null;

  public BadRequestResponseModel type(String type) {
    this.type = type;
    return this;
  }

  /**
   * 识别问题类型的URI引用
   * @return type
  **/
  @ApiModelProperty(value = "识别问题类型的URI引用")


  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public BadRequestResponseModel title(String title) {
    this.title = title;
    return this;
  }

  /**
   * 问题类型的概要
   * @return title
  **/
  @ApiModelProperty(value = "问题类型的概要")


  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public BadRequestResponseModel invalidParams(List<BadRequestInvalidParamsResponseModel> invalidParams) {
    this.invalidParams = invalidParams;
    return this;
  }

  public BadRequestResponseModel addInvalidParamsItem(BadRequestInvalidParamsResponseModel invalidParamsItem) {
    if (this.invalidParams == null) {
      this.invalidParams = new ArrayList<>();
    }
    this.invalidParams.add(invalidParamsItem);
    return this;
  }

  /**
   * Get invalidParams
   * @return invalidParams
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<BadRequestInvalidParamsResponseModel> getInvalidParams() {
    return invalidParams;
  }

  public void setInvalidParams(List<BadRequestInvalidParamsResponseModel> invalidParams) {
    this.invalidParams = invalidParams;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BadRequestResponseModel badRequestResponseModel = (BadRequestResponseModel) o;
    return Objects.equals(this.type, badRequestResponseModel.type) &&
        Objects.equals(this.title, badRequestResponseModel.title) &&
        Objects.equals(this.invalidParams, badRequestResponseModel.invalidParams);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, title, invalidParams);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BadRequestResponseModel {\n");
    
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    invalidParams: ").append(toIndentedString(invalidParams)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

