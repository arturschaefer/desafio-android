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

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions {
        jvmTarget = Config.javaVersion.toString()
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

    //TODO change to use Dependencies.
    implementation ("com.squareup.okhttp3:okhttp:${LibsVersions.Test.okhttp_version}")
    implementation ("com.squareup.okhttp3:mockwebserver:${LibsVersions.Test.okhttp_version}")

    testImplementation ("junit:junit:${LibsVersions.Test.junit}")
    testImplementation ( "org.mockito:mockito-core:${LibsVersions.Test.mockito_version}")
    testImplementation ("com.nhaarman.mockitokotlin2:mockito-kotlin:${LibsVersions.Test.mockito_kotlin_version}")
    testImplementation ("androidx.arch.core:core-testing:${LibsVersions.Test.core_testing_version}")
    implementation ("org.koin:koin-test:${LibsVersions.Test.koin_version}")

    androidTestImplementation ("androidx.test:runner:${LibsVersions.Test.test_runner_version}")
    androidTestImplementation ("androidx.test.espresso:espresso-core:${LibsVersions.Test.espresso_version}")
    androidTestImplementation ("androidx.test:core-ktx:${LibsVersions.Test.core_ktx_test_version}")

}