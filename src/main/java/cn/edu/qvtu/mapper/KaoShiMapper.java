package cn.edu.qvtu.mapper;

import cn.edu.qvtu.pojo.Renshi;
import cn.edu.qvtu.pojo.Teacher;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface KaoShiMapper {
    //提供一个方法，给业务逻辑层使用，操作数据库
    //    返回值  方法名(参数列表){
//        //方法体
//        return 返回值;
//    }
    Renshi getRenShiByGh(String gh);
    List<Teacher> getTeacherAll();
    List<Teacher> getTeacherByGh(String gh);

    int addTeacher(Teacher teacher);
}
