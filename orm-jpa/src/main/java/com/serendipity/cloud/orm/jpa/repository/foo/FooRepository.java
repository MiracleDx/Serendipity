package com.serendipity.cloud.orm.jpa.repository.foo;

import com.serendipity.cloud.model.entity.Foo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * FooRepository
 *
 * @author Dongx
 * Description:
 * Created in: 2019-08-07 18:08
 * Modified by:
 */
public interface FooRepository extends JpaRepository<Foo, Integer> {
	
	void deleteByName(String name);
	
}
