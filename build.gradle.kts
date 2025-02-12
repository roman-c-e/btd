plugins {
    kotlin("jvm") version "2.1.0"
}

group = "com.zivue"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}
dependencies {
    testImplementation(kotlin("test"))
    implementation("org.mockito:mockito-core:5.15.2")

}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(23)
}

tasks.jar.configure {
    manifest {
        attributes(mapOf("Main-Class" to "com.zivue.MainKt"))
    }
    configurations["compileClasspath"].forEach { file: File ->
        from(zipTree(file.absoluteFile))
    }
    duplicatesStrategy = DuplicatesStrategy.INCLUDE
}