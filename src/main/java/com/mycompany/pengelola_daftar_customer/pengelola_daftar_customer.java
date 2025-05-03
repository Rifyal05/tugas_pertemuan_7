/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pengelola_daftar_customer;

/**
 *
 * @author rifial
 */
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
//import java.util.ArrayList;
import java.util.Arrays;
//import java.util.List;
import org.bson.Document;
import org.bson.conversions.Bson;

/**
 *
 * @author rifial
 */
public class pengelola_daftar_customer {

    public static void main(String[] args) {
        String URL = "mongodb+srv://rifyalaidil05:h2B9eZvvafYQTa@cluster0.liq5v3p.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0";
        try (MongoClient mongo = MongoClients.create(URL)) {
            MongoDatabase DB = mongo.getDatabase("data_customer");
            MongoCollection<Document> collection = DB.getCollection("customer");

            // insert data
            Document customer = new Document("id_customer", "CUS-001")
                    .append("name", "Rifyal Aidil")
                    .append("gender", "L")
                    .append("age", "20")
                    .append("email", Arrays.asList("mail001@examples.com", "mail002@gsamples.com"))
                    .append("phone", Arrays.asList("08213456789", "081234567890"))
                    .append("alamat", "Jawa Tengah, Indonesia, Asia, Bumi, Sistem Solar");
            collection.insertOne(customer);
            Document customer2 = new Document("id_customer", "CUS-002")
                    .append("name", "Aidil Rifyal")
                    .append("gender", "L")
                    .append("age", "20")
                    .append("email", Arrays.asList("mail001@examples.com", "mail002@gsamples.com"))
                    .append("phone", Arrays.asList("08213456789", "081234567890"))
                    .append("alamat", "Jawa Tengah, Indonesia, Asia, Bumi, Sistem Solar");
            collection.insertOne(customer2);

            // View data dan tampilin data dalam bentuk Json(all)
            FindIterable<Document> results = collection.find();
            for (Document d : results) {
                System.out.println(d.toJson());
            }

            // View data berdasarkan key
            Document foundCust = collection.find(Filters.eq("id_customer", "CUS-001")).first();
            if (foundCust != null) {
                System.out.println(foundCust.toJson());
            }

            // Search data
            Bson f = Filters.eq("id_customer", "CUS-001");
            FindIterable<Document> search = collection.find(f);
            search = collection.find(f);
            for (Document a : search) {
                System.out.println("Search data : " + a.toJson());
            }

            // View data dengan key
            FindIterable<Document> cust = collection.find();
            for (Document p : cust) {
                System.out.println("Nama Customer : " + p.get("name"));
            }

            // update data
            Bson filter = Filters.eq("id_customer", "CUS-001");
            Bson update = Updates.set("name", "Rifyal Aidil D.H");
            collection.updateOne(filter, update);

            // Delete data
            Bson del = Filters.eq("id_customer", "CUS-002");
            collection.deleteOne(del);


              // INSERT DENGAN LIST
//            List<Document> customerList = new ArrayList<>();
//            customerList.add(customer);
//            customerList.add(customer2);
//            collection.insertMany(customerList);
        }

    }
}
