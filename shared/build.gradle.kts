import com.vanniktech.maven.publish.SonatypeHost
import org.jetbrains.kotlin.gradle.ExperimentalWasmDsl
import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.targets.js.webpack.KotlinWebpackConfig

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.vanniktech.mavenPublish)
//    id("signing") // 用于对发布的构件进行签名
}

kotlin {
    androidTarget {
        publishLibraryVariants("release", "debug")
        compilations.all {
            compileTaskProvider.configure {
                compilerOptions {
                    jvmTarget.set(JvmTarget.JVM_1_8)
                }
            }
        }
    }

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "shared"
            isStatic = true
        }
    }
    linuxX64()
    jvm()
    @OptIn(ExperimentalWasmDsl::class)
    wasmJs {
        browser {
            val rootDirPath = project.rootDir.path
            val projectDirPath = project.projectDir.path
            commonWebpackConfig {
                devServer = (devServer ?: KotlinWebpackConfig.DevServer()).apply {
                    static = (static ?: mutableListOf()).apply {
                        // Serve sources to debug inside browser
                        add(rootDirPath)
                        add(projectDirPath)
                    }
                }
            }
        }
    }
    sourceSets {
        commonMain.dependencies {
            implementation(libs.kotlinx.datetime)
        }
        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }
    }
}

android {
    namespace = "hos.datetime"
    compileSdk = 35
    defaultConfig {
        minSdk = 24
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}
group = "io.github.cjfsss"
version = "1.0.0"
mavenPublishing {
    publishToMavenCentral(SonatypeHost.CENTRAL_PORTAL)
//    publishToMavenCentral("DEFAULT", true)
    signAllPublications()
    coordinates("io.github.cjfsss", "hos-datetime", "1.0.0")
    pom {
        name = "Kotlinx datetime Plus"
        description =
            "A KMP library that provides extensions and helper functions for kotlinx-datetime."
        inceptionYear = "2025"
        url = "https://github.com/cjfsss/MultiplatformDateTimePlus/"
        licenses {
            license {
                name = "The Apache License, Version 2.0"
                url = "https://www.apache.org/licenses/LICENSE-2.0.txt"
                distribution = "https://www.apache.org/licenses/LICENSE-2.0.txt"
            }
        }
        developers {
            developer {
                id = "cjfsss"
                name = "cjfsss"
                url = "https://github.com/cjfsss"
            }
        }
        scm {
            url = "https://github.com/cjfsss/MultiplatformDateTimePlus/"
            connection = "scm:git:git://github.com/cjfsss/MultiplatformDateTimePlus.git"
            developerConnection =
                "scm:git:ssh://git@github.com/cjfsss/MultiplatformDateTimePlus.git"
        }
    }
}
// 在 build.gradle.kts 中添加
//signing {
//    // 使用环境变量中的 GPG 密钥
//    val signingKey: String? by project
//    val signingPassword: String? by project
//
//    if (signingKey != null && signingPassword != null) {
//        useInMemoryPgpKeys(signingKey, signingPassword)
//        sign(publishing.publications["kotlinMultiplatform"])
//    }
//}