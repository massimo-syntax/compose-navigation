plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.compose)
}

android {
    namespace = "com.example.impl.detail"
    compileSdk {
        version = release(37)
    }

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    buildFeatures{
        compose = true
    }

}

dependencies {
    implementation(libs.androidx.compose.runtime)
    implementation(libs.androidx.navigation3.runtime)

    // detail route -> entry<Type>
    implementation(project(":feature:detail:api"))
    // detail screen
    implementation(project(":feature:detail:ui"))
}