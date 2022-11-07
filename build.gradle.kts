plugins {
    id("java")
    id("org.jetbrains.intellij") version "1.9.0"
    id("scala")
}

group = "com.github"
version = "1.0.1-SNAPSHOT"

repositories {
    maven("https://maven.aliyun.com/nexus/content/groups/public/")
}

dependencies {
    implementation("org.scala-lang:scala-library:2.13.10")
    implementation("commons-codec:commons-codec:1.15")
    implementation("commons-io:commons-io:2.11.0")
}

// Configure Gradle IntelliJ Plugin
// Read more: https://plugins.jetbrains.com/docs/intellij/tools-gradle-intellij-plugin.html
intellij {
    version.set("2021.1.1")
    type.set("IC") // Target IDE Platform

    plugins.set(listOf(/* Plugin Dependencies */))
    updateSinceUntilBuild.set(false)
}

tasks {
    // Set the JVM compatibility versions
    withType<JavaCompile> {
        sourceCompatibility = "11"
        targetCompatibility = "11"
    }

    patchPluginXml {
        sinceBuild.set("211")
    }

    signPlugin {
        certificateChain.set(System.getenv("CERTIFICATE_CHAIN"))
        privateKey.set(System.getenv("PRIVATE_KEY"))
        password.set(System.getenv("PRIVATE_KEY_PASSWORD"))
    }

    publishPlugin {
        token.set(System.getenv("PUBLISH_TOKEN"))
    }
}
