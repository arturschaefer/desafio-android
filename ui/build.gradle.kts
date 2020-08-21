plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("android.extensions")
    kotlin("kapt")
}

android {
    compileSdkVersion(Config.compileSdkVersion)

    defaultConfig {
        minSdkVersion(Config.minSdkVersion)
        targetSdkVersion(Config.targetSdkVersion)
        versionCode = 1
        versionName = "1.0"
    }
}

androidExtensions {
    isExperimental = true
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))

    api(Dependencies.Androidx.core)
    api(Dependencies.Androidx.annotation)
    api(Dependencies.Androidx.fragment)
    api(Dependencies.Androidx.activity)
    api(Dependencies.Androidx.material)
    api(Dependencies.Androidx.constraintLayout)

    api(Dependencies.Images.picasso)
    api(Dependencies.Images.circleImage)
}