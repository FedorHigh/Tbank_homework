plugins {
    java
    id("org.springframework.boot") version "3.4.2"
    id("io.spring.dependency-management") version "1.1.7"
}

group = "ru.tbank"
version = "0.0.1-SNAPSHOT"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    compileOnly("org.projectlombok:lombok")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    //implementation("org.liquibase:liquibase-core")
    runtimeOnly("org.postgresql:postgresql")

    //developmentOnly("org.springframework.boot:spring-boot-devtools")
    annotationProcessor("org.projectlombok:lombok")
    //testImplementation("org.springframework.boot:spring-boot-starter-test")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")

    //implementation("javax.persistence:javax.persistence-api:2.2")
    //implementation("org.hibernate:hibernate-core:5.6.5.Final")
    //implementation("org.hibernate.javax.persistence:hibernate-jpa-2.1-api:1.0.2.Final")
    //implementation("mysql:mysql-connector-java:8.0.28")


}


tasks.withType<Test> {
    useJUnitPlatform()
}
