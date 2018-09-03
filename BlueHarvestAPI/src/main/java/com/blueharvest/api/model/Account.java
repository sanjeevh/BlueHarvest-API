package com.blueharvest.api.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Account
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-08-29T07:12:25.431Z")

@Entity
public class Account {

	@Id
	@GeneratedValue
	@JsonProperty("accountID")
	private Long accountID = null;

	@JsonProperty("customerID")
	private Long customerID = null;

	@JsonProperty("balance")
	private Float balance = null;

	public Account accountID(Long accountID) {
		this.accountID = accountID;
		return this;
	}

	/**
	 * Get accountID
	 * 
	 * @return accountID
	 **/

	public Long getAccountID() {
		return accountID;
	}

	public void setAccountID(Long accountID) {
		this.accountID = accountID;
	}

	public Account customerID(Long customerID) {
		this.customerID = customerID;
		return this;
	}

	/**
	 * Get customerID
	 * 
	 * @return customerID
	 **/

	public Long getCustomerID() {
		return customerID;
	}

	public void setCustomerID(Long customerID) {
		this.customerID = customerID;
	}

	public Account balance(Float balance) {
		this.balance = balance;
		return this;
	}

	/**
	 * Get balance
	 * 
	 * @return balance
	 **/

	public Float getBalance() {
		return balance;
	}

	public void setBalance(Float balance) {
		this.balance = balance;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Account account = (Account) o;
		return Objects.equals(this.accountID, account.accountID) && Objects.equals(this.customerID, account.customerID)
				&& Objects.equals(this.balance, account.balance);
	}

	@Override
	public int hashCode() {
		return Objects.hash(accountID, customerID, balance);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Account {\n");

		sb.append("    accountID: ").append(toIndentedString(accountID)).append("\n");
		sb.append("    customerID: ").append(toIndentedString(customerID)).append("\n");
		sb.append("    balance: ").append(toIndentedString(balance)).append("\n");
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
