object Dependencies {
    object Libs {
        const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${LibsVersions.General.kotlin}"
    }

    object TestLibs {
        const val junit = "junit:junit:${LibsVersions.Test.junit}"
    }

    object Koin {
        const val core = "org.koin:koin-android:${LibsVersions.Koin.core}"
        const val scope = "org.koin:koin-android-scope:${LibsVersions.Koin.scope}"
        const val viewModel = "org.koin:koin-android-viewmodel:${LibsVersions.Koin.viewmodel}"
        const val experimental = "org.koin:koin-androidx-ext:${LibsVersions.Koin.core}"
        const val java = "org.koin:koin-java:${LibsVersions.Koin.core}"
    }

    object Retrofit {
        const val core = "com.squareup.retrofit2:retrofit:${LibsVersions.Retrofit.core}"
        const val converterMoshi =
            "com.squareup.retrofit2:converter-moshi:${LibsVersions.Retrofit.converterMoshi}"
        const val moshiCodegen =
            "com.squareup.moshi:moshi-kotlin-codegen:${LibsVersions.Retrofit.moshiCondegen}"
    }

    object Coroutines {
        const val core =
            "org.jetbrains.kotlinx:kotlinx-coroutines-core:${LibsVersions.Coroutines.core}"
        const val android =
            "org.jetbrains.kotlinx:kotlinx-coroutines-android:${LibsVersions.Coroutines.core}"
    }

    object Androidx {
        const val appcompat = "androidx.appcompat:appcompat:${LibsVersions.Androidx.appcompat}"
        const val appcompatResources =
            "androidx.appcompat:appcompat-resources:${LibsVersions.Androidx.appcompat}"
        const val biometrics = "androidx.biometric:biometric:${LibsVersions.Androidx.biometrics}"
        const val browser = "androidx.browser:browser:${LibsVersions.Androidx.browser}"
        const val cardView =
            "androidx.cardview:cardview:${LibsVersions.Androidx.cardView}"
        const val constraintLayout =
            "androidx.constraintlayout:constraintlayout:${LibsVersions.Androidx.constraintLayout}"
        const val core = "androidx.core:core-ktx:${LibsVersions.Androidx.core}"
        const val material = "com.google.android.material:material:${LibsVersions.Androidx.material}"
        const val recyclerView =
            "androidx.recyclerview:recyclerview:${LibsVersions.Androidx.recyclerView}"
        const val securityCrypto = "androidx.security:security-crypto:${LibsVersions.Androidx.securityCrypto}"
        const val swipeRefreshLayout =
            "androidx.swiperefreshlayout:swiperefreshlayout:${LibsVersions.Androidx.swipeRefreshLayout}"
        const val fragment =
            "androidx.fragment:fragment-ktx:${LibsVersions.Androidx.fragment}"
        const val activity =
            "androidx.activity:activity-ktx:${LibsVersions.Androidx.activity}"
        const val annotation =
            "androidx.annotation:annotation:${LibsVersions.Androidx.core}"
        const val navigationFragment =
            "androidx.navigation:navigation-fragment-ktx:${LibsVersions.Androidx.navigation}"
        const val navigationUI =
            "androidx.navigation:navigation-ui-ktx:${LibsVersions.Androidx.navigation}"
    }

    object Commons {
        const val lottie = "com.airbnb.android:lottie:${LibsVersions.General.lottie}"
        const val timber = "com.jakewharton.timber:timber:${LibsVersions.General.timber}"
    }

    object Images{
        const val picasso = "com.squareup.picasso:picasso:${LibsVersions.Images.picasso}"
        const val circleImage = "de.hdodenhof:circleimageview:${LibsVersions.Images.circleImageView}"
    }

    object Test{
        const val junit = "junit:junit:${LibsVersions.Test.junit}"
        const val mockk = "io.mockk:mockk:${LibsVersions.Test.mockk}"
        const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${LibsVersions.Coroutines.core}"
        const val koin = "org.koin:koin-test:${LibsVersions.Koin.core}"

        object Mockk {
            const val core = "io.mockk:mockk:${LibsVersions.Test.mockk}"
            const val android = "io.mockk:mockk-android:${LibsVersions.Test.mockk}"
        }

        object Androidx {
            const val arch = "androidx.arch.core:core-testing:${LibsVersions.Test.coreTesting}"
            const val rules = "androidx.test:rules:${LibsVersions.Test.androidx}"
            const val runner = "androidx.test:runner:${LibsVersions.Test.androidx}"
            const val ext = "androidx.test.ext:junit:${LibsVersions.Test.androidx}"
            const val espressoCore =
                "androidx.test.espresso:espresso-core:${LibsVersions.Test.espressoCore}"
        }
    }
}