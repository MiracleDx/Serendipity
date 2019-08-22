package com.serendipity.cloud.orm.jpa.service.impl;

import com.serendipity.cloud.model.entity.Bar;
import com.serendipity.cloud.model.entity.Foo;
import com.serendipity.cloud.orm.jpa.repository.bar.BarRepository;
import com.serendipity.cloud.orm.jpa.repository.foo.FooRepository;
import com.serendipity.cloud.orm.jpa.service.FooService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	private FooRepository fooRepository;
	
	@Resource
	private BarRepository barRepository;

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
		fooRepository.save(foo);
	}

	/**
	 * 根据name删除一个Foo
	 *
	 * @param name
	 */
	@Override
	@Transactional
	public void deleteByName(String name) {
		fooRepository.deleteByName(name);
	}

	/**
	 * 根据Id查找一个Foo
	 *
	 * @param id
	 * @return
	 */
	@Override
	public Foo findById(Integer id) {
		return fooRepository.findById(1).get();
	}

	/**
	 * 查找全部Foo
	 *
	 * @return
	 */
	@Override
	public List<Foo> findAllFoos() {
		return fooRepository.findAll();
	}

	/**
	 * 获取Foo总量
	 *
	 * @return
	 */
	@Override
	public Integer getAllFoos() {
		return Integer.parseInt(Long.toString(fooRepository.count()));
	}

	/**
	 * 删除所有Foo
	 */
	@Override
	@Transactional
	public void deleteAllFoos() {
		fooRepository.deleteAll();
	}

	/**
	 * 查找所有Bar
	 *
	 * @return
	 */
	@Override
	public List<Bar> findAllBars() {
		return barRepository.findAll();
	}
}
