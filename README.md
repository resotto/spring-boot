# spring-boot

## TODO
1. Spring Data JPA
    - makes it easy to easily implement JPA-based (Java Persistence API) repositories
1. Spring Batch
1. Test code
1. Spring for Apache Kafka ?
1. Spring Data Redis ?

## procedures
```zh
# java -version # openjdk version "23.0.2"
# brew tap spring-io/tap
# brew install spring-boot
# spring --version # Spring CLI v3.4.4
spring init -f --build=gradle --type=gradle-project --groupId=com.example --artifactId=spring-boot --package-name=com.example.spring-boot --java-version=23 --extract .
# add `developmentOnly 'org.springframework.boot:spring-boot-devtools'` to build.gradle > dependencies
# gradle --version # Gradle 8.12.1
gradle wrapper
./gradlew bootRun
# curl "http://localhost:8080"
# curl -X POST "http://localhost:8080/update?entity=bob"
```