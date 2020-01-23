object AndroidSettings {
    const val appVersionName = "0.1"
    const val compileSdk = 29
    const val buildTools = "29.0.2"
    const val minSdk = 26
    const val targetSdk = 29
    const val testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
}

object Versions {
    const val appCompat = "1.1.0"
    const val kotlin = "1.3.60"
    const val gradle = "3.5.1"
    const val constraintLayout = "2.0.0-beta3"
    const val lifeCycle = "2.0.0"
    const val material = "1.1.0-beta01"
    const val lifecycleLivedataKtx = "2.2.0"
    const val glide = "4.8.0"
    const val rxAndroid = "2.1.1"
    const val rxKotlin = "2.4.0"
}

object BuildDependencies {
    const val androidGradle =
        "com.android.tools.build:gradle:${Versions.gradle}"
    const val kotlinGradlePlugin =
        "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
}

object Dependencies {

    object AndroidX {
        const val fragmentKtx =
            "androidx.fragment:fragment-ktx:${Versions.appCompat}"
        const val coreKtx =
            "androidx.core:core-ktx:${Versions.appCompat}"
        const val constraintlayout =
            "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    }

    const val rxAndroid =
        "io.reactivex.rxjava2:rxandroid:${Versions.rxAndroid}"
    const val rxJava =
        "io.reactivex.rxjava2:rxkotlin:${Versions.rxKotlin}"

    const val material = "com.google.android.material:material:${Versions.material}"
    const val glide = "com.github.bumptech.glide:glide:${Versions.glide}"
}