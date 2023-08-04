package com.thanhle.domain;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.*;

import jakarta.persistence.*;

import lombok.*;

@JsonIdentityInfo(
		  generator = ObjectIdGenerators.PropertyGenerator.class, 
		  property = "userId")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id
	private Long userId;
	
	private String userName;
	
	private String password;
	
	@JoinTable(name="user_role",
			joinColumns=@JoinColumn(name="user_id"), 
			inverseJoinColumns=@JoinColumn(name="role_id")
			)
	//@ManyToMany(fetch=FetchType.EAGER, cascade=CascadeType.PERSIST)
	@ManyToMany(fetch=FetchType.EAGER, cascade=CascadeType.MERGE)
	//@JsonManagedReference
	private List<Role> roles = new ArrayList<>();

}
