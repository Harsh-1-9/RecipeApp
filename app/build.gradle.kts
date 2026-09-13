plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.compose)
    id("org.jetbrains.kotlin.plugin.serialization") version "2.4.20"
    id("com.google.devtools.ksp")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.example.recipeapp"
    compileSdk {
        version = release(37) {
            minorApiLevel = 1
        }
    }

    defaultConfig {
        applicationId = "com.example.recipeapp"
        minSdk = 28
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            optimization {
                enable = false
            }
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    buildFeatures {
        compose = true
    }
}

dependencies {
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.compose.material3)
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.ui.graphics)
    implementation(libs.androidx.compose.ui.tooling.preview)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    testImplementation(libs.junit)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.compose.ui.test.junit4)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(libs.androidx.junit)
    debugImplementation(libs.androidx.compose.ui.test.manifest)
    debugImplementation(libs.androidx.compose.ui.tooling)
    // Icons
    implementation("androidx.compose.material:material-icons-extended:<version>")
    // For Ktor (HTTP client)
    implementation("io.ktor:ktor-client-core:3.5.0")
    implementation("io.ktor:ktor-client-android:3.5.2")
    implementation("io.ktor:ktor-client-content-negotiation:3.5.2")
    implementation("io.ktor:ktor-serialization-kotlinx-json:3.5.2")

// For Serialization
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.11.0")

// For Navigation
    implementation("androidx.navigation:navigation-compose:2.10.0")

// For ViewModel Compose
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.11.0")
// For Coil (URL to Images)
    implementation("io.coil-kt:coil-compose:2.7.0")

// For Extra Icons
    implementation("androidx.compose.material:material-icons-extended")


    // For Hilt
    implementation("com.google.dagger:hilt-android:2.60.1")
    ksp("com.google.dagger:hilt-android-compiler:2.60.1")

    // Fo Navigation Hilt
    implementation("androidx.hilt:hilt-lifecycle-viewmodel-compose:1.4.0")
    ksp("androidx.hilt:hilt-compiler:1.4.0")
}