@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    alias(libs.plugins.kotlin.multiplatform)
}

kotlin {
    jvm()
    jvmToolchain(8)
}

dependencies {
    commonMainApi(libs.coroutines.core)
    commonMainApi(projects.libs.stdlibExtensions)
}
