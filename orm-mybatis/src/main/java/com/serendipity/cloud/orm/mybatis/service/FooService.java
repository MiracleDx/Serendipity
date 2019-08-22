package com.serendipity.cloud.orm.mybatis.service;


import com.serendipity.cloud.orm.mybatis.model.bar.auto.Bar;
import com.serendipity.cloud.orm.mybatis.model.foo.auto.Foo;

import java.util.List;

/**
 * FooService
 *
 * @author Dongx
 * Description:
 * Created in: 2019-08-07 10:31
 * Modified by:
 */
public interface FooService {

	/**
	 * 新增一个Foo
	 * @param name
	 * @param age
	 */
	void create(String name, Integer age);

	/**
	 * 根据name删除一个Foo
	 * @param name
	 */
	void deleteByName(String name);

	/**
	 * 根据Id查找一个Foo
	 * @param id
	 * @return
	 */
	Foo findById(Integer id);

	/**
	 * 查找全部用户
	 * @return
	 */
	List<Foo> findAllFoos();

	/**
	 * 获取Foo总量
	 * @return
	 */
	Integer getAllFoos();

	/**
	 * 删除所有Foo
	 */
	void deleteAllFoos();

	/**
	 * 查找所有Bar
	 * @return
	 */
	List<Bar> findAllBars();
}
