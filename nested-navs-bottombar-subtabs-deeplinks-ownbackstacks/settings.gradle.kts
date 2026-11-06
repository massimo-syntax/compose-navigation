pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "1.0.0"
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "NestedNavigationSubtabDeeplinks"
include(":app")
include(":data")
include(":navigation")
include(":feature-login:api")
include(":feature-login:impl")
include(":feature-home:api")
include(":feature-home:impl")
include(":feature-feed:api")
include(":feature-feed:impl")
include(":feature-profile:api")
include(":feature-profile:impl")
include(":feature-detail:api")
include(":feature-detail:impl")
