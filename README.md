# Avro Demo
Trying out Avro, that's it.

## Notes
The Java directory is a Maven project. The `pom.xml` file uses `avro-maven-plugin`, which automatically generates Avro classes on compile.

The project contains a few individually executable classes to demonstrate basic Avro usage:
- `WriteUsers` serializes users into `users.avro` using the Avro-generated User class.
- `GenericWrite` serializes users into `users.avro` using the `user.avsc` schema fiile.
- `ReadUsers` de-serializes users from `users.avro` using the Avro-generated User class.
- `GenericRead` de-serializes users from `users.avro` using the `user.avsc` schema fiile.

They read & write programs are cross-compatible! You can write using the schema file, and read using the generated User class.
```shell
cd java
mvn compile

# write using the schema file
mvn -q exec:java -Dexec.mainClass="com.github.jbarrieault.GenericWrite"
# read using the generated User class
mvn -q exec:java -Dexec.mainClass="com.github.jbarrieault.ReadUsers"
```
