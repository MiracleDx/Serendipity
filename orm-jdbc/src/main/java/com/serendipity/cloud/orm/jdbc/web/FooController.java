package com.serendipity.cloud.orm.jdbc.web;

import com.serendipity.cloud.model.entity.Bar;
import com.serendipity.cloud.model.entity.Foo;
import com.serendipity.cloud.orm.jdbc.service.FooService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * FooController
 *
 * @author Dongx
 * Description:
 * Created in: 2019-08-08 9:44
 * Modified by:
 */
@RestController
public class FooController {
	
	@Resource
	private FooService fooService;

	/**
	 * 新增一个Foo
	 */
	@GetMapping("/create")
	public void create() {
		fooService.create("dongx", 1);
	}

	/**
	 * 根据name删除一个Foo
	 */
	@GetMapping("/delete")
	public void deleteByName() {
		fooService.deleteByName("dongx");
	}

	/**
	 * 根据Id查找一个Foo
	 * @return
	 */
	@GetMapping("/findOne")
	public Foo findById() {
		return fooService.findById(1);
	}

	/**
	 * 查找全部Foo
	 * @return
	 */
	@GetMapping("/findAllFoos")
	public List<Foo> findAllFoos() {
		return fooService.findAllFoos();
	}

	/**
	 * 获取Foo总量
	 * @return
	 */
	@GetMapping("/count")
	public Integer getAllFoos() {
		return fooService.getAllFoos();
	}

	/**
	 * 删除所有Foo
	 */
	@GetMapping("/deleteAll")
	public void deleteAllFoos() {
		fooService.deleteAllFoos();
	}

	/**
	 * 查询所有Bar
	 * @return
	 */
	@GetMapping("/findAllBars")
	public List<Bar> findAllBars() {
		return fooService.findAllBars();
	}
}
