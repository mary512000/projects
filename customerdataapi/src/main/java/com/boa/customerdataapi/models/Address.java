package com.boa.customerdataapi.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.ForeignKey;
import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@Entity
@Table(name="BOA_Customer_Address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(hidden = true)
	@Column(name="Address_Id")
    private long addressId;
	@Column(name="Door_No",nullable = false,length = 5)
	private String doorNo;
	@Column(name="Street_Name",nullable = false,length = 150)
	private String streetName;
	@Column(name="City",nullable = false,length = 50)
	private String city;
	@Column(name="State",nullable = false,length = 50)
	private String state;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(foreignKey = @ForeignKey(name = "Customer_Id"), name = "Customer_Id")
	@JsonIgnore
	private Customer customer;
}
