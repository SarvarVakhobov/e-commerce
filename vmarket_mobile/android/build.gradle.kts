allprojects {
    repositories {
        google()
        mavenCentral()
        // Add alternative repositories
        maven { url = uri("https://maven.aliyun.com/repository/google") }
        maven { url = uri("https://maven.aliyun.com/repository/public") }
        maven { url = uri("https://maven.aliyun.com/repository/gradle-plugin") }
        maven { url = uri("https://jitpack.io") }
    }
    
    // Configure all projects to use a consistent Kotlin and Gradle version
    configurations.all {
        resolutionStrategy {
            // Force consistent versions for all subprojects
            force("com.android.tools.build:gradle:7.3.0")
            force("org.jetbrains.kotlin:kotlin-gradle-plugin:1.8.22")
            // Retry configuration - correctly implemented for Kotlin DSL
            cacheChangingModulesFor(0, "seconds")
        }
    }
}

val newBuildDir: Directory = rootProject.layout.buildDirectory.dir("../../build").get()
rootProject.layout.buildDirectory.value(newBuildDir)

subprojects {
    val newSubprojectBuildDir: Directory = newBuildDir.dir(project.name)
    project.layout.buildDirectory.value(newSubprojectBuildDir)
}
subprojects {
    project.evaluationDependsOn(":app")
}

tasks.register<Delete>("clean") {
    delete(rootProject.layout.buildDirectory)
}
