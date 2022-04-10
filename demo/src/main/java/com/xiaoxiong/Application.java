package com.xiaoxiong;

import com.xiaoxiong.component.MyComponent;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author xiongliang
 * @version 1.0
 * @description
 * @since 2022/4/10  10:48
 */
public class Application {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-bean.xml");
		MyComponent bean = applicationContext.getBean(MyComponent.class);
		bean.test();
	}

}
