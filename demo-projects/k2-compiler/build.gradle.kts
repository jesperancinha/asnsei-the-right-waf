plugins {
    kotlin("jvm") version "1.9.21"
    application
    id("jacoco")
}

group = "org.example"
version = "unspecified"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}
//
//sourceSets {
//    main {
//        kotlin {
//            srcDir("src/main")
//        }
//    }
//    test {
//        kotlin {
//            srcDir("src/test")
//        }
//    }
//}

tasks.test {
    useJUnitPlatform()
}
kotlin { sourceSets.all { languageSettings { languageVersion = "2.0" } } }
