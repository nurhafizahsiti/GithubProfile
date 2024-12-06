import java.io.FileInputStream
import java.util.Properties

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    id ("kotlin-kapt")
}
val apikeyPropertiesFile = rootProject.file("apikey.properties")
val apikeyProperties = Properties()
apikeyProperties.load(FileInputStream(apikeyPropertiesFile))
android {
    namespace = "id.ac.polbeng.sitinurhafizah.githubprofile"
    compileSdk = 35

    defaultConfig {
        applicationId = "id.ac.polbeng.sitinurhafizah.githubprofile"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
        buildConfigField("String", "ACCESS_TOKEN", "\"${apikeyProperties.getProperty("ACCESS_TOKEN")}\"")
    
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    viewBinding {
        enable = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    //library untuk menampilkan gambar bergerak splashscreen
    implementation ("com.airbnb.android:lottie:5.2.0")
//library untuk menampilkan gambar bulat (circle)
    implementation ("de.hdodenhof:circleimageview:3.1.0")
//library untuk menampilkan gambar melalui url
    kapt ("com.github.bumptech.glide:compiler:4.13.2")
    implementation ("com.github.bumptech.glide:glide:4.13.2")
//library untuk request API
    implementation ("com.squareup.retrofit2:retrofit:2.9.0")
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")
//library untuk logging hasil request API
    implementation ("com.squareup.okhttp3:logging-interceptor:5.0.0-alpha.9")
}