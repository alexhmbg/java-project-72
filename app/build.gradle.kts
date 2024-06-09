plugins {
    id("java")
    id("application")
    id("com.github.johnrengelman.shadow") version "8.1.1";
}

group = "hexlet.code"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

application {
    mainClass = "hexlet.code.App"
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation("com.h2database:h2:2.2.224")

    implementation("gg.jte:jte:3.1.12")
    implementation("org.slf4j:slf4j-simple:2.0.13")
    implementation("io.javalin:javalin:6.1.6")
    implementation("io.javalin:javalin-bundle:6.1.3")
    implementation("io.javalin:javalin-rendering:6.1.3")
    implementation("com.zaxxer:HikariCP:5.1.0")

}

tasks.test {
    useJUnitPlatform()
}