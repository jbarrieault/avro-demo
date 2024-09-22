package com.github.jbarrieault;

import java.io.File;
import java.io.IOException;

import org.apache.avro.file.DataFileReader;
import org.apache.avro.generic.GenericRecord;
import org.apache.avro.generic.GenericDatumReader;
import org.apache.avro.io.DatumReader;

// You can de-serialize avro messages without
// using generated classes, and even without having
// an associated schema file.
//
// This deserializes users stored in the file users.avro,
// using only the schema information in the encoded msessage itself.
// It's not using the generated User class or users.avro schema file!
public class GenericRead {
  public static void main(String[] args) throws IOException {
    File file = new File("users.avro");

    DatumReader<GenericRecord> datumReader = new GenericDatumReader<>();
    DataFileReader<GenericRecord> dataFileReader = new DataFileReader<>(file, datumReader);
    GenericRecord user = null;

    while (dataFileReader.hasNext()) {
      user = dataFileReader.next(user);
      System.out.println(user);
    }

    dataFileReader.close();
  }
}
