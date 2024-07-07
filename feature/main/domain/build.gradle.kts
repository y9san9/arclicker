@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    alias(libs.plugins.kotlin.multiplatform)
}

kotlin {
    jvm()
}

dependencies {
    commonMainImplementation(libs.coroutines.core)
    commonMainImplementation(project(":feature:main:types"))
    commonMainImplementation(project(":libs:stdlib-extensions"))
}
