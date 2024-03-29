plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id ("kotlin-kapt")
    id("dagger.hilt.android.plugin")}

android {
    namespace = "com.example.learn"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.learn"
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        viewBinding = true
        dataBinding = true

    }

}
kapt {
    correctErrorTypes = true
}

dependencies {

    implementation("androidx.core:core-ktx:1.10.1")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.9.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    implementation ("com.squareup.retrofit2:retrofit:2.9.0")
    implementation ("com.squareup.okhttp3:logging-interceptor:5.0.0-alpha.11")

    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation ("com.google.code.gson:gson:2.10")
    //Hilt dependency
    //implementation ("com.google.dagger:hilt-android:2.45")
    //kapt ("com.google.dagger:hilt-android-compiler:2.45")
    //kapt ("androidx.hilt:hilt-compiler:1.0.0")
    //implementation ("androidx.hilt:hilt-navigation-compose:1.1.0-rc01")
    //implementation "androidx.hilt:hilt-lifecycle-viewmodel:1.0.0-alpha03"
    //kapt "androidx.hilt:hilt-compiler:1.0.0"
    implementation ("com.google.dagger:hilt-android:2.50")
    kapt ("com.google.dagger:hilt-compiler:2.50")

    // For instrumentation tests
    androidTestImplementation  ("com.google.dagger:hilt-android-testing:2.50")
    kaptAndroidTest ("com.google.dagger:hilt-compiler:2.50")

    // For local unit tests
    testImplementation ("com.google.dagger:hilt-android-testing:2.50")
    kaptTest ("com.google.dagger:hilt-compiler:2.50")

    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:2.7.0")
    implementation ("androidx.lifecycle:lifecycle-livedata-core-ktx:2.7.0")

    // Glide
    implementation ("com.github.bumptech.glide:glide:4.13.2")
    annotationProcessor ("com.github.bumptech.glide:compiler:4.13.2")
    // Room
    //implementation ("androidx.room:room-runtime:2.6.1")
    kapt ("androidx.room:room-compiler:2.6.1")


// Coroutines
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.0")
    implementation ("androidx.room:room-ktx:2.6.1")
}