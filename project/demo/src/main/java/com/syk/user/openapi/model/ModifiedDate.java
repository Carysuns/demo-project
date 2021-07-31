package com.syk.user.openapi.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * ModifiedDate
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-07-31T23:05:28.614729900+08:00[Asia/Shanghai]")

public class ModifiedDate   {
  @JsonProperty("modified_date")
  private OffsetDateTime modifiedDate;

  public ModifiedDate modifiedDate(OffsetDateTime modifiedDate) {
    this.modifiedDate = modifiedDate;
    return this;
  }

  /**
   * 最新更新日期
   * @return modifiedDate
  **/
  @ApiModelProperty(value = "最新更新日期")

  @Valid

  public OffsetDateTime getModifiedDate() {
    return modifiedDate;
  }

  public void setModifiedDate(OffsetDateTime modifiedDate) {
    this.modifiedDate = modifiedDate;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ModifiedDate modifiedDate = (ModifiedDate) o;
    return Objects.equals(this.modifiedDate, modifiedDate.modifiedDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(modifiedDate);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ModifiedDate {\n");
    
    sb.append("    modifiedDate: ").append(toIndentedString(modifiedDate)).append("\n");
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

