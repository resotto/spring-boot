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


#######################

1. Spring Bootの基本構造
- @SpringBootApplication
- application.properties / application.yml の役割
- 自動構成（auto-configuration）の理解

2. Spring Web (REST API)
- @RestController, @RequestMapping, @GetMapping, @PostMapping など
- パスパラメータ、クエリパラメータ、JSONの受け渡し

3. 依存性注入（DI）
- @Autowired, @Component, @Service, @Repository
- Beanのライフサイクルやスコープ

4. データアクセス
- Spring Data JPA（CrudRepository, JpaRepository）
- エンティティ（@Entity）、リレーション（OneToManyなど）
- H2やPostgreSQLなどとの接続

5. バリデーション
- @Valid, @NotNull, @Size, @RequestBody との組み合わせ

6. 例外処理
- @ControllerAdvice, @ExceptionHandler によるカスタム例外処理

7. 設定とプロファイル
- application-dev.yml / application-prod.yml
- @Profile を使った環境別の設定切り替え

8. セキュリティ（基礎）
- Spring Security（認証・認可の簡易設定）
- @PreAuthorize, Basic認証の導入など

9. ユニットテスト / 統合テスト
- @SpringBootTest
- JUnit / Mockito

10. Other
- Docker化されたSpring Bootアプリ
