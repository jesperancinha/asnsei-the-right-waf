plugins {
    kotlin("jvm") version "1.9.21"
    application
    id("jacoco")
}

group = "org.jesperancinha"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

sourceSets {
    main {
        kotlin {
            srcDir("src/main")
        }
    }
    test {
        kotlin {
            srcDir("src/test")
        }
    }
}

dependencies {
    testImplementation(kotlin("test"))
    testImplementation("org.junit.jupiter:junit-jupiter:5.9.3")
}


tasks.withType<Test> {
    useJUnitPlatform()
    testLogging {
        setExceptionFormat("full")
        events ("started", "skipped", "passed", "failed")
        showStandardStreams = true
    }
}

kotlin {
    jvmToolchain(19)
}


tasks.jacocoTestReport {
    reports {
        xml.required.set(true)
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
