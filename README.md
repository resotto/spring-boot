# spring-boot

## TODO
1. [Spring Batch](https://docs.spring.io/spring-batch/reference/index.html)

## procedures
```zh
# java -version # openjdk version "23.0.2"
# brew tap spring-io/tap
# brew install spring-boot
# spring --version # Spring CLI v3.4.4
spring init -f --build=gradle --type=gradle-project --groupId=com.example --artifactId=spring-boot --package-name=com.example.spring-boot --dependencies=web,validation,test,lombok,batch,data-jpa,data-redis,kafka,devtools --java-version=23 --extract .

./gradlew bootRun --args='--spring.profiles.active=prod'

# curl -X POST http://localhost:8080/users \
     -H "Content-Type: application/json" \
     -d '{"age": 24, "name": "john"}'
# curl -i "http://localhost:8080/users/john"
# curl -i "http://localhost:8080/users?name=john"

# curl -X POST "http://localhost:8080/payments/charges/abc"

./gradlew test
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

## CockRoachDB
```sh
docker run --name cockroachdb -p 26257:26257 -p 8888:8080 -d cockroachdb/cockroach start-single-node --insecure

./gradlew bootRun --args='--spring.profiles.active=dev'

open http://localhost:8888

curl -X POST http://localhost:8080/users/db \
  -H "Content-Type: application/json" \
  -d '{"id": "abc", "age": 25, "name": "Alice"}'

curl http://localhost:8080/users/db/abc

curl -X POST http://localhost:8080/orders \
  -H "Content-Type: application/json" \
  -d '{"amount": 2000, "user": {"id": "abc"}}'

curl http://localhost:8080/orders/153
```

# VSCode Memo
- `Java: Clean Java Language Server Workspace`