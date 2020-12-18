![Uptime Robot status](https://img.shields.io/uptimerobot/status/m783752614-ab5a9ed8f9b0e0ca7fa3564f?label=web%20api%20status)
[![](https://www.jitpack.io/v/TrueDevProfile/kinopoisk-api.svg)](https://www.jitpack.io/#TrueDevProfile/kinopoisk-api)
[![Build Status](https://travis-ci.org/TrueDevProfile/kinopoisk-api.svg?branch=master)](https://travis-ci.org/TrueDevProfile/kinopoisk-api)
<a href="https://ktlint.github.io/"><img src="https://img.shields.io/badge/code%20style-%E2%9D%A4-FF4081.svg" alt="ktlint"></a>

# Kinopoisk Api

A library for easy access to the Kinopoisk data.

## Installation

* Add the JitPack repository to your build file

build.gradle

```groovy
  allprojects {
    repositories {
        maven { url 'https://www.jitpack.io' }
    }
}
``` 

or pom.xml

```xml

<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://www.jitpack.io</url>
    </ repository>
</ repositories>
```

* Add the dependency

build.gradle

```groovy
 dependencies {
    implementation 'com.github.TrueDevProfile:kinopoisk-api:0.2.0'
}
```

or pom.xml

```xml

<dependency>
    <groupId>com.github.TrueDevProfile</groupId>
    <artifactId>kinopoisk-api</artifactId>
    <version>0.2.0</ version>
</dependency>
```

## How to use

You should sign up and get an access token here https://kinopoiskapiunofficial.tech/. Then you can use token to use api:

* Kotlin

```kotlin
val kinopoiskApiService = KinopoiskApiService("api token")
val result = kinopoiskApiService.getFilm(301)
when (result) {
    is Result.Success -> result.getOrNull() /*actually null is possible only for Failure*/
    is Result.Failure -> /*handle somehow*/
}
```

or

```kotlin
val kinopoiskApiService = KinopoiskApiService("api token")
val result = kinopoiskApiService.getFilm(301).getOrNull()
```

* Java

```java
KinopoiskApiService kinopoiskApiService=new KinopoiskApiService("api token",15000);
Film film=kinopoiskApiService.getFilm(301,new ArrayList<>()).getOrNull();
```
