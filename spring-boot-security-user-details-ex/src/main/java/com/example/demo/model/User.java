package com.example.demo.model;

import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue
	@Column(name = "user_id")
	private Integer id;

	@Column(name = "user_name")
	private String name;

	@Column(name = "user_passwd")
	private String password;

	@Column(name = "user_email")
	private String email;

	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "roles", joinColumns = @JoinColumn(name = "user_id"))
	@Column(name = "user_role")
	private List<String> roles;

}