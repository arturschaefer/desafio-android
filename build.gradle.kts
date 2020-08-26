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

tasks.register("clean",Delete::class) {
    delete(rootProject.buildDir)
}
