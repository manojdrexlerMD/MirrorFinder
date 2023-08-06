/*
 * Copyright (c) 2023.
 * Created By Manoj k Narayanan
 */


object Versions {
    const val GoogleFontVersion = "1.4.3"
    const val Kotlin_boom = "1.8.20"
    const val androidXLifeCycle = "2.6.1"
    const val ActivityCompose = "1.7.2"
    const val compsoe_boom = "2023.06.01"
    const val compose_ui = "1.6.0-alpha02"
    const val junit = "4.13.2"
    const val testJunit = "1.1.5"
    const val test_espresso_core = "3.5.1"
    const val test_Compose_boom = "2023.06.01"
    const val hilt_common = "1.0.0"
    const val hilt_work = "1.0.0"
    const val dagger_hilt_android = "2.47"
}

object TestDeps {
    const val junit = "junit:junit:${Versions.junit}"
    const val testJunit = "androidx.test.ext:junit:${Versions.testJunit}"
    const val test_espresso_core =
        "androidx.test.espresso:espresso-core:${Versions.test_espresso_core}"
    const val test_compose_boom = "androidx.compose:compose-bom:${Versions.test_Compose_boom}"
    const val compose_ui_test_junit = "androidx.compose.ui:ui-test-junit4"
    const val compose_ui_tooling = "androidx.compose.ui:ui-test-junit4"
    const val compose_ui_test_mainfest = "androidx.compose.ui:ui-test-manifest"
}

object Deps {
    const val android_X_lifeCycle_runTime =
        "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.androidXLifeCycle}"
    const val kotlinBoom = "org.jetbrains.kotlin:kotlin-bom:${Versions.Kotlin_boom}"
    const val googlefonts = "androidx.compose.ui:ui-text-google-fonts:${Versions.GoogleFontVersion}"
}


object ComposeDeps {
    const val activityCompose = "androidx.activity:activity-compose:${Versions.ActivityCompose}"
    const val compose_boom = "androidx.compose:compose-bom:${Versions.compsoe_boom}"
    const val composeUi = "androidx.compose.ui:ui:${Versions.compose_ui}"
    const val compose_ui_Graphics = "androidx.compose.ui:ui-graphics"
    const val compose_tooling_preview = "androidx.compose.ui:ui-tooling-preview"
    const val compose_material_3 = "androidx.compose.material3:material3"

}


object DepsHilt {
    const val hilt_common = "androidx.hilt:hilt-common:${Versions.hilt_common}"
    const val hilt_work = "androidx.hilt:hilt-work:${Versions.hilt_work}"
    const val dagger_hilt_android = "com.google.dagger:hilt-android:${Versions.dagger_hilt_android}"
}