package au.com.edimoto;

import au.com.edimoto.mongo.MongoDBQueries;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import au.com.edimoto.UserBean;

import static com.mongodb.client.model.Filters.eq;


/**
 * Created by edicson on 21/11/16.
 */
@RestController
@EnableAutoConfiguration
@SpringBootApplication
public class Example {
	
//	@Autowired
//	UserBean userBean;
	
//    @RequestMapping("/")
//    String home() {
//        final MongoDBQueries mongoDBQueries = new MongoDBQueries();
////        mongoDBQueries.listMongoRecord();
//        mongoDBQueries.listMongoRecord(new Document("cuisine", "Italian").append("address.zipcode", "10075"));
//        //mongoDBQueries.listMongoRecord(and(eq("cuisine", "Italian"), eq("address.zipcode", "10075")));
//        return "Hello World " + userBean.getName() + " !!!!";
//    }

//    public static void main(String[] args) throws Exception {
//        SpringApplication.run(Example.class, args);
//    }

}
