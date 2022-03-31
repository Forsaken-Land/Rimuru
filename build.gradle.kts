import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.6.10"
}

allprojects{

    val projectVersion: String by project
    group = "top.limbang.rimuru"
    version = projectVersion

    repositories {
        mavenLocal()
        maven("https://maven.aliyun.com/repository/public")
        mavenCentral()
    }
}

subprojects {

    apply{
        plugin("org.jetbrains.kotlin.jvm")
    }

    dependencies {
        implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.3.2")
        implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.0")
        implementation("org.slf4j:slf4j-api:1.7.36")
        testImplementation(kotlin("test"))
        testImplementation("ch.qos.logback:logback-classic:1.2.11")
    }
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile>() {
    kotlinOptions.jvmTarget = "1.8"
}