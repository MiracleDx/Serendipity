package com.serendipity.cloud.orm.mybatis.mapper.bar.manual;

import com.serendipity.cloud.orm.mybatis.model.bar.auto.Bar;

import java.util.List;

/**
 * BarManualMapper
 *
 * @author Dongx
 * Description:
 * Created in: 2019-08-09 15:42
 * Modified by:
 */
public interface BarManualMapper {
	
	List<Bar> findAll();
}
