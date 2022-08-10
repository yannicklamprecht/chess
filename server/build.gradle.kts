plugins{
    kotlin("jvm") version "1.7.10"
    kotlin("plugin.serialization") version "1.7.10"
}

val ktorVersion = "2.0.3"
val logbackVersion = "1.2.11"
repositories {
    mavenCentral()
}

dependencies{
    implementation(project(":lib"))

  implementation("io.ktor:ktor-server-core:$ktorVersion")
  implementation("io.ktor:ktor-server-netty:$ktorVersion")
  implementation("io.ktor:ktor-server-content-negotiation:$ktorVersion")
  implementation("io.ktor:ktor-serialization-kotlinx-json:$ktorVersion")
  implementation("ch.qos.logback:logback-classic:$logbackVersion")
  testImplementation("io.ktor:ktor-server-test-host:$ktorVersion")
  testImplementation("org.jetbrains.kotlin:kotlin-test-junit:1.7.10")
}
