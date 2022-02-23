plugins {
    kotlin("js") version "1.6.10"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains:markdown:0.3.1")
    implementation("org.jetbrains.kotlin-wrappers:kotlin-react-dom:17.0.2-pre.303-kotlin-1.6.10")
    implementation("org.jetbrains.kotlin-wrappers:kotlin-react-legacy:17.0.2-pre.303-kotlin-1.6.10")
    implementation("org.jetbrains.kotlin-wrappers:kotlin-react-router-dom:6.2.1-pre.303-kotlin-1.6.10")
    implementation("org.jetbrains.kotlin-wrappers:kotlin-styled:5.3.3-pre.303-kotlin-1.6.10")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.0-native-mt")
    implementation(npm("@fluentui/react", "~8.55.3"))
    implementation(npm("d3-hierarchy", "~3.1.1"))
}

kotlin {
    js(LEGACY) {
        binaries.executable()
        browser {
            commonWebpackConfig {
                cssSupport.enabled = true
            }
        }
    }
}
