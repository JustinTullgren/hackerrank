plugins {
    java
    application
    kotlin("jvm")
}

application {
    mainClassName = "com.justintullgren.hackerrank.crackingthecodinginterview.Main"
}

dependencies {
    compile(kotlin("stdlib"))
    testCompile("junit:junit:4.4")
    testCompile("org.assertj:assertj-core:3.11.1")
}