package com.bookstore.entity;
// Generated Dec 20, 2020, 10:04:20 AM by Hibernate Tools 5.1.10.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Bill generated by hbm2java
 */
@Entity
@Table(name = "bill", catalog = "bookstore")
public class Bill implements java.io.Serializable {

	private Integer idBill;
	private Payment payment;
	private Tinhtrangbill tinhtrangbill;
	private User user;
	private String detail;
	private Integer total;
	private String address;
	private Date date;
	private String name;
	private String phoneNumber;
	private Set<Billcontainsach> billcontainsaches = new HashSet<Billcontainsach>(0);

	public Bill() {
	}

	public Bill(Payment payment, Tinhtrangbill tinhtrangbill, User user, String detail, Integer total, String address,
			Date date, String name, String phoneNumber, Set<Billcontainsach> billcontainsaches) {
		this.payment = payment;
		this.tinhtrangbill = tinhtrangbill;
		this.user = user;
		this.detail = detail;
		this.total = total;
		this.address = address;
		this.date = date;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.billcontainsaches = billcontainsaches;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "idBill", unique = true, nullable = false)
	public Integer getIdBill() {
		return this.idBill;
	}

	public void setIdBill(Integer idBill) {
		this.idBill = idBill;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "payment")
	public Payment getPayment() {
		return this.payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "tinhTrangDonHang")
	public Tinhtrangbill getTinhtrangbill() {
		return this.tinhtrangbill;
	}

	public void setTinhtrangbill(Tinhtrangbill tinhtrangbill) {
		this.tinhtrangbill = tinhtrangbill;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idUserEmail")
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Column(name = "detail")
	public String getDetail() {
		return this.detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	@Column(name = "total")
	public Integer getTotal() {
		return this.total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	@Column(name = "address")
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "date", length = 10)
	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Column(name = "name")
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "phoneNumber")
	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "bill")
	public Set<Billcontainsach> getBillcontainsaches() {
		return this.billcontainsaches;
	}

	public void setBillcontainsaches(Set<Billcontainsach> billcontainsaches) {
		this.billcontainsaches = billcontainsaches;
	}

}
