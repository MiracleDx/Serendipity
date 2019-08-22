package com.serendipity.cloud.model.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Bar
 *
 * @author Dongx
 * Description:
 * Created in: 2019-08-08 9:50
 * Modified by:
 */
@Data
@Entity
@Table(name = "bar")
@NoArgsConstructor
public class Bar {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String name;

	private Integer age;
}
