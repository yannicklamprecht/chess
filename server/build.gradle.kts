plugins{
    kotlin("jvm") version "1.7.10"
    kotlin("plugin.serialization") version "1.7.10"
}

repositories {
    mavenCentral()
}

dependencies{
    api(project(":lib"))
}