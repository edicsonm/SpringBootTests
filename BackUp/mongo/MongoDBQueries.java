package au.com.edimoto.mongo;

import com.mongodb.*;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Filters.and;

import static java.util.Arrays.asList;

/**
 * Created by edicson on 23/11/16.
 */
public class MongoDBQueries {

    static String host, dbname, user, password;
    private static MongoClient mongoClient;
    private static MongoDatabase db;

    public MongoDBQueries() {
        MongoClientURI connectionString  = new MongoClientURI("mongodb://edicsonm:bigfoot69@ds163377.mlab.com:63377/edicsonm");
        mongoClient = new MongoClient(connectionString);
        db = mongoClient.getDatabase(connectionString.getDatabase());

//        mongoClient = new MongoClient();
//        db = mongoClient.getDatabase("test");

    }

    public void listMongoRecord(){
        FindIterable<Document> iterable = db.getCollection("restaurants").find();
        iterable.forEach(new Block<Document>() {
            @Override
            public void apply(final Document document) {
                System.out.println(document);
            }
        });
    }

    public void listMongoRecord(Document document){
//        FindIterable<Document> iterable = db.getCollection("restaurants").find(document);
        FindIterable<Document> iterable = db.getCollection("restaurants").find(and(eq("cuisine", "Italian"), eq("address.zipcode", "10075")));

        iterable.forEach(new Block<Document>() {
            @Override
            public void apply(final Document document) {
                System.out.println(document);
            }
        });
    }

    public void insertMongoRecord(){

        DateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.ENGLISH);
        try {
            db.getCollection("restaurants").insertOne(
                    new Document("address",
                            new Document()
                                    .append("street", "2 Avenue")
                                    .append("zipcode", "10075")
                                    .append("building", "1480")
                                    .append("coord", asList(-73.9557413, 40.7720266)))
                            .append("borough", "Manhattan")
                            .append("cuisine", "Italian")
                            .append("grades", asList(
                                    new Document()
                                            .append("date", format.parse("2014-10-01T00:00:00Z"))
                                            .append("grade", "A")
                                            .append("score", 11),
                                    new Document()
                                            .append("date", format.parse("2014-01-16T00:00:00Z"))
                                            .append("grade", "B")
                                            .append("score", 17)))
                            .append("name", "Vella")
                            .append("restaurant_id", "41704620"));
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }


}