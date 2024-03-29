package com.bookstore.entity;
// Generated Dec 20, 2020, 10:04:20 AM by Hibernate Tools 5.1.10.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Payment generated by hbm2java
 */
@Entity
@Table(name = "payment", catalog = "bookstore")
public class Payment implements java.io.Serializable {

	private Integer idPayment;
	private String name;
	private Set<Bill> bills = new HashSet<Bill>(0);
	private Set<Bill> bills_1 = new HashSet<Bill>(0);

	public Payment() {
	}

	public Payment(String name, Set<Bill> bills, Set<Bill> bills_1) {
		this.name = name;
		this.bills = bills;
		this.bills_1 = bills_1;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "idPayment", unique = true, nullable = false)
	public Integer getIdPayment() {
		return this.idPayment;
	}

	public void setIdPayment(Integer idPayment) {
		this.idPayment = idPayment;
	}

	@Column(name = "name")
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "payment")
	public Set<Bill> getBills() {
		return this.bills;
	}

	public void setBills(Set<Bill> bills) {
		this.bills = bills;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "payment")
	public Set<Bill> getBills_1() {
		return this.bills_1;
	}

	public void setBills_1(Set<Bill> bills_1) {
		this.bills_1 = bills_1;
	}

}
