plugins {
    id("org.jetbrains.kotlin.js") version "1.4.0"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    maven("https://kotlin.bintray.com/kotlin-js-wrappers/")
    mavenCentral()
    jcenter()
}

dependencies {
    implementation(kotlin("stdlib-js"))

    implementation("org.jetbrains:kotlin-react:16.13.1-pre.112-kotlin-1.4.0")
    implementation("org.jetbrains:kotlin-react-dom:16.13.1-pre.112-kotlin-1.4.0")
    implementation("org.jetbrains:kotlin-react-router-dom:5.1.2-pre.112-kotlin-1.4.0")
    implementation("org.jetbrains:kotlin-styled:1.0.0-pre.112-kotlin-1.4.0")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.3.9")

    implementation(npm("@fluentui/react", "~7.134.1"))
    implementation(npm("inline-style-prefixer", "~6.0.0"))
    implementation(npm("react", "16.13.1"))
    implementation(npm("react-dom", "16.13.1"))
    implementation(npm("styled-components", "~5.2.0"))
}

kotlin {
    js {
        browser {
            webpackTask {
                cssSupport.enabled = true
            }

            runTask {
                cssSupport.enabled = true
            }

            testTask {
                useKarma {
                    useChromeHeadless()
                    webpackConfig.cssSupport.enabled = true
                }
            }
        }
        binaries.executable()
    }
}
