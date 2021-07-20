package com.stone;

import com.stone.controller.HelloController;
import com.stone.pojo.Person;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
/*
	@RunWith:运行器
		SpringRunner.class: SpringBoot运行环境
		SpringJUnit4ClassRunner:Spring运行环境
		junit:junit测试环境
	@SpringBootTest:标记当前类为SpringBoot测试类
		加载项目的ApplicationContext上下文环境
 */
@RunWith(SpringRunner.class)
@SpringBootTest
class Springbootdemo2ApplicationTests {
	/*
		需求
		调用HelloController里面的方法
	 */

	@Autowired
	private HelloController helloController;

	@Test
	void contextLoads() {
		String result = helloController.hello();
		System.out.println(result);
		String jdbc = helloController.jdbc();
		System.out.println(jdbc);
	}

	/*
		测试 获取配置文件中的信息
	 */
	@Autowired
	private Person person;
	@Test
	void showPersonInfo(){
		System.out.println(person);
	}

}
