Twitter bot made in Java
======================================
Simple Twitter bot for my Java course. Responds to commands sent to him.
Supported commands:

`!help - prints short help message`

`!d domain - returns web server version of domain if any`

`!w city - returns current weather in "city"`

Install
-------
* Import project into your IntelliJ IDEA and use Maven to download dependencies (gson and twitter4j).
* You might need to register for OpenWeatheMap api key or you can just reuse mine, since its free to use anyways :)

Config
------
* Create file [twitter4j.properties](http://twitter4j.org/en/configuration.html) containing your apikeys, and put it into projects root directory.

License
-------
This plugin is released under the MIT license.
