package com.jason.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
	@Getter @Setter private int id;
	@Getter @Setter private String name;
	@Getter @Setter private String password;
	@Getter @Setter private int age;
	@Getter @Setter private String description;
	@Getter @Setter private String sex;
}
