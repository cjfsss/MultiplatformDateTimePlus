enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")
pluginManagement {
    repositories {
        maven { url = uri("https://maven.aliyun.com/repository/public") }
        google()
        gradlePluginPortal()
        mavenLocal()
        mavenCentral()
    }
}

dependencyResolutionManagement {
    repositories {
        maven { url = uri("https://maven.aliyun.com/repository/public") }
        google()
        mavenLocal()
        mavenCentral()
    }
}

rootProject.name = "MultiplatformDateTimePlus"
include(":shared")