package com.github.jbarrieault;

import java.io.File;
import java.io.IOException;

import org.apache.avro.Schema;
import org.apache.avro.Schema.Parser;
import org.apache.avro.file.DataFileWriter;
import org.apache.avro.generic.GenericData;
import org.apache.avro.generic.GenericDatumWriter;
import org.apache.avro.generic.GenericRecord;
import org.apache.avro.io.DatumWriter;

// You can serialize messages without generated classes.
// This serializes and writes a user to users.avro,
// using only the schema information in the users.avsc file,
// not using the generated User class.
public class GenericWrite {
  public static void main(String[] args) throws IOException {
    Parser parser = new Parser();
    File schemaFile = new File("../avro/user.avsc");
    Schema schema = parser.parse(schemaFile);

    GenericRecord user = new GenericData.Record(schema);
    user.put("first_name", "Jack");
    user.put("last_name", "Nicholson");
    user.put("age", 87);

    File file = new File("users.avro");
    DatumWriter<GenericRecord> datumWriter = new GenericDatumWriter<GenericRecord>(schema);
    DataFileWriter<GenericRecord> dataFileWriter = new DataFileWriter<GenericRecord>(datumWriter);
    dataFileWriter.create(schema, file);
    dataFileWriter.append(user);
    dataFileWriter.close();
  }
}
