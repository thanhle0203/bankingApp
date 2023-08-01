package com.thanhle.domain;

import java.util.*;

import jakarta.persistence.*;
import lombok.*;

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
	
	@ManyToMany(mappedBy="roles")
	private List<User> users = new ArrayList<>();
}
