DCGen - Dynamic Content Generator
======

Implementation of the text content generator that accepts content templates and translates them into the result content. Templates contains the text that should be generated and specific blocks with user scripts. Script blocks drives the generating of the result content. Script blocks are determined with the starting sequence of some characters eg. <?, <%, <: and with the ending sequence eg. ?>, %>, :>. But it is easy to define the custom way how to recognize the script blocks inside templates. So one could define for the starting sequence the $ and as the closing character the empty space ' '. This specification might be used for the outputing the the script or model variables.

## Features
- Easy to insert the custom script engine which you like and which will be used for the generating of the result content. All what is neccesary is that engine has to implement the JSR 223 interface.
- Customizing the marks for including the script blocks.
- Thanks to JSR 223 it is easy to insert model object that might be used in the transformation process.
- For security reasons use [jsen-core](https://github.com/ITman1/jsen-core) and [jsen-js](https://github.com/ITman1/jsen-js) where you can strictly define exactly what you want to export to the script engine.


## Building library

### Requirements

1. Have installed JDK 1.6 or newer - JDK 1.8 is recommended
2. Have installed [Maven build manager](http://maven.apache.org/download.cgi#Installation_Instructions)
3. Have set system variable `JAVA_HOME` to directory with installed JDK and have its binary directory
  in the system variable `PATH` - e.g. on Windows add to `PATH` variable `%JAVA_HOME%\bin` (more [here](http://maven.apache.org/download.cgi))
4. Have in the system variable `PATH` the directory with Maven installation

### Building

Simply run command: `mvn package`

## Using the library

### Using Maven
```
<dependency>
	<groupId>com.jsen</groupId>
	<artifactId>dcgen</artifactId>
	<version>0.0.1</version>
</dependency>
```
### Custom way

Have built library (see previous section) and have it specified on classpath

# Known issues

If you run into any bug, please report on:  
   https://github.com/ITman1/dcgen/issues

## Contact and credits
                             
**Author:**    Radim Loskot  
**gmail.com:** radim.loskot (e-mail)

Please feel free to contact me if you have any questions.
