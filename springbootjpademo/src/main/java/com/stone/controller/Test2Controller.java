package com.stone.controller;

import com.stone.entity.Test2;
import com.stone.repository.Test2Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("boot")
public class Test2Controller {

    @Autowired
    private Test2Repository test2Repository;

    /**
     * 添加&更细
     * @param test2
     * @return
     */
    @PostMapping(path = "test2",consumes = {MediaType.APPLICATION_JSON_VALUE})
    public Test2 addNewTest2(@RequestBody Test2 test2){
        System.out.println(test2);
        Test2 save = test2Repository.save(test2);
        System.out.println(save);
        return save;
    }

    /**
     * 根据ID删除
     * @param id
     * @return
     */
    @DeleteMapping("/test2/{id}")
    public String deleteById(@PathVariable Long id){
        test2Repository.deleteById(id);
        return "success";
    }

    /**
     * 删除所有
     * @return
     */
    @DeleteMapping("/allTest2")
    public String deleteAllTest2(){
        test2Repository.deleteAll();
        return "Success";
    }

    /**
     * 是否存在
     * @param id
     * @return
     */
    @GetMapping("/existsTest2/{id}")
    public Boolean existsById(@PathVariable Long id){
        boolean b = test2Repository.existsById(id);
        return b;
    }

    /**
     * 通过一连串id查询
     * @param ids
     * @return
     */
    @PostMapping("/test2sId")
    public List<Test2> findAllById(@RequestParam List<Long> ids){
        List<Test2> allById = test2Repository.findAllById(ids);
        return allById;
    }

    /**
     * 分页查询
     * @return
     */
    @GetMapping("/page")
    public Page<Test2> getAllTest2ByPage(){
        Page<Test2> test2s = test2Repository.findAll(PageRequest.of(0, 20, Sort.by(new Sort.Order(Sort.Direction.ASC, "name"))));
        return test2s;
    }

    /**
     * 排序查询所有
     * @return
     */
    @GetMapping("/sort")
    public List<Test2> getAllTest2BySort(){
        List<Test2> test2s = test2Repository.findAll(Sort.by(new Sort.Order(Sort.Direction.ASC, "id")));
        return test2s;
    }

}
