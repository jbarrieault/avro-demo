# Avro Demo
Trying out Avro, that's it.

## Development

The Java project was built with Maven, using the quickstart archetype:

`mvn archetype:generate -DgroupId=com.github.jbarrieault -DartifactId=avro-demo -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false`

The pom.xml file was then updated to add Avro as a dependency, and to add the `avro-maven-plugin` code gen plugin.

Remember to cd into the Java project's root:
`cd java-writer`

To re-generate the avro classes:

`mvn generate-sources`

Or simply re-compile everything:
`mvn compile`

Execute the java program writes serialized users to a file:

`mvn -q exec:java -Dexec.mainClass="com.github.jbarrieault.App"`

Then the program that de-serializes them:
`mvn -q exec:java -Dexec.mainClass="com.github.jbarrieault.ReaderApp"`
