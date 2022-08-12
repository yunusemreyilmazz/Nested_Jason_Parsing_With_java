# Nested_Json_Parsing_With_java

- This code depends on com.liferay:com.fasterxml.jackson.databind.
- This code is used for parsing complex type of JSON data. You can see in below the type of the JSON data.
- I fetch the data from an api for giving an example.
- API address: https://datausa.io/api/data?drilldowns=Nation&measures=Population.

## MY JSON TYPE
-You can see in below block, my json data type. It is nested and complex. It includes json arrays and objects.

```json
[
    {
        "domains": [
            "marywood.edu"
        ],
        "alpha_two_code": "US",
        "web_pages": [
            "http://www.marywood.edu"
        ],
        "name": "Marywood University",
        "country": "United States",
        "state-province": null
    },
    {
        "domains": [
            "lindenwood.edu"
        ],
        "alpha_two_code": "US",
        "web_pages": [
            "http://www.lindenwood.edu/"
        ],
        "name": "Lindenwood University",
        "country": "United States",
        "state-province": null
    }
 ]


```


## JACKSON LIBRARY USAGE
- This library used by me for this code, and it is realy helpful and efficient. :cowboy_hat_face:
- You don't need to use loops for searching and finding objects with this libary. I am not sure but it is most probably time efficient. :hourglass:
- You can observe the related java code below. It is really short and useful. :collision:
```java
// Creating an instance of ObjectMapper class
ObjectMapper objectMapper = new ObjectMapper();
// Get tree representation of json
JsonNode jsonTree = objectMapper.readTree(inline);

for(int i=0;i<jsonTree.size();i++){
System.out.println(jsonTree.get(i).get("name").asText());
}
```
- I reach the specific object in the api, "name". My code gives the list of all names in the api.
- I hope this will be really helpful for your projects. :flying_disc: :dart:

## PROJECT DEPENDENCY
- You have to set your dependecy of your maven project like in below. This is important for using Jackson library :cold_face:. It does not work without this setting.
```java
<?xml version="1.0" encoding="UTF-8"?>
<project xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd" xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance">
    <modelVersion>4.0.0</modelVersion>
    <groupId>com.liferay</groupId>
    <artifactId>com.fasterxml.jackson.databind</artifactId>
    <version>2.10.5.1.LIFERAY-PATCHED-1</version>
    <licenses>
        <license>
            <name>LGPL 2.1</name>
            <url>http://www.gnu.org/licenses/old-licenses/lgpl-2.1.txt</url>
        </license>
    </licenses>
    <build>
        <plugins>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-compiler-plugin</artifactId>
                <configuration>
                    <source>16</source>
                    <target>16</target>
                </configuration>
            </plugin>
        </plugins>
    </build>
    <dependencies>
        <dependency>
            <groupId>net.minidev</groupId>
            <artifactId>json-smart</artifactId>
            <version>2.4.8</version>
        </dependency>
        <dependency>
            <groupId>com.fasterxml.jackson.core</groupId>
            <artifactId>jackson-databind</artifactId>
            <version>2.13.3</version>
        </dependency>
    </dependencies>
    <developers>
        <developer>
            <name>Brian Wing Shun Chan</name>
            <organization>Liferay, Inc.</organization>
            <organizationUrl>http://www.liferay.com</organizationUrl>
        </developer>
    </developers>
    <scm>
        <connection>scm:git:git@github.com:liferay/liferay-portal.git</connection>
        <developerConnection>scm:git:git@github.com:liferay/liferay-portal.git</developerConnection>
        <url>http://github.com/liferay/liferay-portal</url>
    </scm>
</project>
```
