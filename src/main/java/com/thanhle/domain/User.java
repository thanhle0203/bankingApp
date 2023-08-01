package com.thanhle.domain;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

import lombok.*;

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
	@ManyToMany(fetch=FetchType.EAGER, cascade=CascadeType.PERSIST)
	private List<Role> roles = new ArrayList<>();

}
