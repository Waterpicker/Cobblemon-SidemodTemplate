plugins {
    id("cobblemon.base-conventions")
    id("cobblemon.publish-conventions")
}

architectury {
    common()
}

dependencies {
    implementation(libs.stdlib)
    implementation(libs.reflect)

    modImplementation(libs.fabricLoader)
    modApi(libs.cobblemonMod)
    modApi(libs.architectury)
}

tasks.withType<Test> {
    useJUnitPlatform()
}
