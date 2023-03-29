plugins {
    id("cobblemon.platform-conventions")
    id("cobblemon.publish-conventions")
}

architectury {
    platformSetupLoomIde()
    forge()
}

repositories {
    maven(url = "https://thedarkcolour.github.io/KotlinForForge/")
    mavenLocal()
    maven {
        url = uri("https://cursemaven.com")
        content {
            includeGroup("curse.maven")
        }
    }
}

dependencies {
    forge(libs.forge)
    modApi(libs.architecturyForge)

    implementation(project(":common", configuration = "namedElements")) {
        isTransitive = false
    }
    implementation(libs.kotlinForForge)
    "developmentForge"(project(":common", configuration = "namedElements")) {
        isTransitive = false
    }
    bundle(project(path = ":common", configuration = "transformProductionForge")) {
        isTransitive = false
    }
    testImplementation(project(":common", configuration = "namedElements"))

    modApi(libs.cobblemonForge) {
        exclude(group = "net.minecraftforge")
    }

    listOf(
        libs.stdlib,
        libs.serializationCore,
        libs.serializationJson,
        libs.reflect
    ).forEach(::forgeRuntimeLibrary)
}

tasks {
    shadowJar {
        exclude("architectury-common.accessWidener")
        relocate ("com.ibm.icu", "com.cobblemon.mod.relocations.ibm.icu")
    }

    processResources {
        inputs.property("version", rootProject.version)

        filesMatching("META-INF/mods.toml") {
            expand("version" to rootProject.version)
        }
    }
}