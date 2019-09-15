[![](https://www.jitpack.io/v/TrueDevProfile/kinopoisk-api.svg)](https://www.jitpack.io/#TrueDevProfile/kinopoisk-api)
[![Build Status](https://travis-ci.org/TrueDevProfile/kinopoisk-api.svg?branch=master)](https://travis-ci.org/TrueDevProfile/kinopoisk-api)


# Kinopoisk Api

Library for simply accessing to the kinopoisk api. This library uses an unofficial way, pretending to be an android device.
 
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
    	implementation 'com.github.TrueDevProfile:kinopoisk-api:0.0.3'
    }
    	
or pom.xml   

    <dependency>
        <groupId>com.github.TrueDevProfile</groupId>
    	<artifactId>kinopoisk-api</artifactId>
    	<version>0.0.3</version>
    </dependency>	
* Now you can use api. E.g. you can get film info by id 

        KinopoiskApiService kinopoiskExtApiService = new KinopoiskApiService();
        FilmExt filmInfo = kinopoiskExtApiService.getFilmInfo(1234); 


## Api methods

* `kinopoiskExtApiService.getFilmInfo(filmId)` retrieves all data about the film by id.
* `kinopoiskExtApiService.getStaffList(filmId)` retrieves data about the staff (actors,producers and so on) by film id.
* `kinopoiskExtApiService.getGallery(filmId)` retrieves gallery according to film id.
* `kinopoiskExtApiService.getKPReviews(filmId)` retrieves reviews by film id. It does not contain full review text.
* `kinopoiskExtApiService.getKPPeopleDetailView(peopleId)` retrieves detail info of staff person(actor, producer and so on).
* `kinopoiskExtApiService.getKPTop()` retrieves top of films according the params.
* `kinopoiskExtApiService.getKPSearchInFilms()`does a search in films by keyword.
* `kinopoiskExtApiService.getKPSearchInPeople()`does a search in people by keyword.


