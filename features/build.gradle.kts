/*
 * Copyright (c) 2023.
 * Created By Manoj k Narayanan
 */

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.gravition.mirrorfinder.features"
    compileSdk = 33

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
}

dependencies {

    implementation (Deps.googlefonts)
    implementation(platform(Deps.kotlinBoom))
    implementation (Deps.android_X_lifeCycle_runTime)
    implementation (ComposeDeps.activityCompose)
    implementation(platform(ComposeDeps.compose_boom))
    implementation (ComposeDeps.composeUi)
    implementation (ComposeDeps.compose_ui_Graphics)
    implementation (ComposeDeps.compose_tooling_preview)
    implementation (ComposeDeps.compose_material_3)
    testImplementation (TestDeps.junit)
    androidTestImplementation (TestDeps.testJunit)
    androidTestImplementation (TestDeps.test_espresso_core)
    androidTestImplementation(platform(TestDeps.test_compose_boom))
    androidTestImplementation (TestDeps.compose_ui_test_junit)
    debugImplementation (TestDeps.compose_ui_tooling)
    debugImplementation (TestDeps.compose_ui_test_mainfest)

}