package com.frswcb.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Inheritance (strategy = InheritanceType.JOINED)
@Entity
@Table(name = "user_details")
@AllArgsConstructor
@ToString
@NoArgsConstructor
@Getter
@Setter
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	
	@Column(length= 50, nullable = false , unique = true)
	private String userName;
	
	@Column(length = 50, nullable = false)
	private String userPassword;
	
	@Column(length = 50 , nullable = false , unique = true )
	private String email;

	
	@OneToOne
	private Role role;

}
