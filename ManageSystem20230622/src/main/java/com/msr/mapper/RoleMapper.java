package com.msr.mapper;

import com.msr.entity.Role;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author bruce
 * @since 2023-07-17
 */
public interface RoleMapper extends BaseMapper<Role> {
    // 根据用户id,查询对应的角色
    @Select("SELECT\n" +
            "\tr.* \n" +
            "FROM\n" +
            "\trole r\n" +
            "\tJOIN user_role ur ON ur.roleid = r.id \n" +
            "WHERE\n" +
            "\tur.userid =#{userId}")
    public List<Role> listRolesByUserId(Long userId);

}
