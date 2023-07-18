package com.msr.mapper;

import com.msr.entity.Menu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author bruce
 * @since 2023-07-18
 */
public interface MenuMapper extends BaseMapper<Menu> {
    //根据登录的用户id，查询对应的菜单列表信息
    public List<Menu> findAll(Long userid);

}
