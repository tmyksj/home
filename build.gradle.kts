plugins {
    kotlin("js") version "1.8.0"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains:markdown:0.3.5")
    implementation("org.jetbrains.kotlin-wrappers:kotlin-react:18.2.0-pre.471")
    implementation("org.jetbrains.kotlin-wrappers:kotlin-react-dom:18.2.0-pre.471")
    implementation("org.jetbrains.kotlin-wrappers:kotlin-react-legacy:18.2.0-pre.471")
    implementation("org.jetbrains.kotlin-wrappers:kotlin-react-router-dom:6.3.0-pre.471")
    implementation("org.jetbrains.kotlin-wrappers:kotlin-styled:5.3.6-pre.471")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")
    implementation(npm("@fluentui/react", "~8.104.2"))
    implementation(npm("d3-hierarchy", "~3.1.2"))
}

kotlin {
    js {
        binaries.executable()
        browser {
            commonWebpackConfig {
                cssSupport {
                    enabled.set(true)
                }
            }
        }
    }
}
