package com.blueharvest.api.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Customer
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-08-29T07:12:25.431Z")

@Entity
public class Customer {

	@Id
	@GeneratedValue

	@JsonProperty("customerID")
	private Long customerID = null;

	@JsonProperty("firstName")
	private String firstName = null;

	@JsonProperty("lastName")
	private String lastName = null;

	@OneToMany(
	        cascade = CascadeType.ALL, 
	        orphanRemoval = true
	    )	
	@JoinColumn(name = "customerid")
	@JsonProperty("accounts")
	@Valid
	private List<Account> accounts = new ArrayList<>();

	@OneToMany(
	        cascade = CascadeType.ALL, 
	        orphanRemoval = true
	    )	
	@JoinColumn(name = "customerid")
	@JsonProperty("transactions")
	@Valid
	private List<Transaction> transactions = new ArrayList<>();

	public Customer customerID(Long customerID) {
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

	public Customer firstName(String firstName) {
		this.firstName = firstName;
		return this;
	}

	/**
	 * Get firstName
	 * 
	 * @return firstName
	 **/

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public Customer lastName(String lastName) {
		this.lastName = lastName;
		return this;
	}

	/**
	 * Get lastName
	 * 
	 * @return lastName
	 **/

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Customer accounts(List<Account> accounts) {
		this.accounts = accounts;
		return this;
	}

	public Customer addAccountsItem(Account accountsItem) {
		if (this.accounts == null) {
			this.accounts = new ArrayList<Account>();
		}
		this.accounts.add(accountsItem);
		return this;
	}

	/**
	 * Get accounts
	 * 
	 * @return accounts
	 **/

	@Valid

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

	public Customer transactions(List<Transaction> transactions) {
		this.transactions = transactions;
		return this;
	}

	public Customer addTransactionsItem(Transaction transactionsItem) {
		if (this.transactions == null) {
			this.transactions = new ArrayList<Transaction>();
		}
		this.transactions.add(transactionsItem);
		return this;
	}

	/**
	 * Get transactions
	 * 
	 * @return transactions
	 **/

	@Valid

	public List<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Customer customer = (Customer) o;
		return Objects.equals(this.customerID, customer.customerID)
				&& Objects.equals(this.firstName, customer.firstName)
				&& Objects.equals(this.lastName, customer.lastName) && Objects.equals(this.accounts, customer.accounts)
				&& Objects.equals(this.transactions, customer.transactions);
	}

	@Override
	public int hashCode() {
		return Objects.hash(customerID, firstName, lastName, accounts, transactions);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Customer {\n");

		sb.append("    customerID: ").append(toIndentedString(customerID)).append("\n");
		sb.append("    firstName: ").append(toIndentedString(firstName)).append("\n");
		sb.append("    lastName: ").append(toIndentedString(lastName)).append("\n");
		sb.append("    accounts: ").append(toIndentedString(accounts)).append("\n");
		sb.append("    transactions: ").append(toIndentedString(transactions)).append("\n");
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
