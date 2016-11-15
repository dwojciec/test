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


/**
 * Transaction
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2016-11-15T09:10:08.564Z")
public class Transaction   {
  @SerializedName("transactionPatternId")
  private Long transactionPatternId = null;

  @SerializedName("id")
  private Long id = null;

  @SerializedName("type")
  private String type = null;

  public Transaction transactionPatternId(Long transactionPatternId) {
    this.transactionPatternId = transactionPatternId;
    return this;
  }

   /**
   * Identifier of the transactionPattern to which this transaction belongs
   * @return transactionPatternId
  **/
  @ApiModelProperty(example = "null", value = "Identifier of the transactionPattern to which this transaction belongs")
  public Long getTransactionPatternId() {
    return transactionPatternId;
  }

  public void setTransactionPatternId(Long transactionPatternId) {
    this.transactionPatternId = transactionPatternId;
  }

  public Transaction id(Long id) {
    this.id = id;
    return this;
  }

   /**
   * Internal ID of this transaction (generated value)
   * @return id
  **/
  @ApiModelProperty(example = "null", required = true, value = "Internal ID of this transaction (generated value)")
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Transaction type(String type) {
    this.type = type;
    return this;
  }

   /**
   * Discriminator for subtypes. At the moment only `GiroTransaction` is supported.
   * @return type
  **/
  @ApiModelProperty(example = "null", required = true, value = "Discriminator for subtypes. At the moment only `GiroTransaction` is supported.")
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
    Transaction transaction = (Transaction) o;
    return Objects.equals(this.transactionPatternId, transaction.transactionPatternId) &&
        Objects.equals(this.id, transaction.id) &&
        Objects.equals(this.type, transaction.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(transactionPatternId, id, type);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Transaction {\n");
    
    sb.append("    transactionPatternId: ").append(toIndentedString(transactionPatternId)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
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
