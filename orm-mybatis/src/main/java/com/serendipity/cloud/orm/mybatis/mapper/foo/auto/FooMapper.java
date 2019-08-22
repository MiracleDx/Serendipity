package com.serendipity.cloud.orm.mybatis.mapper.foo.auto;

import com.serendipity.cloud.orm.mybatis.model.foo.auto.Foo;
import com.serendipity.cloud.orm.mybatis.model.foo.auto.FooExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.session.RowBounds;

public interface FooMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table FOO
     *
     * @mbg.generated Fri Aug 09 14:34:51 CST 2019
     */
    long countByExample(FooExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table FOO
     *
     * @mbg.generated Fri Aug 09 14:34:51 CST 2019
     */
    int deleteByExample(FooExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table FOO
     *
     * @mbg.generated Fri Aug 09 14:34:51 CST 2019
     */
    @Delete({
        "delete from FOO",
        "where ID = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table FOO
     *
     * @mbg.generated Fri Aug 09 14:34:51 CST 2019
     */
    @Insert({
        "insert into FOO (NAME, AGE)",
        "values (#{name,jdbcType=VARCHAR}, #{age,jdbcType=INTEGER})"
    })
    @SelectKey(statement="CALL IDENTITY()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(Foo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table FOO
     *
     * @mbg.generated Fri Aug 09 14:34:51 CST 2019
     */
    int insertSelective(Foo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table FOO
     *
     * @mbg.generated Fri Aug 09 14:34:51 CST 2019
     */
    List<Foo> selectByExampleWithRowbounds(FooExample example, RowBounds rowBounds);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table FOO
     *
     * @mbg.generated Fri Aug 09 14:34:51 CST 2019
     */
    List<Foo> selectByExample(FooExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table FOO
     *
     * @mbg.generated Fri Aug 09 14:34:51 CST 2019
     */
    @Select({
        "select",
        "ID, NAME, AGE",
        "from FOO",
        "where ID = #{id,jdbcType=INTEGER}"
    })
    @ResultMap("com.serendipity.cloud.orm.mybatis.mapper.foo.auto.FooMapper.BaseResultMap")
    Foo selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table FOO
     *
     * @mbg.generated Fri Aug 09 14:34:51 CST 2019
     */
    int updateByExampleSelective(@Param("record") Foo record, @Param("example") FooExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table FOO
     *
     * @mbg.generated Fri Aug 09 14:34:51 CST 2019
     */
    int updateByExample(@Param("record") Foo record, @Param("example") FooExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table FOO
     *
     * @mbg.generated Fri Aug 09 14:34:51 CST 2019
     */
    int updateByPrimaryKeySelective(Foo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table FOO
     *
     * @mbg.generated Fri Aug 09 14:34:51 CST 2019
     */
    @Update({
        "update FOO",
        "set NAME = #{name,jdbcType=VARCHAR},",
          "AGE = #{age,jdbcType=INTEGER}",
        "where ID = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Foo record);
}