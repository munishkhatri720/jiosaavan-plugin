plugins {
    `java-library`
//    `maven-publish`
}

project.group = "com.github.appujet"
project.version = "0.0.1"
val archivesBaseName = "jiosavvan"

dependencies {
    compileOnly(libs.lavaplayer)

    implementation(libs.logger)
    implementation(libs.commonsIo)
    implementation(libs.jsoup)
    implementation(libs.findbugs)

    testImplementation(libs.lavaplayer)
    testImplementation(libs.logger.impl)
}

configure<JavaPluginExtension> {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

val jar: Jar by tasks
val build: Task by tasks
val clean: Task by tasks
//val publish: Task by tasks

val sourcesJar = task<Jar>("sourcesJar") {
    archiveClassifier.set("sources")
    from(sourceSets["main"].allJava)
}

build.apply {
//    dependsOn(clean)
    dependsOn(jar)
    dependsOn(sourcesJar)

    jar.mustRunAfter(clean)
    sourcesJar.mustRunAfter(jar)
}

//publishing {
//    repositories {
//        maven {
//            name = "duncte123-m2"
//            url = uri("https://m2.duncte123.dev/releases")
//            credentials {
//                username = System.getenv("DUNCTE_USERNAME")
//                password = System.getenv("DUNCTE_PASSWORD")
//            }
//            authentication {
//                create<BasicAuthentication>("basic")
//            }
//        }
//    }
//    publications {
//        register<MavenPublication>("duncte123-m2") {
//            pom {
//                name.set(archivesBaseName)
//                description.set("Source managers for skybot")
//                url.set("https://github.com/DuncteBot/skybot-source-managers")
//                licenses {
//                    license {
//                        name.set("Apache-2.0")
//                        url.set("https://www.apache.org/licenses/LICENSE-2.0")
//                    }
//                }
//                developers {
//                    developer {
//                        id.set("duncte123")
//                        name.set("Duncan Sterken")
//                        email.set("contact@duncte123.me")
//                    }
//                }
//                scm {
//                    connection.set("scm:git:git://github.com/DuncteBot/skybot-source-managers.git")
//                    developerConnection.set("scm:git:ssh://git@github.com:DuncteBot/skybot-source-managers.git")
//                    url.set("https://github.com/DuncteBot/skybot-source-managers")
//                }
//            }
//
//            from(components["java"])
//
//            artifactId = archivesBaseName
//            groupId = project.group as String
//            version = project.version as String
//
//            artifact(sourcesJar)
//        }
//    }
//}

//publish.apply {
//    dependsOn(build)
//
//    onlyIf {
//        System.getenv("DUNCTE_USERNAME") != null && System.getenv("DUNCTE_PASSWORD") != null
//    }
//}
