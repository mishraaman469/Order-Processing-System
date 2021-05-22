package com.mt.inventory.entity;

import java.util.Comparator;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Stock implements Comparator<Stock>{

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int id;
		
		private String name;
		
		private int quantitys;
		
		private int price;
		
		private String productType;
		
	
		@Override
		public int compare(Stock o1, Stock o2) {
			int result=o1.price-o2.price;
			if(result==0) {
				return o1.productType.compareTo(o2.productType);
			}
			return result;
		}

		
		
	
		
}
