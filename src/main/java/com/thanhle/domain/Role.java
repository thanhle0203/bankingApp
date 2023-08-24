package com.thanhle.domain;

import java.util.*;
import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.*;

@JsonIdentityInfo(
		  generator = ObjectIdGenerators.PropertyGenerator.class, 
		  property = "roleId")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Role {
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id
	private Long roleId;
	
	private String roleName;
	
	@ManyToMany(mappedBy="roles", fetch=FetchType.EAGER)
	//@JsonBackReference
	private List<User> users = new ArrayList<>();
}
