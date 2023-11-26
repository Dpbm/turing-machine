plugins {
    `java-library`
    `maven-publish`
    signing
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("junit:junit:4.13.2")
    api("org.apache.commons:commons-math3:3.6.1")
    implementation("com.google.guava:guava:32.1.1-jre")
}

java {
    withJavadocJar()
    withSourcesJar()
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(8))
    }
}


group="io.github.Dpbm"
version="1.0"

publishing {
    publications {
        create<MavenPublication>("turing-machine") {
            artifactId="turing-machine"

            from(components["java"])

            versionMapping {
                usage("java-api") {
                    fromResolutionOf("runtimeClasspath")
                }
                usage("java-runtime") {
                    fromResolutionResult()
                }
            }

            pom {
                groupId="io.github.Dpbm"
                name = "Turing machine"
                description = "A turing machine automaton based library for studies."
                url = "https://github.com/Dpbm/turing-machine"
                version="1.0"
                licenses {
                    license {
                        name = "MIT License"
                        url = "http://www.opensource.org/licenses/mit-license.php"
                    }
                }
                developers {
                    developer {
                        id = "Dpbm"
                        name = "Alexandre Silva"
                        email = "dpbm136@gmail.com"
                    }
                }
                scm {
                    connection = "scm:git:git://github.com/Dpbm/turing-machine.git"
                    developerConnection = "scm:git:ssh://github.com:Dpbm/turing-machine.git"
                    url = "https://github.com/Dpbm/turing-machine/"
                }
            }
        }
    }
    
    repositories{
        maven {
            name = "Sonatype"
            val releasesRepoUrl = uri("https://s01.oss.sonatype.org/service/local/staging/deploy/maven2/")
            val snapshotsRepoUrl = uri("https://s01.oss.sonatype.org/content/repositories/snapshots/")
            url = if (version.toString().endsWith("SNAPSHOT")) snapshotsRepoUrl else releasesRepoUrl
            credentials {
                username = System.getenv("OSSRH_USERNAME")
                password = System.getenv("OSSRH_TOKEN")
            }
        }

        maven {
            name = "GitHubPackages"
            url = uri("https://maven.pkg.github.com/Dpbm/turing-machine")
            credentials {
                username = project.findProperty("gpr.user") as String? ?: System.getenv("GH_USERNAME")
                password = project.findProperty("gpr.key") as String? ?: System.getenv("GH_TOKEN")
            }
        }
    }
}

signing {
    sign(publishing.publications["turing-machine"])
}

tasks.javadoc {
    if (JavaVersion.current().isJava9Compatible) {
        (options as StandardJavadocDocletOptions).addBooleanOption("html5", true)
    }
}

tasks.jar {
    manifest {
        attributes(mapOf("Implementation-Title" to project.name,
                         "Implementation-Version" to project.version))
    }
}
