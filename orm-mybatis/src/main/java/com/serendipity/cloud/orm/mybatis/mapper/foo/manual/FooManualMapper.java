package com.serendipity.cloud.orm.mybatis.mapper.foo.manual;

import com.serendipity.cloud.orm.mybatis.model.foo.auto.Foo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * FooManualMapper
 *
 * @author Dongx
 * Description:
 * Created in: 2019-08-09 15:35
 * Modified by:
 */
public interface FooManualMapper {
	
	@Delete("delete from foo where name = #{name}")
	int deleteByName(String name);
	
	@Select("select * from foo")
	List<Foo> findAll();
	
	@Select("select count(*) from foo")
	int getAllCounts();
	
	@Delete("delete from foo")
	int deleteAll();
}
