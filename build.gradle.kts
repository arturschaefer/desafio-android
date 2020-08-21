// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    val kotlin_version by extra("1.3.61")
    repositories {
        google()
        jcenter()
        maven { url = uri("https://jitpack.io") }
    }
    dependencies {
        classpath(BuildPlugins.androidGradle)
        classpath(BuildPlugins.kotlinGradlePlugin)
        "classpath"("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlin_version")
    }
}

allprojects {
    repositories {
        google()
        jcenter()
        maven { url = uri("https://jitpack.io") }
    }
}

tasks.register("clean",Delete::class){
    delete(rootProject.buildDir)
}
//
//buildscript {
//    ext {
//        kotlin_version = '1.3.61'
//
//        appcompat_version = '1.1.0'
//        core_ktx_version = '1.2.0'
//        core_testing_version = '2.1.0'
//        constraintlayout_version = '1.1.3'
//        material_version = "1.1.0"
//        moshi_version = '1.8.0'
//        retrofit_version = '2.7.1'
//        okhttp_version = '4.3.1'
//        picasso_version = '2.71828'
//        circleimageview_version = '3.0.0'
//
//        junit_version = '4.12'
//        mockito_version = '2.27.0'
//        mockito_kotlin_version = '2.1.0'
//
//        test_runner_version = '1.1.1'
//        espresso_version = '3.1.1'
//
//        koin_version = "2.0.1"
//        dagger_version = "2.23.2"
//        lifecycle_version = "2.2.0"
//        coroutines_version = "1.3.3"
//        rxjava_version = "2.2.17"
//        rxandroid_version = "2.1.1"
//        core_ktx_test_version = "1.2.0"
//    }
//
//    repositories {
//        google()
//        jcenter()
//
//    }
//    dependencies {
//        classpath 'com.android.tools.build:gradle:3.5.3'
//        classpath "org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlin_version"
//        // NOTE: Do not place your application dependencies here; they belong
//        // in the individual module build.gradle files
//    }
//}
//
//allprojects {
//    repositories {
//        google()
//        jcenter()
//
//    }
//}
//
//task clean(type: Delete) {
//    delete rootProject.buildDir
//}
