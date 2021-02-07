# Depot App

In this project the student will define their own project feature-set that meets criteria encompassing key areas of development skills covered within the Nanodegree:

* Application Architecture
* UI and Layout
* API Connectivity and Data Persistence
* Hardware Integration
* User-based Functionality

## What is it not? 

A UI/Material Design sample. The interface of the app was completely ignored to focus on architecture.

### Dependencies

    //Room
    implementation "androidx.room:room-runtime:$room_version"
    annotationProcessor "androidx.room:room-compiler:$room_version"
    kapt "androidx.room:room-compiler:$room_version"
    implementation "androidx.room:room-ktx:2.2.6"

    // Koin 
    implementation 'org.koin:koin-android:2.2.0'
    implementation 'org.koin:koin-android-viewmodel:2.2.0'
    implementation 'org.koin:koin-androidx-scope:2.0.1'

    //Coroutines Dependencies
    implementation "org.jetbrains.kotlinx:kotlinx-coroutines-android:1.3.7"
    implementation 'org.jetbrains.kotlinx:kotlinx-coroutines-core:1.3.7'
    implementation 'org.jetbrains.kotlinx:kotlinx-coroutines-play-services:1.2.1'

    //lifecycle
    implementation 'androidx.lifecycle:lifecycle-viewmodel-ktx:2.2.0'
    implementation 'androidx.lifecycle:lifecycle-livedata-ktx:2.2.0'
    implementation "androidx.lifecycle:lifecycle-extensions:2.2.0"
    implementation "androidx.lifecycle:lifecycle-common-java8:2.2.0"

    //Retrofit
    implementation "com.squareup.retrofit2:retrofit:2.9.0"
    implementation "com.squareup.retrofit2:converter-gson:2.9.0"
    implementation "com.squareup.retrofit2:converter-scalars:2.9.0"

    // Moshi for parsing the JSON format
    implementation "com.squareup.moshi:moshi:1.9.3"
    implementation "com.squareup.moshi:moshi-kotlin:1.9.3"
    implementation "com.squareup.retrofit2:converter-moshi:2.9.0"

    implementation 'com.android.support:multidex:1.0.3'

    implementation 'com.squareup.okhttp3:logging-interceptor:4.1.0'


## Built With

* Koin 
* Live Data 
* Coroutines 
* MVVM 
* MotionLayout
* Retrofit
* Moshi 
* Room
* Notification

To build this project the polygon API is used, which can be found here: 
https://polygon.io/

In order to run the app, you need an API Key which is provided for you in that same link.
You just need to sign up.