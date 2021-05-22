package com.mt.inventory.exception.entity;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiError {

		private int no;
		
		private String message;
		
		private Date date;

		
		
		
}
