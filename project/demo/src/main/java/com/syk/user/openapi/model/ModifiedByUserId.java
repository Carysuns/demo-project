package com.syk.user.openapi.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * ModifiedByUserId
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-07-17T23:49:43.779832900+08:00[Asia/Shanghai]")

public class ModifiedByUserId   {
  @JsonProperty("modified_by_user_id")
  private String modifiedByUserId;

  public ModifiedByUserId modifiedByUserId(String modifiedByUserId) {
    this.modifiedByUserId = modifiedByUserId;
    return this;
  }

  /**
   * 最新更新者
   * @return modifiedByUserId
  **/
  @ApiModelProperty(value = "最新更新者")


  public String getModifiedByUserId() {
    return modifiedByUserId;
  }

  public void setModifiedByUserId(String modifiedByUserId) {
    this.modifiedByUserId = modifiedByUserId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ModifiedByUserId modifiedByUserId = (ModifiedByUserId) o;
    return Objects.equals(this.modifiedByUserId, modifiedByUserId.modifiedByUserId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(modifiedByUserId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ModifiedByUserId {\n");
    
    sb.append("    modifiedByUserId: ").append(toIndentedString(modifiedByUserId)).append("\n");
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

