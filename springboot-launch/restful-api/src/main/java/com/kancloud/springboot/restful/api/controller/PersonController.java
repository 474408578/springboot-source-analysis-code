package com.kancloud.springboot.restful.api.controller;

import com.kancloud.springboot.launch.core.utils.JacksonUtil;
import com.kancloud.springboot.launch.core.utils.result.Result;
import com.kancloud.springboot.launch.core.utils.result.ResultUtil;
import com.kancloud.springboot.restful.api.model.Person;
import com.kancloud.springboot.restful.api.model.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xschen
 * @date 2021/11/12 14:57
 */

@RestController
@Slf4j
public class PersonController {


    @GetMapping("/person")
    public Result<Person> getPerson() {
        Student student = new Student();
        student.setName("song");
        student.setAge("23");
        student.setNumber(1985);
        String s = JacksonUtil.obj2Json(student);
        System.out.println(s);
        Person person = new Person();
        person = student;
        return ResultUtil.success(person);
    }
}
