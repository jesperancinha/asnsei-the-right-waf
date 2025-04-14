plugins {
    alias(libs.plugins.kotlin.jvm)
    jacoco
}

group = "org.jesperancinha"
version = "0.0.0"

repositories {
    mavenCentral()
}

dependencies {
    val koin_version = "4.0.4"
    implementation("io.insert-koin:koin-core:$koin_version")
    val gsonVersion = "2.12.1"
    implementation("com.google.code.gson:gson:$gsonVersion")
    testImplementation(platform("org.junit:junit-bom:5.12.2"))
    testImplementation(libs.junit.jupiter)
}

kotlin {
    jvmToolchain(21)
}

tasks.withType<Test> {
    useJUnitPlatform()
}

val gradleSysVersion = System.getenv("GRADLE_VERSION")

tasks.register<Wrapper>("wrapper") {
    gradleVersion = gradleSysVersion
}
