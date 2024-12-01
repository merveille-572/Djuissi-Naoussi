plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)

}

android {
    namespace = "com.example.volsapp"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.volsapp"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    implementation(libs.androidx.room.common)


    // Jetpack Compose dependencies
    implementation ("androidx.compose.ui:ui:1.4.0")
    implementation ("androidx.compose.material3:material3:1.1.0")
    implementation ("androidx.compose.ui:ui-tooling-preview:1.4.0")
    implementation(libs.androidx.runtime.livedata)
    debugImplementation ("androidx.compose.ui:ui-tooling:1.4.0")
    // Room dependencies
    implementation ("androidx.room:room-runtime:2.6.1")



    // DataStore for storing preferences
    implementation ("androidx.datastore:datastore-preferences:1.0.0")

    // Lifecycle dependencies for ViewModel and LiveData
    implementation ("androidx.lifecycle:lifecycle-viewmodel-compose:2.6.0")
    implementation ("androidx.lifecycle:lifecycle-runtime-ktx:2.6.0")
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}