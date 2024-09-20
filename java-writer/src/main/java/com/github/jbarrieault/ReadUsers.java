package com.github.jbarrieault;

import java.io.File;
import java.io.IOException;

import org.apache.avro.file.DataFileReader;
import org.apache.avro.io.DatumReader;
import org.apache.avro.specific.SpecificDatumReader;

import avro.codegen.User;

public class ReadUsers {
  public static void main(String[] args) throws IOException {
    File file = new File("users.avro");
    DatumReader<User> userDatumReader = new SpecificDatumReader<User>(User.class);
    DataFileReader<User> dataFileReader = new DataFileReader<User>(file, userDatumReader);
    User user = null;
    while (dataFileReader.hasNext()) {
      user = dataFileReader.next(user);
      System.out.println(user);
    }
    dataFileReader.close();
  }
}
