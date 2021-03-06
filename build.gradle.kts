
import org.gradle.api.tasks.wrapper.Wrapper
import org.gradle.script.lang.kotlin.allprojects
import org.gradle.script.lang.kotlin.apply
import org.gradle.script.lang.kotlin.compile
import org.gradle.script.lang.kotlin.dependencies
import org.gradle.script.lang.kotlin.maven
import org.gradle.script.lang.kotlin.repositories
import org.gradle.script.lang.kotlin.subprojects
import org.gradle.script.lang.kotlin.task
import org.gradle.script.lang.kotlin.testCompile

buildscript {
    repositories {
        jcenter()
    }

    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.1.0")
    }
}

allprojects {
    group = "by.bkug.akka"
    version = "0.1.0-SNAPSHOT"
}

subprojects {
    apply {
        plugin("kotlin")
    }

    repositories {
        jcenter()
    }

    dependencies {
        compileOnly("org.jetbrains.kotlin:kotlin-stdlib:1.1.0")

        compile("com.typesafe.akka:akka-actor_2.12:2.5-M2")

        testCompile("junit:junit:4.12")
    }
}

task(name = "wrapper", type = Wrapper::class) {
    gradleVersion = "3.4"
    distributionUrl = "http://services.gradle.org/distributions/gradle-$gradleVersion-bin.zip"
}
