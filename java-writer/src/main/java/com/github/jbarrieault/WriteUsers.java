package com.github.jbarrieault;

import avro.codegen.User;
import org.apache.avro.io.DatumWriter;
import org.apache.avro.specific.SpecificDatumWriter;
import org.apache.avro.file.DataFileWriter;
import java.io.File;
import java.io.IOException;

// Serializes and writes users to users.avro,
// using the User class, which was generated using user.avsc schema.
public class WriteUsers {
    public static void main(String[] args) throws IOException {
        System.out.println("Hello World!");

        User user = new User();
        user.setFirstName("Jack");
        user.setLastName("White");
        user.setAge(49);

        User user2 = new User("Meg", "White", 49);

        DatumWriter<User> userDatumWriter = new SpecificDatumWriter<User>(User.class);
        DataFileWriter<User> dataFileWriter = new DataFileWriter<User>(userDatumWriter);
        File file = new File("users.avro");
        dataFileWriter.create(user.getSchema(), file);
        dataFileWriter.append(user);
        dataFileWriter.append(user2);
        dataFileWriter.close();

        System.out.println("Users serialized and written to user.avro");
    }
}
