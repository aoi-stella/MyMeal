import flavor_type.DevelopFlavorType
import flavor_type.ProductionFlavorType
import flavor_type.StagingFlavorType

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.ksp)
    alias(libs.plugins.compose.compiler)
}

android {
    namespace = "com.aoi.mymeal"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.aoi.mymeal"
        minSdk = 31
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
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
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }

    buildTypes {
        getByName(BuildConfig.BuildTypes.RELEASE) {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }

        getByName(BuildConfig.BuildTypes.DEBUG) {
            applicationIdSuffix = BuildConfig.ApplicationIdSuffix.DEBUG
            isDebuggable = true
        }
    }

    val flavorTypes = listOf(
        DevelopFlavorType(),
        StagingFlavorType(),
        ProductionFlavorType()
    )

    flavorDimensions += BuildConfig.Flavor.FlavorDimensions.getListOfFlavorDimensions()
    productFlavors {
        flavorTypes.forEach { flavorType ->
            create(flavorType.flavorName) {
                dimension = flavorType.dimension
                applicationIdSuffix = flavorType.applicationIdSuffix
                versionNameSuffix = flavorType.versionNameSuffix
            }
        }
    }
}

dependencies {
    // ktx
    implementation(libs.androidx.core.ktx)
    // lifecycle
    implementation(libs.androidx.lifecycle.runtime.ktx)
    // compose[一般]
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.material3)
    // compose[デバッグ]
    implementation(libs.androidx.ui.tooling.preview)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
    // unit test
    testImplementation(libs.junit)
    // ui test
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    // multi module
    implementation(project(":presentation"))
    implementation(project(":domain"))
    implementation(project(":data"))
    implementation(project(":core"))
}