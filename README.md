# SGMobileDataUsage
This application is to display the amount of the data sent over Singapore's mobile networks from
2010 to 2021

## Overview
- Language: Kotlin
- Supported API level: 24+
- Application ID: com.sg.mytest.sgmobiledatausage
- Localised Language: English
- Github: https://github.com/NweThazin/SGMobileDataUsage.git

#### Third Party Libraries
Third parties libraries can be found in app/build.gradle file. Some libraries and tools we use are

- [Retrofit](https://github.com/square/retrofit) & [Okhttp](https://github.com/square/okhttp) for
  networking calls. Currently we are using Retrofit 2.1
- [Dagger](https://github.com/google/dagger) for dependency injection
- [Timber](https://github.com/JakeWharton/timber) for logging
- [Room](https://developer.android.com/topic/libraries/architecture/room) is used as the database.
  Please see SGMobileUsageDatabase class for details.
- [Gson](https://github.com/google/gson) or parsing JSON to Java Object
- Other more dependencies can be found at dependencies block of app/build.gradle.