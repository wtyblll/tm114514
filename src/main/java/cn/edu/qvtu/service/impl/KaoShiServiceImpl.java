package cn.edu.qvtu.service.impl;

import cn.edu.qvtu.mapper.KaoShiMapper;
import cn.edu.qvtu.pojo.Renshi;
import cn.edu.qvtu.pojo.Teacher;
import cn.edu.qvtu.service.KaoShiService;
import cn.edu.qvtu.util.ApiData;
import org.springframework.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class KaoShiServiceImpl implements KaoShiService {
    @Autowired
    KaoShiMapper kaoShiMapper;

    @Override
    public ApiData login(String acc, String pwd) {
        if(StringUtils.isEmpty(acc)){
            return ApiData.fail("账号必填");
        }
        if(StringUtils.isEmpty(pwd)){
            return ApiData.fail("密码必填");
        }
        //根据工号查询人事表的数据(这里做数据库操作）
        Renshi data = kaoShiMapper.getRenShiByGh(acc);
        if (data==null){
            return ApiData.fail("账号不存在");
        }
        if (!data.getMm().equals(pwd)){
            return ApiData.fail("密码错误");
        }
        UUID uuid = UUID.randomUUID();
        String token = uuid.toString().replaceAll("-","");
        return ApiData.success(token);
    }

    @Override
    public ApiData getTeacherAll() {
        //查询所有教师信息(这里做数据库操作）
        List<Teacher> list = kaoShiMapper.getTeacherAll();
        return ApiData.success(list);
    }

    @Override
    public ApiData getTeacherById(String id) {
        if(StringUtils.isEmpty(id)){
            return ApiData.fail("工号必填");
        }
        //根据工号查询教师信息(这里做数据库操作）
        List<Teacher> data = kaoShiMapper.getTeacherByGh(id);
        if (data==null){
            return ApiData.fail("工号不存在");
        }
        return ApiData.success(data);
    }

    @Override
    public ApiData addTeacher(Teacher teacher) {
        if(teacher==null){
            return ApiData.fail("数据为空");
        }
        if(StringUtils.isEmpty(teacher.getGh())){
            return ApiData.fail("工号必填");
        }
        if(StringUtils.isEmpty(teacher.getXm())){
            return ApiData.fail("姓名必填");
        }
        //添加教师信息(这里做数据库操作）
        int i = kaoShiMapper.addTeacher(teacher);
        if (i>0){
            return ApiData.success(i,"添加成功");
        }
        return ApiData.fail("添加失败");
    }
}
