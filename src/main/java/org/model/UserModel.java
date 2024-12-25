package org.model;

import java.time.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserModel {
	private int User_id;
	private String userName;
	private String passWord;
	private String email;
	private String p_number;
	private String address;	
}
