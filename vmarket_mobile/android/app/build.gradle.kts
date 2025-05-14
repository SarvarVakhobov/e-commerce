plugins {
    id("com.android.application")
    id("kotlin-android")
    // The Flutter Gradle Plugin must be applied after the Android and Kotlin Gradle plugins.
    id("dev.flutter.flutter-gradle-plugin")
}

android {
    namespace = "com.example.vmarket_mobile"
    compileSdk = flutter.compileSdkVersion
    ndkVersion = "27.0.12077973" // Update to the required NDK version

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_11.toString()
    }

    defaultConfig {
        // TODO: Specify your own unique Application ID (https://developer.android.com/studio/build/application-id.html).
        applicationId = "com.example.vmarket_mobile"
        // You can update the following values to match your application needs.
        // For more information, see: https://flutter.dev/to/review-gradle-config.
        minSdk = flutter.minSdkVersion ?: 21 // Ensure minSdk is at least 21 for Stripe
        targetSdk = flutter.targetSdkVersion
        versionCode = flutter.versionCode
        versionName = flutter.versionName
    }

    buildTypes {
        release {
            // TODO: Add your own signing config for the release build.
            // Signing with the debug keys for now, so `flutter run --release` works.
            signingConfig = signingConfigs.getByName("debug")
        }
    }
    
    // Add this to fix Stripe-related dependency issues
    configurations.all {
        resolutionStrategy {
            force("com.android.tools.build:gradle:7.3.0")
            force("org.jetbrains.kotlin:kotlin-gradle-plugin:2.0.0")
        }
    }
}

flutter {
    source = "../.."
}

// Add dependencies that Stripe might need
dependencies {
    // No explicit dependencies needed as Flutter handles them
    // But we can add specific versions if needed
}
