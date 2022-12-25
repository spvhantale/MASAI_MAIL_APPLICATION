package com.swapnil.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

	@Id
	private String email;
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer userId;
//	@Pattern(regexp = "[a-zA-Z]", message = "No Special Characters Allowed.")
	private String firstName;
//	@Pattern(regexp = "[a-zA-Z]", message = "No Special Characters Allowed.")
	private String lastName;
	@Size(min=10,max=10 ,message = "mobile number should be 10 digit")
	private String mobileNumber;
//	@Pattern(regexp = "((?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$&*])(?=.*[0-9])).{6,12}$",message="not allowed")
	private String password;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	@Past(message = "date should be past")
	private LocalDate date_of_Birth;
	@JsonIgnore
	@OneToMany
	private List<Email> sentMail=new ArrayList<>();
	@JsonIgnore
	@OneToMany
	private List<Email> reciveMail=new ArrayList<>();
}
