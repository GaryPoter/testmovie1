package com.example.testmovie.service;

import com.example.testmovie.DAO.User;
import com.example.testmovie.mappers.UserMapper;
import com.example.testmovie.utils.PageBean;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceIml implements ItemService {

//    @Autowired
//    private UserMapper userMapper;

    @Autowired
    private UserService userService;

    @Override
    public List<User> findItemByPage(int currentPage, int pageSize) {
        //设置分页信息，分别是当前页数和每页显示的总记录数【记住：必须在mapper接口中的方法执行之前设置该分页信息】
        PageHelper.startPage(currentPage, pageSize);

//        List<User> allUsers = userMapper.serchAll();        //全部商品
        List<User> allUsers = userService.getAll();        //全部商品
        int countNums = allUsers.size();            //总记录数
        PageBean<User> pageData = new PageBean<>(currentPage, pageSize, countNums);
        pageData.setItems(allUsers);
        return pageData.getItems();
    }
}
