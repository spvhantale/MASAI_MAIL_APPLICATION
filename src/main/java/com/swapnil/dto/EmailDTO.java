package com.swapnil.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmailDTO {

	private String email;
	private String body;
	private List<String> sendTo=new ArrayList<>();
	
	
}
