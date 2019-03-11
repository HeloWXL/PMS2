package com.pms2.yushuting.service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.pms2.yushuting.mapper.AdminMapper;
import com.pms2.yushuting.model.Admin;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author wangxl
 * @date 2019/3/2
 */
@Service
public class AdminService {
   @Resource
    private AdminMapper adminMapper;

    /**
     * 管理员登录检查
     * @param username
     * @return
     */
   public Admin checkAdmin(String username){
       EntityWrapper entityWrapper = new EntityWrapper();
       entityWrapper.eq("admin_username",username);
       List<Admin> admintList = adminMapper.selectList(entityWrapper);
       if (admintList.size() > 0) {
           return admintList.get(0);
       } else {
           return null;
       }
   }


   public int updateAdminPassword(){
      return 1;
   }



}
