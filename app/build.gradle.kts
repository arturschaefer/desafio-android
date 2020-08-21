import org.gradle.kotlin.dsl.kotlin

plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("android.extensions")
    kotlin("kapt")
    id("kotlin-android")
}

android {
    compileSdkVersion(Config.compileSdkVersion)

    defaultConfig {
        applicationId = Config.applicationId
        minSdkVersion(Config.minSdkVersion)
        targetSdkVersion(Config.targetSdkVersion)
        versionCode = Config.versionCode
        versionName = Config.versionName

        vectorDrawables.useSupportLibrary = true

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("debug"){}

        getByName("release") {
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = Config.javaVersion
        targetCompatibility =  Config.javaVersion
    }
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions {
        jvmTarget = Config.javaVersion.toString()
    }
}

dependencies {
    implementation(project(":actions"))

    implementation(Dependencies.Androidx.core)
    implementation(Dependencies.Androidx.appcompat)
}


//apply plugin: 'com.android.application'
//
//apply plugin: 'kotlin-android'
//
//apply plugin: 'kotlin-android-extensions'
//
//apply plugin: 'kotlin-kapt'
//
//android {
//    compileSdkVersion 29
//    defaultConfig {
//        applicationId "com.picpay.desafio.android"
//        minSdkVersion 21
//        targetSdkVersion 29
//        versionCode 1
//        versionName "1.0"
//
//        vectorDrawables.useSupportLibrary = true
//
//        testInstrumentationRunner "androidx.test.runner.AndroidJUnitRunner"
//    }
//    buildTypes {
//        debug {}
//
//        release {
//            minifyEnabled true
//            shrinkResources true
//            proguardFiles getDefaultProguardFile('proguard-android-optimize.txt'), 'proguard-rules.pro'
//        }
//    }
//
//    compileOptions {
//        sourceCompatibility 1.8
//        targetCompatibility 1.8
//    }
//
//    kotlinOptions {
//        jvmTarget = JavaVersion.VERSION_1_8.toString()
//    }
//}
//
//dependencies {
//    implementation fileTree(dir: 'libs', include: ['*.jar'])
//
//    implementation "org.jetbrains.kotlin:kotlin-stdlib-jdk7:$kotlin_version"
//
//    implementation "androidx.core:core-ktx:$core_ktx_version"
//
//    implementation "androidx.appcompat:appcompat:$appcompat_version"
//    implementation "androidx.constraintlayout:constraintlayout:$constraintlayout_version"
//
//    implementation "com.google.android.material:material:$material_version"
//
//    implementation "org.koin:koin-core:$koin_version"
//    implementation "org.koin:koin-android:$koin_version"
//    implementation "org.koin:koin-androidx-viewmodel:$koin_version"
//
//    implementation "com.google.dagger:dagger:$dagger_version"
//    kapt "com.google.dagger:dagger-compiler:$dagger_version"
//
//    implementation "androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycle_version"
//    implementation "androidx.lifecycle:lifecycle-livedata-ktx:$lifecycle_version"
//    implementation "androidx.lifecycle:lifecycle-runtime-ktx:$lifecycle_version"
//
//    implementation "org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutines_version"
//    implementation "org.jetbrains.kotlinx:kotlinx-coroutines-android:$coroutines_version"
//    testImplementation "org.jetbrains.kotlinx:kotlinx-coroutines-test:$coroutines_version"
//
//    implementation "io.reactivex.rxjava2:rxjava:$rxjava_version"
//    implementation "io.reactivex.rxjava2:rxandroid:$rxandroid_version"
//
//    implementation 'com.google.code.gson:gson:2.8.6'
//
//    implementation "com.squareup.retrofit2:retrofit:$retrofit_version"
//    implementation "com.squareup.retrofit2:adapter-rxjava2:$retrofit_version"
//    implementation "com.squareup.retrofit2:converter-gson:$retrofit_version"
//    implementation "com.squareup.okhttp3:okhttp:$okhttp_version"
//    implementation "com.squareup.okhttp3:mockwebserver:$okhttp_version"
//
//    implementation "com.squareup.picasso:picasso:$picasso_version"
//    implementation "de.hdodenhof:circleimageview:$circleimageview_version"
//
//    testImplementation "junit:junit:$junit_version"
//    testImplementation "org.mockito:mockito-core:$mockito_version"
//    testImplementation "com.nhaarman.mockitokotlin2:mockito-kotlin:$mockito_kotlin_version"
//    testImplementation "androidx.arch.core:core-testing:$core_testing_version"
//    implementation "org.koin:koin-test:$koin_version"
//
//    androidTestImplementation "androidx.test:runner:$test_runner_version"
//    androidTestImplementation "androidx.test.espresso:espresso-core:$espresso_version"
//    androidTestImplementation "androidx.test:core-ktx:$core_ktx_test_version"
//}
