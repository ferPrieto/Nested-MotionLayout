plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-android-extensions")
}

android {
    defaultConfig {
        applicationId = "prieto.fernando.fancymotionlayout"
        compileSdkVersion(AndroidSettings.compileSdk)
        buildToolsVersion(AndroidSettings.buildTools)
        versionCode = 1
        versionName = "1.0"

        minSdkVersion(AndroidSettings.minSdk)
        targetSdkVersion(AndroidSettings.targetSdk)

        testInstrumentationRunner = AndroidSettings.testInstrumentationRunner
    }
    testOptions {
        unitTests.isReturnDefaultValues = true
        animationsDisabled = true
    }
    buildTypes {
        getByName("debug") {
            isDebuggable = true
        }
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                file("proguard-rules.pro")
            )
        }
    }
}

dependencies {
    implementation(Dependencies.AndroidX.fragmentKtx)
    implementation(Dependencies.AndroidX.coreKtx)
    implementation(Dependencies.AndroidX.constraintlayout)

    implementation(Dependencies.material)
    implementation(Dependencies.glide)

    implementation(Dependencies.rxAndroid)
    implementation(Dependencies.rxJava)
}
