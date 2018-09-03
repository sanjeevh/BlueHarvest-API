package com.blueharvest.api.model;


import java.util.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Transaction
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-08-29T07:12:25.431Z")

@Entity

public class Transaction {

	@Id
	@GeneratedValue
	@JsonProperty("transactionID")
	private Long transactionID = null;

	@JsonProperty("accountID")
	private Long accountID = null;

	@JsonProperty("amount")
	private Float amount = null;
	
	@JsonProperty("customerID")
	private Long customerID = null;
	
	@JsonProperty("transactionDate")
	private Date transactionDate = null;

	public Long getCustomerID() {
		return customerID;
	}

	public void setCustomerID(Long customerID) {
		this.customerID = customerID;
	}

	/**
	 * Gets or Sets transactionType
	 */
	public enum TransactionTypeEnum {
		DEBIT("debit"),

		CREDIT("credit");

		private String value;

		TransactionTypeEnum(String value) {
			this.value = value;
		}

		@Override
		@JsonValue
		public String toString() {
			return String.valueOf(value);
		}

		@JsonCreator
		public static TransactionTypeEnum fromValue(String text) {
			for (TransactionTypeEnum b : TransactionTypeEnum.values()) {
				if (String.valueOf(b.value).equals(text)) {
					return b;
				}
			}
			return null;
		}
	}

	@JsonProperty("transactionType")
	private TransactionTypeEnum transactionType = null;

	public Transaction transactionID(Long transactionID) {
		this.transactionID = transactionID;
		return this;
	}

	/**
	 * Get transactionID
	 * 
	 * @return transactionID
	 **/

	public Long getTransactionID() {
		return transactionID;
	}

	public void setTransactionID(Long transactionID) {
		this.transactionID = transactionID;
	}

	public Transaction accountID(Long accountID) {
		this.accountID = accountID;
		return this;
	}

	/**
	 * Get accountID
	 * 
	 * @return accountID
	 **/

	@NotNull

	public Long getAccountID() {
		return accountID;
	}

	public void setAccountID(Long accountID) {
		this.accountID = accountID;
	}

	public Transaction amount(Float amount) {
		this.amount = amount;
		return this;
	}

	/**
	 * Get amount
	 * 
	 * @return amount
	 **/
	@NotNull

	public Float getAmount() {
		return amount;
	}

	public void setAmount(Float amount) {
		this.amount = amount;
	}

	public Transaction transactionType(TransactionTypeEnum transactionType) {
		this.transactionType = transactionType;
		return this;
	}

	/**
	 * Get transactionType
	 * 
	 * @return transactionType
	 **/
	@NotNull

	public TransactionTypeEnum getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(TransactionTypeEnum transactionType) {
		this.transactionType = transactionType;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
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
		return Objects.equals(this.transactionID, transaction.transactionID)
				&& Objects.equals(this.accountID, transaction.accountID)
				&& Objects.equals(this.amount, transaction.amount)
				&& Objects.equals(this.transactionType, transaction.transactionType)
				&& Objects.equals(this.customerID, transaction.customerID);
	}

	@Override
	public int hashCode() {
		return Objects.hash(transactionID, accountID, amount, transactionType, customerID);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Transaction {\n");

		sb.append("    transactionID: ").append(toIndentedString(transactionID)).append("\n");
		sb.append("    accountID: ").append(toIndentedString(accountID)).append("\n");
		sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
		sb.append("    transactionType: ").append(toIndentedString(transactionType)).append("\n");
		sb.append("    customerID: ").append(toIndentedString(customerID)).append("\n");
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
