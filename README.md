# Avro Demo
Trying out Avro, that's it.

## Development

The Java project was built with Maven, using the quickstart archetype:

`mvn archetype:generate -DgroupId=com.github.jbarrieault -DartifactId=avro-demo -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false`

The pom.xml file was then updated to add Avro as a dependency, and to add the `avro-maven-plugin` code gen plugin.

Remember to cd into the Java project's root:
`cd java/avro-demo`

To generate the avro classes:

`mvn generate-sources`

Execute the java program:

`mvn exec:java -Dexec.mainClass="com.github.jbarrieault.App"`
