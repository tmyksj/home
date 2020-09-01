plugins {
    id("org.jetbrains.kotlin.js") version "1.3.72"
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

    implementation("org.jetbrains:kotlin-react:16.13.1-pre.107-kotlin-1.3.72")
    implementation("org.jetbrains:kotlin-react-dom:16.13.1-pre.107-kotlin-1.3.72")
    implementation("org.jetbrains:kotlin-react-router-dom:5.1.2-pre.107-kotlin-1.3.72")
    implementation("org.jetbrains:kotlin-styled:1.0.0-pre.107-kotlin-1.3.72")

    implementation(npm("@fluentui/react"))
    implementation(npm("inline-style-prefixer"))
    implementation(npm("react", "16.13.1"))
    implementation(npm("react-dom", "16.13.1"))
    implementation(npm("styled-components"))
}

kotlin.target.browser {
}
