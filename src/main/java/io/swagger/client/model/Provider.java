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
import io.swagger.client.model.AccessDescription;


/**
 * Provider
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2016-11-15T09:10:08.564Z")
public class Provider   {
  @SerializedName("id")
  private Long id = null;

  @SerializedName("name")
  private String name = null;

  @SerializedName("location")
  private String location = null;

  @SerializedName("accessDescription")
  private AccessDescription accessDescription = null;

  @SerializedName("supported")
  private Boolean supported = null;

  @SerializedName("type")
  private String type = null;

  public Provider id(Long id) {
    this.id = id;
    return this;
  }

   /**
   * Internal ID of this provider. A constant to identify provider even when,  for examplr, their bank code changes (provided type is BankProvider)
   * @return id
  **/
  @ApiModelProperty(example = "null", required = true, value = "Internal ID of this provider. A constant to identify provider even when,  for examplr, their bank code changes (provided type is BankProvider)")
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Provider name(String name) {
    this.name = name;
    return this;
  }

   /**
   * Name of this provider (e.g., \"Hamburger Bank\")
   * @return name
  **/
  @ApiModelProperty(example = "null", required = true, value = "Name of this provider (e.g., \"Hamburger Bank\")")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Provider location(String location) {
    this.location = location;
    return this;
  }

   /**
   * Location of this provider (e.g., \"Hamburg\")
   * @return location
  **/
  @ApiModelProperty(example = "null", required = true, value = "Location of this provider (e.g., \"Hamburg\")")
  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  public Provider accessDescription(AccessDescription accessDescription) {
    this.accessDescription = accessDescription;
    return this;
  }

   /**
   * Description of the access for the account setup (e.g., UI input fields)
   * @return accessDescription
  **/
  @ApiModelProperty(example = "null", value = "Description of the access for the account setup (e.g., UI input fields)")
  public AccessDescription getAccessDescription() {
    return accessDescription;
  }

  public void setAccessDescription(AccessDescription accessDescription) {
    this.accessDescription = accessDescription;
  }

  public Provider supported(Boolean supported) {
    this.supported = supported;
    return this;
  }

   /**
   * Whether this bank is supported by the AHOI API (i.e., whether you can establish a connection to this provider).
   * @return supported
  **/
  @ApiModelProperty(example = "null", required = true, value = "Whether this bank is supported by the AHOI API (i.e., whether you can establish a connection to this provider).")
  public Boolean getSupported() {
    return supported;
  }

  public void setSupported(Boolean supported) {
    this.supported = supported;
  }

  public Provider type(String type) {
    this.type = type;
    return this;
  }

   /**
   * Discriminator for subtypes. At the moment only `BankProvider` is supported.
   * @return type
  **/
  @ApiModelProperty(example = "null", required = true, value = "Discriminator for subtypes. At the moment only `BankProvider` is supported.")
  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Provider provider = (Provider) o;
    return Objects.equals(this.id, provider.id) &&
        Objects.equals(this.name, provider.name) &&
        Objects.equals(this.location, provider.location) &&
        Objects.equals(this.accessDescription, provider.accessDescription) &&
        Objects.equals(this.supported, provider.supported) &&
        Objects.equals(this.type, provider.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, location, accessDescription, supported, type);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Provider {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    location: ").append(toIndentedString(location)).append("\n");
    sb.append("    accessDescription: ").append(toIndentedString(accessDescription)).append("\n");
    sb.append("    supported: ").append(toIndentedString(supported)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
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
