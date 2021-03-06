/**
 * AHOI API
 * AHOI (working title) is our managed and flexible banking API designed to offer easy access to your users bank accounts.  [AHOI cookbook](/ahoi/docs/cookbook/index.html)  [Imprint](https://symbioticon.de/legal-notices/)  [Privacy Disclaimer](https://symbioticon.de/data-protection-guidelines/)  &copy; 2016 Starfinanz - Ein Unternehmen der Finanz Informatik
 *
 * OpenAPI spec version: 2.0.0
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


package io.swagger.client.model;

import java.util.Objects;
import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.client.model.TanMedia;
import java.util.ArrayList;
import java.util.List;


/**
 * TanScheme
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2016-11-15T09:10:08.564Z")
public class TanScheme   {
  /**
   * Name of the used TAN scheme
   */
  public enum NameEnum {
    @SerializedName("SMSTAN")
    SMSTAN("SMSTAN"),
    
    @SerializedName("ITAN")
    ITAN("ITAN"),
    
    @SerializedName("CHIPTAN")
    CHIPTAN("CHIPTAN"),
    
    @SerializedName("PUSHTAN")
    PUSHTAN("PUSHTAN");

    private String value;

    NameEnum(String value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }
  }

  @SerializedName("name")
  private NameEnum name = null;

  @SerializedName("tanMediaList")
  private List<TanMedia> tanMediaList = new ArrayList<TanMedia>();

  public TanScheme name(NameEnum name) {
    this.name = name;
    return this;
  }

   /**
   * Name of the used TAN scheme
   * @return name
  **/
  @ApiModelProperty(example = "null", value = "Name of the used TAN scheme")
  public NameEnum getName() {
    return name;
  }

  public void setName(NameEnum name) {
    this.name = name;
  }

  public TanScheme tanMediaList(List<TanMedia> tanMediaList) {
    this.tanMediaList = tanMediaList;
    return this;
  }

  public TanScheme addTanMediaListItem(TanMedia tanMediaListItem) {
    this.tanMediaList.add(tanMediaListItem);
    return this;
  }

   /**
   * List of available TAN media for this scheme
   * @return tanMediaList
  **/
  @ApiModelProperty(example = "null", value = "List of available TAN media for this scheme")
  public List<TanMedia> getTanMediaList() {
    return tanMediaList;
  }

  public void setTanMediaList(List<TanMedia> tanMediaList) {
    this.tanMediaList = tanMediaList;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TanScheme tanScheme = (TanScheme) o;
    return Objects.equals(this.name, tanScheme.name) &&
        Objects.equals(this.tanMediaList, tanScheme.tanMediaList);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, tanMediaList);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TanScheme {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    tanMediaList: ").append(toIndentedString(tanMediaList)).append("\n");
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

