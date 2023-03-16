package com.pcsgpl.tc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Builder
@Data
@ToString
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name= "office_locations")
//@NamedQuery(name = "OfficeLocationsEntity.lov",query = "Select branch_code from office_locations")
public class OfficeLocationsEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
		
	@Column(name = "branch_code")
	private String branchCode;	
	
	@Column(name = "branch_name")
	private String branchName;
		
}
