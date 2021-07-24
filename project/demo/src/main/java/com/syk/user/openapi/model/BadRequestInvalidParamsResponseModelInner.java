package com.syk.user.openapi.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * BadRequestInvalidParamsResponseModelInner
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-07-17T23:49:43.779832900+08:00[Asia/Shanghai]")

public class BadRequestInvalidParamsResponseModelInner   {
  @JsonProperty("name")
  private String name;

  @JsonProperty("reason")
  private String reason;

  public BadRequestInvalidParamsResponseModelInner name(String name) {
    this.name = name;
    return this;
  }

  /**
   * 已禁用的项目名称
   * @return name
  **/
  @ApiModelProperty(value = "已禁用的项目名称")


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public BadRequestInvalidParamsResponseModelInner reason(String reason) {
    this.reason = reason;
    return this;
  }

  /**
   * 无效的理由
   * @return reason
  **/
  @ApiModelProperty(value = "无效的理由")


  public String getReason() {
    return reason;
  }

  public void setReason(String reason) {
    this.reason = reason;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BadRequestInvalidParamsResponseModelInner badRequestInvalidParamsResponseModelInner = (BadRequestInvalidParamsResponseModelInner) o;
    return Objects.equals(this.name, badRequestInvalidParamsResponseModelInner.name) &&
        Objects.equals(this.reason, badRequestInvalidParamsResponseModelInner.reason);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, reason);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BadRequestInvalidParamsResponseModelInner {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    reason: ").append(toIndentedString(reason)).append("\n");
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

