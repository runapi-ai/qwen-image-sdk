plugins {
  `java-library`
  `maven-publish`
}

extra["runapiSlug"] = "qwen-image"

description = "RunAPI Qwen Image Java SDK for Qwen Image workflows."

java {
  withSourcesJar()
  withJavadocJar()
}

dependencies {
  api("ai.runapi:runapi-core:0.2.9")

  testImplementation(platform("org.junit:junit-bom:5.10.3"))
  testImplementation("org.junit.jupiter:junit-jupiter")
}

publishing {
  publications {
    create<MavenPublication>("mavenJava") {
      from(components["java"])
      artifactId = "runapi-qwen-image"
      pom {
        name = "RunAPI Qwen Image Java SDK"
        description = "RunAPI Qwen Image Java SDK for Qwen Image workflows."
        url = "https://runapi.ai/models/qwen-image"
        licenses {
          license {
            name = "Apache License, Version 2.0"
            url = "https://www.apache.org/licenses/LICENSE-2.0"
          }
        }
        developers {
          developer {
            id = "runapi"
            name = "RunAPI"
            email = "contact@runapi.ai"
          }
        }
        scm {
          url = "https://github.com/runapi-ai/qwen-image-sdk"
          connection = "scm:git:https://github.com/runapi-ai/qwen-image-sdk.git"
          developerConnection = "scm:git:ssh://git@github.com/runapi-ai/qwen-image-sdk.git"
        }
      }
    }
  }
}
