package com.swapnil.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@Data
@NoArgsConstructor
public class Email {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer emailId;
	private String email;
	private String body;
	private LocalDateTime localDateTime;
	private Boolean star=false;
	@OneToOne(cascade = CascadeType.ALL)
	private User fromUser;
	@OneToMany(cascade = CascadeType.ALL)
	private List<User> toUser=new ArrayList<>();
}
