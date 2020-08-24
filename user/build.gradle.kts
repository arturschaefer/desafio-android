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

    buildTypes {
        getByName("debug") {
            buildConfigField("String", "BASE_URL", project.property("BASE_URL") as String)
        }
        getByName("release") {
            buildConfigField("String", "BASE_URL", project.property("BASE_URL") as String)
        }
    }
}

androidExtensions {
    isExperimental = true
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))

    implementation(project(":ui"))

    implementation(Dependencies.Retrofit.core)
    implementation(Dependencies.Retrofit.converterMoshi)
    implementation(Dependencies.Koin.core)
    implementation(Dependencies.Koin.viewModel)
    implementation(Dependencies.Commons.timber)

    implementation(Dependencies.Room.roomRuntime)
    implementation(Dependencies.Room.roomKtx)
    kapt(Dependencies.Room.roomCompiler)
}