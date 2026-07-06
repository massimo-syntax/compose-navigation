plugins {
    alias(libs.plugins.android.library)
    // @Serialize annotation for autogeneration of Serializers.
    alias(libs.plugins.jetbrains.kotlin.serialization)
}

android {
    namespace = "com.example.api.detail"
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

}

dependencies {
    // NavKey type
    implementation(libs.androidx.navigation3.runtime)
    // @Serializable for NavKey
    implementation(libs.kotlinx.serialization.core)
}