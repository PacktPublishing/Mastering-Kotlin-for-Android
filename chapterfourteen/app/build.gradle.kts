plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlinx-serialization")
    id("com.google.devtools.ksp")
}

android {
    signingConfigs {
        create("release") {
            storeFile =
                file(
                    "/Users/harun/AndroidStudioProjects/Mastering-Kotlin-for-Android" +
                        "/chapterfourteen/keystore/packt.jks"
                )
            storePassword = "android"
            keyAlias = "packt"
            keyPassword = "android"
        }
    }
    namespace = "com.packt.chapterthirteen"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.packt.chapterfourteen"
        minSdk = 24
        targetSdk = 34
        versionCode = 2
        versionName = "1.0.1"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
        signingConfig = signingConfigs.getByName("release")
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            isShrinkResources = true
            setProguardFiles(
                listOf(
                    getDefaultProguardFile("proguard-android.txt"),
                    "proguard-rules.pro"
                )
            )
        }
        debug {
            isMinifyEnabled = false
            isShrinkResources = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.2"
    }

    packagingOptions {
        resources {
            pickFirsts.add("META-INF/AL2.0")
            pickFirsts.add("META-INF/LGPL2.1")
        }
    }

    ksp {
        arg("room.schemaLocation", "$projectDir/schemas")
    }
}

dependencies {
    implementation(libs.core.ktx)
    implementation(libs.lifecycle)
    implementation(libs.activity.compose)
    implementation(platform(libs.compose.bom))
    implementation(libs.bundles.compose)
    implementation(libs.bundles.koin)
    implementation(libs.bundles.networking)
    implementation(libs.compose.navigation)
    implementation(libs.compose.window.size)
    implementation(libs.androidx.window)
    implementation(libs.room.runtime)
    implementation(libs.room.ktx)
    debugImplementation(libs.leakcanary.android)
    debugImplementation(libs.chucker)
    releaseImplementation(libs.chucker.no.op)
    ksp(libs.room.compiler)
    implementation(libs.work.runtime)
    implementation(libs.workmanager.koin)
    testImplementation(libs.test.junit)
    testImplementation(libs.bundles.test)
    androidTestImplementation(libs.test.junitExt)
    androidTestImplementation(libs.test.espresso)
    androidTestImplementation(platform(libs.compose.bom))
    androidTestImplementation(libs.test.compose.junit4)
    androidTestImplementation(libs.work.testing)
    debugImplementation(libs.compose.ui.tooling)
    debugImplementation(libs.compose.manifest)
}
