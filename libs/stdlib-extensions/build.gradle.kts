@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    alias(libs.plugins.kotlin.multiplatform)
}

kotlin {
    jvmToolchain(8)
    jvm()
}

dependencies {
    commonMainImplementation(libs.coroutines.core)
}
