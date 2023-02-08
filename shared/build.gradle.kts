plugins {
    kotlin("multiplatform")
    id("com.android.library")
    id("app.cash.sqldelight")
}

kotlin {
    android {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }
    
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "shared"
        }
    }

    sourceSets {
        val commonMain by getting{
            dependencies{
                with(Ktor.IO.Ktor){
                    implementation(ktorClientCore)
                    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")
                }
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
        val androidMain by getting{
            dependencies {
                with(SQLDelight.App.Cash.Sqldelight){
                    implementation(androidDriver)
                }
                with(Ktor.IO.Ktor){
                    implementation(ktorAndroidClient)
                }
            }
        }
        val androidUnitTest by getting
        val iosX64Main by getting
        val iosArm64Main by getting
        val iosSimulatorArm64Main by getting
        val iosMain by creating {
            dependsOn(commonMain)
            iosX64Main.dependsOn(this)
            iosArm64Main.dependsOn(this)
            iosSimulatorArm64Main.dependsOn(this)
            dependencies {
                with(SQLDelight.App.Cash.Sqldelight){
                    implementation(nativeDriver)
                }
                with(Ktor.IO.Ktor){
                    implementation(ktorIosClient)
                }
            }
        }
        val iosX64Test by getting
        val iosArm64Test by getting
        val iosSimulatorArm64Test by getting
        val iosTest by creating {
            dependsOn(commonTest)
            iosX64Test.dependsOn(this)
            iosArm64Test.dependsOn(this)
            iosSimulatorArm64Test.dependsOn(this)
        }
    }
}
sqldelight{
    databases{
        create("Database"){
            packageName.set("app.trian.sqldelight")
        }
    }
}

android {
    namespace = "app.trian.learnkmm"
    compileSdk = 33
    defaultConfig {
        minSdk = 24
        targetSdk = 33
    }
}
dependencies {
    implementation("androidx.core:core-ktx:+")
}
