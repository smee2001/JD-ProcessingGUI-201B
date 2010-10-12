#!/bin/bash
CLASSPATH='-cp .:src/:lib/core.jar:lib/controlP5.jar:lib/jmcvideo.jar:lib/jmc.jar'
javac $CLASSPATH src/*.java
java $CLASSPATH -Djava.library.path=lib MyVideoGUI

