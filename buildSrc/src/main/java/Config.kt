import org.gradle.api.JavaVersion

object Config {
    const val minSdkVersion = 21
    const val targetSdkVersion = 29
    const val compileSdkVersion = 29
    const val applicationId = "com.picpay.desafio.android"
    const val versionCode = 1
    const val versionName = "1.0"
    val javaVersion = JavaVersion.VERSION_1_8
}