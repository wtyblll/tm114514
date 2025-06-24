package cn.edu.qvtu.api;

import cn.edu.qvtu.pojo.Teacher;
import cn.edu.qvtu.service.KaoShiService;
import cn.edu.qvtu.util.ApiData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class KaoShiApi {
    @Autowired
    KaoShiService kaoShiService;

//    访问修饰符  返回值  方法名(参数列表){
//        //方法体
//        return 返回值;
//    }
    //一个API接口，就写一个映射方法
    @GetMapping("/api/login")
    @ResponseBody
    public ApiData login(String acc, String pwd){
        //编写业务逻辑
        return kaoShiService.login(acc,pwd);
    }

    //查询全部教师API
    @GetMapping("/api/teacher/list")
    @ResponseBody
    public ApiData getAll(){
        //编写业务逻辑
        return kaoShiService.getTeacherAll();
    }
    //根据工号查询教师API
    @GetMapping("/api/teacher/info/{gh}")
    @ResponseBody
    public ApiData getTeacherByGh(@PathVariable String gh){
        //编写业务逻辑
        return kaoShiService.getTeacherById(gh);
    }

    //添加教师API
    @PostMapping("/api/teacher/add")
    @ResponseBody
    public ApiData add(@RequestBody Teacher data){
        //编写业务逻辑
        return kaoShiService.addTeacher(data);
    }
}
