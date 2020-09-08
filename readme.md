![Uptime Robot status](https://img.shields.io/uptimerobot/status/m783752614-ab5a9ed8f9b0e0ca7fa3564f?label=web%20api%20status)
[![](https://www.jitpack.io/v/TrueDevProfile/kinopoisk-api.svg)](https://www.jitpack.io/#TrueDevProfile/kinopoisk-api)
[![Build Status](https://travis-ci.org/TrueDevProfile/kinopoisk-api.svg?branch=master)](https://travis-ci.org/TrueDevProfile/kinopoisk-api)
<a href="https://ktlint.github.io/"><img src="https://img.shields.io/badge/code%20style-%E2%9D%A4-FF4081.svg" alt="ktlint"></a>

# Kinopoisk Api

A library for easy access to the Kinopoisk data.
 
## How to use
* Add the JitPack repository to your build file 

build.gradle 
        
      allprojects {
        repositories {
        	...
        	maven { url 'https://www.jitpack.io' }
        }
       }
        	
or pom.xml

	<repositories>
		<repository>
		    <id>jitpack.io</id>
		    <url>https://www.jitpack.io</url>
		</repository>
	</repositories>

* Add the dependency  

build.gradle

    dependencies {
    	implementation 'com.github.TrueDevProfile:kinopoisk-api:0.2.0'
    }
    	
or pom.xml   

    <dependency>
        <groupId>com.github.TrueDevProfile</groupId>
    	<artifactId>kinopoisk-api</artifactId>
    	<version>0.2.0</version>
    </dependency>	
* After that you can use library's methods. E.g. to get film by kinopoisk id:

        KinopoiskApiService kinopoiskExtApiService = new KinopoiskApiService();
        FilmExt filmInfo = kinopoiskExtApiService.getFilmInfo(1234); 


## Api methods

* `kinopoiskExtApiService.getFilmInfo(filmId)` retrieves all data about the film by id.
* `kinopoiskExtApiService.getStaffList(filmId)` retrieves data about the staff (actors, producers and so on) by film id.
* `kinopoiskExtApiService.getGallery(filmId)` retrieves gallery(posters, footage for the film and so no) by film id.
* `kinopoiskExtApiService.getKPReviews(filmId)` retrieves reviews by film id. It does not contain full review text.
* `kinopoiskExtApiService.getReviewDetail(reviewId)` retrieves review full data by particular review id.
* `kinopoiskExtApiService.getKPPeopleDetailView(peopleId)` retrieves detail info of staff person(actor, producer and so on).
* `kinopoiskExtApiService.getKPTop()` retrieves top of films according the params.
* `kinopoiskExtApiService.getKPSearchInFilms()`does a search in films by keyword.
* `kinopoiskExtApiService.getKPSearchInPeople()`does a search in people by keyword.
* `kinopoiskExtApiService.getNavigator()` does an advanced search of films by filters.
* `kinopoiskExtApiService.getDigital()` retrieves digital releases for particular month/year.

## WEB Api 

All these methods and more are available via web API https://kinopoiskapiunofficial.tech


