package com.serendipity.cloud.model.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Foo
 *
 * @author Dongx
 * Description:
 * Created in: 2019-08-07 10:44
 * Modified by:
 */
@Data
@Entity
@Table(name = "foo")
@NoArgsConstructor
public class Foo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String name;
	
	private Integer age;
}
