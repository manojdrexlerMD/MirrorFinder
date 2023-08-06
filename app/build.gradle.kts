plugins {
    id ("com.android.application")
    id("org.jetbrains.kotlin.android")
    id ("kotlin-kapt")
    id ("dagger.hilt.android.plugin")
}
android{
    namespace = ("com.gravition.mirrorfinder")
    compileSdk  = 34

    defaultConfig {
        applicationId = ("com.gravition.mirrorfinder")
        minSdk  = 24
        targetSdk  = 34
        versionCode = 1
        versionName  = "1.0"

        testInstrumentationRunner = ("androidx.test.runner.AndroidJUnitRunner")
        vectorDrawables {
            useSupportLibrary =  true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"),"proguard-rules.pro")
        }
    }

    compileOptions {
        sourceCompatibility =  JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose  = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion =  "1.5.0"
    }
    packaging{
        resources {
            excludes.add("/META-INF/{AL2.0,LGPL2.1}")
        }
    }
}

dependencies {


    implementation(project(":features"))

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

    val nav_version = "2.6.0"


    implementation (DepsHilt.hilt_common)
    implementation(DepsHilt.hilt_work)
    implementation(DepsHilt.dagger_hilt_android)

    kapt("com.google.dagger:hilt-android-compiler:2.44")
    // implementation "androidx.hilt:hilt-lifecycle-viewmodel:1.0.0-alpha03"
    kapt ("androidx.hilt:hilt-compiler:1.0.0")
    implementation ("androidx.hilt:hilt-navigation-compose:1.0.0")
    implementation("androidx.navigation:navigation-compose:$nav_version")

    implementation("androidx.constraintlayout:constraintlayout-compose:1.0.1")

    //viewModelCompose
    implementation ("androidx.work:work-runtime-ktx:2.9.0-alpha02")
    implementation ("androidx.lifecycle:lifecycle-viewmodel-compose:2.6.1")


    //charts
    implementation ("com.patrykandpatrick.vico:core:1.6.5")
    implementation ("com.patrykandpatrick.vico:compose-m3:1.6.5")

    // For AppWidgets support
    implementation ("androidx.glance:glance-appwidget:1.0.0-rc01")



    // For interop APIs with Material 3
    implementation ("androidx.glance:glance-material3:1.0.0-rc01")
}

