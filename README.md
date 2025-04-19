# spring-boot

## TODO
1. [Spring Data JPA](https://docs.spring.io/spring-data/jpa/reference/)
    - makes it easy to easily implement JPA-based (Java Persistence API) repositories
1. [Spring Batch](https://docs.spring.io/spring-batch/reference/index.html)
1. Test code
1. [Spring for Apache Kafka](https://docs.spring.io/spring-kafka/reference/)
1. [Spring Data Redis](https://docs.spring.io/spring-data/redis/reference/)

## procedures
```zh
# java -version # openjdk version "23.0.2"
# brew tap spring-io/tap
# brew install spring-boot
# spring --version # Spring CLI v3.4.4
spring init -f --build=gradle --type=gradle-project --groupId=com.example --artifactId=spring-boot --package-name=com.example.spring-boot --dependencies=web,batch,data-jpa,data-redis,kafka,devtools --java-version=23 --extract .
./gradlew bootRun
# curl "http://localhost:8080"
# curl -X POST "http://localhost:8080/update?entity=bob"
```

build.gradle
```
dependencies
    runtimeOnly 'com.h2database:h2'
```

application.properties
```
spring.application.name=demo
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driver-class-name=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=
spring.jpa.open-in-view=false
spring.batch.job.enabled=false
```