package au.com.edimoto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import au.com.edimoto.UserBean;





/**
 * Created by edicson on 21/11/16.
 */
@RestController
@EnableAutoConfiguration
@SpringBootApplication
public class Example {
	
	@Autowired
	UserBean userBean;
	
    @RequestMapping("/")
    String home() {
		return "Hello World " + userBean.getName() + " !!!!";
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Example.class, args);
    }

}
