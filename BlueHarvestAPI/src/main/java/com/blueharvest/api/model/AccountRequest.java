package com.blueharvest.api.model;

import java.util.Objects;

import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * AccountRequest
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-08-29T07:12:25.431Z")

public class AccountRequest   {
  @JsonProperty("customerID")
  private Long customerID = null;

  @JsonProperty("initialCredit")
  private Float initialCredit = null;

  public AccountRequest customerID(Long customerID) {
    this.customerID = customerID;
    return this;
  }

  /**
   * Get customerID
   * @return customerID
  **/
 
  @NotNull


  public Long getCustomerID() {
    return customerID;
  }

  public void setCustomerID(Long customerID) {
    this.customerID = customerID;
  }

  public AccountRequest initialCredit(Float initialCredit) {
    this.initialCredit = initialCredit;
    return this;
  }

  /**
   * Get initialCredit
   * @return initialCredit
  **/
 
 


  public Float getInitialCredit() {
    return initialCredit;
  }

  public void setInitialCredit(Float initialCredit) {
    this.initialCredit = initialCredit;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AccountRequest accountRequest = (AccountRequest) o;
    return Objects.equals(this.customerID, accountRequest.customerID) &&
        Objects.equals(this.initialCredit, accountRequest.initialCredit);
  }

  @Override
  public int hashCode() {
    return Objects.hash(customerID, initialCredit);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AccountRequest {\n");
    
    sb.append("    customerID: ").append(toIndentedString(customerID)).append("\n");
    sb.append("    initialCredit: ").append(toIndentedString(initialCredit)).append("\n");
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

