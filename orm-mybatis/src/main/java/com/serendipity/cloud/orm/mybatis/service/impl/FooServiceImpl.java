package com.serendipity.cloud.orm.mybatis.service.impl;

import com.serendipity.cloud.orm.mybatis.mapper.bar.auto.BarMapper;
import com.serendipity.cloud.orm.mybatis.mapper.bar.manual.BarManualMapper;
import com.serendipity.cloud.orm.mybatis.mapper.foo.auto.FooMapper;
import com.serendipity.cloud.orm.mybatis.mapper.foo.manual.FooManualMapper;
import com.serendipity.cloud.orm.mybatis.model.bar.auto.Bar;
import com.serendipity.cloud.orm.mybatis.model.foo.auto.Foo;
import com.serendipity.cloud.orm.mybatis.service.FooService;
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
	private FooMapper fooMapper;
	
	@Resource
	private FooManualMapper fooManualMapper;
	
	@Resource
	private BarMapper barMapper;
	
	@Resource
	private BarManualMapper barManualMapper;

	/**
	 * 新增一个Foo
	 *
	 * @param name
	 * @param age
	 */
	@Override
	public void create(String name, Integer age) {
		Foo foo = new Foo();
		foo.setName(name);
		foo.setAge(age);
		fooMapper.insert(foo);
	}

	/**
	 * 根据name删除一个Foo
	 *
	 * @param name
	 */
	@Override
	public void deleteByName(String name) {
		fooManualMapper.deleteByName(name);
	}

	/**
	 * 根据Id查找一个Foo
	 *
	 * @param id
	 * @return
	 */
	@Override
	public Foo findById(Integer id) {
		return fooMapper.selectByPrimaryKey(id);
	}

	/**
	 * 查找全部Foo
	 *
	 * @return
	 */
	@Override
	public List<Foo> findAllFoos() {
		return fooManualMapper.findAll();
	}

	/**
	 * 获取Foo总量
	 *
	 * @return
	 */
	@Override
	public Integer getAllFoos() {
		return fooManualMapper.getAllCounts();
	}

	/**
	 * 删除所有Foo
	 */
	@Override
	public void deleteAllFoos() {
		fooManualMapper.deleteAll();
	}

	/**
	 * 查找所有Bar
	 *
	 * @return
	 */
	@Override
	public List<Bar> findAllBars() {
		return barManualMapper.findAll();
	}
}
