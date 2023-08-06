// Top-level build file where you can add configuration options common to all sub-projects/modules.


buildscript {

    val compose_version = "1.4.0-alpha04"
    val compose_ui_version = "1.4.3"
    val kotlin_version = "1.9.0"
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath("com.google.dagger:hilt-android-gradle-plugin:2.47")
        classpath("com.android.tools.build:gradle:8.1.0")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlin_version")
    }
}

plugins {
    id("com.android.application") version "8.1.0" apply false;
    id("com.android.library") version "8.1.0" apply false;
    id("org.jetbrains.kotlin.android") version "1.7.20" apply false;
}


tasks.register("clean",Delete::class){
    delete(rootProject.buildDir)
}
