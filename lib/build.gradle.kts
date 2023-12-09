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

tasks.jar {
    manifest {
        attributes(mapOf("Implementation-Title" to project.name,
                         "Implementation-Version" to project.version))
    }
}
