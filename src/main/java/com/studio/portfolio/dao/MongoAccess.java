/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.studio.portfolio.dao;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.ServerAddress;
import com.mongodb.DB;

import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;

import org.bson.Document;
import java.util.Arrays;
import com.mongodb.Block;
import com.mongodb.MongoSocketOpenException;

import com.mongodb.client.MongoCursor;
import static com.mongodb.client.model.Filters.*;
import com.mongodb.client.result.DeleteResult;
import static com.mongodb.client.model.Updates.*;
import com.mongodb.client.result.UpdateResult;
import static java.lang.System.console;
import static java.lang.System.out;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * MongoDB DOA implementation...
 */
public class MongoAccess {

    private final static String HOST = "http://142.116.227.65";
    private final static int PORT = 27017;

    public void initConnection() {

        //Define remote DB host
        MongoClientURI connectionString = new MongoClientURI("mongodb://192.168.2.33:27017");

        // Mongo Client init
        MongoClient mongoClient = new MongoClient(connectionString);

        //Instantiate mongodb object "immutable"
        MongoDatabase database = mongoClient.getDatabase("test");

        /*  
         *  Access collection named "restaurants" in the "test" database
         *   Retrieving Json objects which mongo calls them "Documents"
         *   MongoCollection instances are immutable
         */
        MongoCollection<Document> collection = database.getCollection("restaurants");

        /*
         * To create the document using the Java driver, instantiate a Document 
         *  object with a field and value, and use its append() method to 
         *  include additional fields and values to the document object.
         *  The value can be another Document object to specify an embedded
         *  document:
         */
        Document doc = new Document("name", "MongoDB")
                .append("type", "database")
                .append("count", 1)
                .append("versions", Arrays.asList("v3.2", "v3.0", "v2.6"))
                .append("info", new Document("x", 203).append("y", 102));

        out.println(collection.count());
    }

    public static void main(String[] args) {
//        MongoAccess mongo = new MongoAccess();
//        mongo.initConnection();
        try {
            MongoClientURI connectionString = new MongoClientURI("mongodb://localhost:27017");
            MongoClient mongoClient = new MongoClient(connectionString);

            MongoDatabase database = mongoClient.getDatabase("test");
            MongoCollection<Document> collection = database.getCollection("restaurants");

            System.out.println(" ");
            System.out.println("********** Successfully connected to MongoDB ************");
            System.out.println(" ");
            System.out.println(collection.count());

        } catch (MongoSocketOpenException e) {
            System.out.println("*************S jo*********** Exception ***********************");
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }
}
