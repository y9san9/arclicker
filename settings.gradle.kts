enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "arclicker"
include(":app")

val features = listOf(
    "main"
)

for (feature in features) {
    include(":feature:$feature:adapter")
    include(":feature:$feature:data")
    include(":feature:$feature:domain")
    include(":feature:$feature:ui")
}

include(":libs:stdlib-extensions")
include(":core:adapter")
include(":core:ui")
include(":core:domain")
