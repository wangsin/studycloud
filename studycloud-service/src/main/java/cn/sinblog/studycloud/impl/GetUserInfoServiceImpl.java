package cn.sinblog.studycloud.impl;


import cn.sinblog.studycloud.mybatis.entity.MVCMybatisDemoUser;
import cn.sinblog.studycloud.mybatis.mapper.MVCMybatisDemoUserMapper;
import cn.sinblog.studycloud.GetUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.annotation.Resource;



/*
 *
 * @author paida 派哒 zeyu.pzy@alibaba-inc.com
 * @date 2020/10/27
 */

@Service
public class GetUserInfoServiceImpl implements GetUserInfoService {

    @Autowired
    protected MVCMybatisDemoUserMapper mVCMybatisDemoUserMapper;

    @Override
    public void getUserInfoById(String id, Model model) {
        //search by id, get UserInfo
        MVCMybatisDemoUser user = mVCMybatisDemoUserMapper.queryUserInfo(id);
        model.addAttribute("name", user.getId())
                .addAttribute("age", user.getAge())
                .addAttribute("height", user.getHeight())
                .addAttribute("weight", user.getWeight());
    }

    @Override
    public MVCMybatisDemoUser getUserInfoById(String id) {
        //search by id, get UserInfo
        return mVCMybatisDemoUserMapper.queryUserInfo(id);
    }

}
