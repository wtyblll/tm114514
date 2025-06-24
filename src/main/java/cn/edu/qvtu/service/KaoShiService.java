package cn.edu.qvtu.service;

import cn.edu.qvtu.pojo.Teacher;
import cn.edu.qvtu.util.ApiData;

public interface KaoShiService {
    //提供一个方法，给控制层使用，用来处理业务
//    返回值  方法名(参数列表){
//        //方法体
//        return 返回值;
//    }
    ApiData login(String acc, String pwd);

    ApiData getTeacherAll();

    ApiData getTeacherById(String id);

    ApiData addTeacher(Teacher teacher);

    ApiData updateTeacher(Teacher teacher);

    ApiData deleteTeacherById(String id);
}
