package com.serendipity.cloud.orm.jdbc.service.impl;

import com.serendipity.cloud.model.entity.Bar;
import com.serendipity.cloud.model.entity.Foo;
import com.serendipity.cloud.orm.jdbc.service.FooService;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * FooServiceImpl
 *
 * @author Dongx
 * Description:
 * Created in: 2019-08-07 10:34
 * Modified by:
 */
@Service
public class FooServiceImpl implements FooService {
	
	@Resource
	private JdbcTemplate fooJdbcTemplate;

	@Resource
	private JdbcTemplate barJdbcTemplate;
	
	/**
	 * 新增一个Foo
	 *
	 * @param name
	 * @param age
	 */
	@Override
	public void create(String name, Integer age) {
		fooJdbcTemplate.update("insert into foo(name, age) values(?, ?)", name, age);
	}

	/**
	 * 根据name删除一个Foo
	 *
	 * @param name
	 */
	@Override
	public void deleteByName(String name) {
		fooJdbcTemplate.update("delete from foo where name = ?", name);
	}

	/**
	 * 根据Id查找一个Foo
	 *
	 * @param id
	 * @return
	 */
	@Override
	public Foo findById(Integer id) {
		return fooJdbcTemplate.queryForObject("select * from foo where id = ?", (rs, num) -> {
			Foo foo = new Foo();
			foo.setId(rs.getInt("id"));
			foo.setName(rs.getString("name"));
			foo.setAge(rs.getInt("age"));
			return foo;
		}, id);
		//return jdbcTemplate.queryForObject("select * from foo where id = ?", new BeanPropertyRowMapper<>(Foo.class), id);
	}

	/**
	 * 查找全部Foo
	 *
	 * @return
	 */
	@Override
	public List<Foo> findAllFoos() {
		return fooJdbcTemplate.query("select * from foo", (rs, rowNum) -> {
				Foo foo = new Foo();
				foo.setId(rs.getInt("id"));
				foo.setName(rs.getString("name"));
				foo.setAge(rs.getInt("age"));
				return foo;
		});
	}

	/**
	 * 获取Foo总量
	 *
	 * @return
	 */
	@Override
	public Integer getAllFoos() {
		return fooJdbcTemplate.queryForObject("select count(*) from foo", Integer.class);
	}

	/**
	 * 删除所有Foo
	 */
	@Override
	public void deleteAllFoos() {
		fooJdbcTemplate.update("delete from foo");
	}

	/**
	 * 查找所有Bar
	 *
	 * @return
	 */
	@Override
	public List<Bar> findAllBars() {
		return barJdbcTemplate.query("select * from bar", (rs, rowNum) -> {
			Bar bar = new Bar();
			bar.setId(rs.getInt("id"));
			bar.setName(rs.getString("name"));
			bar.setAge(rs.getInt("age"));
			return bar;
		});
	}
}
