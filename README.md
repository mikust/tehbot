Twitter bot made in Java
======================================
Simple Twitter bot for my Java course. Responds to commands sent to him.
Just tweet him a city name and you will get response with current weather data there.

This is a sample reply

City: London
Weather: shower rain
Temperature: 10.49
Wind speed: 8.2⇙
Sunrise: 09:31
Sunset: 18:01

Install
-------
* Import project into your IntelliJ IDEA and use Maven to download dependencies (gson and twitter4j).
* You might need to register for OpenWeatheMap api key or you can just reuse mine, since its free to use anyways :)

Config
------
* Create file [twitter4j.properties](http://twitter4j.org/en/configuration.html) containing your apikeys, and put it into projects root directory.

License
-------
This code is released under the MIT license.