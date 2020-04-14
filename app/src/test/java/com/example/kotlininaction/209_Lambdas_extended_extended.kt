package com.example.kotlininaction

data class SiteVisit(
    val os: OS,
    val path: String,
    var duration: Int
)

enum class OS{ MAC, WINDOWS, LINUX, IOS, ANDROID}

val log = listOf(
    SiteVisit(OS.WINDOWS, "/", 12),
    SiteVisit(OS.ANDROID, "/login", 15),
    SiteVisit(OS.ANDROID, "/", 18),
    SiteVisit(OS.MAC, "/logout", 32),
    SiteVisit(OS.WINDOWS, "/about", 90)
)

//average duration of visits from Windows
val averageWindowsVisitingTime = log
    .filter {it.os == OS.WINDOWS}
    .map {it.duration}
    .average()

//if you need average duration of MAC visits -> enhance the function
fun averageVisitingTime(os:OS) = log
    .filter {it.os == os}
    .map(SiteVisit::duration)
    .average()

//average mobile duration
val averageMobileVisitingTime = log
    .filter {it.os in setOf(OS.IOS, OS.ANDROID)}
    .map{it.duration}
    .average()

fun averageVisitingTimeWithGenericFilter(genericFilter: (siteVisit: SiteVisit) -> Boolean) = log
    .filter(genericFilter)
    .map{it.duration}
    .count()
//    .average()


fun main() {
    println("Windows v0isiting time: $averageWindowsVisitingTime")
    println("MAC visiting time ${averageVisitingTime(OS.MAC)}")
    println("Mobile visiting time $averageMobileVisitingTime")

    println("${averageVisitingTimeWithGenericFilter { it.duration > 15 }}")
}
