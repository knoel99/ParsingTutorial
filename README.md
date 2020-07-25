# Your first Java 8/Maven tutorial to become a big data engineer
## To whom is this tutorial
This project was my first tutorial in my journey to become a big data engineer. I learnt a lot doing it, 
so I thought why not sharing it with others who also want to become a big data developer.

To do this tutorial you should have the basics in programming (basic types, loop, etc.) and
 in object-oriented programming in Java (class, methods).
 If not I recommend you to check those resources out:
 - https://www.w3schools.com/java/default.asp (in english)
 - https://www.youtube.com/playlist?list=PLMS9Cy4Enq5LKYxJmD1ZIu3C7f3vA00hM (in french)
 
 This tutorial will not show you how to write every single line of the project but rather lead you to write
 your own version of the project throughout a structured list of instructions/questions. The best way to learn is by doing :)
 
 If you find any error, or have any suggestion or piece of advice, don't hesitate to drop me a message or 
 a pull request :)

## What you will learn
- What is maven
- Discover/use IntelliJ
- Parse a JSON and a XML file
- Apply some stats on the data parsed from those files
- Use Stream APIs and see how they can avoid you to use big and ugly loops


## Setting up
#### Install Java
- Which version did you choose? Why?
- What is the difference between the JDK and the JRE?

http://www.oracle.com/technetwork/java/javase/downloads/index.html

Some other Java tutorials:  
https://www.tutorialspoint.com/java/ 
https://openclassrooms.com/courses/apprenez-a-programmer-en-java 
http://www.jmdoudoux.fr/java/dej/chap-preambule.htm 

#### Install Maven
- What is maven
- What is it used for?

https://maven.apache.org/download.cgi 

Some Maven tutorials : 

https://maven.apache.org/guides/getting-started/maven-in-five-minutes.html 
https://www.jmdoudoux.fr/java/dej/chap-maven.htm  
http://matthieu-lux.developpez.com/tutoriels/java/maven/0.2/ 


#### Install an IDE: IntelliJ
- What is an IDE?
- How to configure a proxy on IntelliJ?
- How to install plugins? Install Scala plugin (for the next tutorial)

https://www.jetbrains.com/idea/ 

You can also use Eclipse, but IntelliJ is the most advanced Java IDE in my honest opinion.

#### Install a version control system: Git
- What is Git?
- What is it used for?
- What is GitHub? What is GitLab?
- What is a README.md, a CONTRIBUTING.md?

https://git-scm.com/ 

Git workflow: http://nvie.com/posts/a-successful-git-branching-model/ 

Markdown Language : https://guides.github.com/features/mastering-markdown/ 


## Part 1

- Creating a Java 8/Maven project using IntelliJ 
- The purpose is to parse a JSON file and an XML file (from 
https://github.com/knoel99/ParsingTutorial/tree/master/src/main/resources) and do simple calculations on the recovered data.
Part 1

Take the JSON file: liste_noms_age.json

The purpose of the program will be to read the JSON file and display an answer to the following questions:
- Who is the youngest? Who is the oldest? 
- What is the longest name? The shortest? 
- What is the average age?
- What is the greatest age difference between two successive people?

Tips:
- Write a Java class with a function that takes as input a path to a file and returns the content 
of the file in a String (usable in part 2)
- Write a Java class with a function that takes an entry from a String (which is actually a JSON) and 
parses the JSON to make "readable and exploitable" objects.
- Write a class with a method that performs the treatment(s)
- Preferably use JsonPath (it is possible to use another easy-to-use parser)
- Learn more about the JsonPath API, Sample doc: https://github.com/json-path/JsonPath

## Part 2
Do the same with the XML file: liste_nom_ages.xml
Hey hey, the ages have changed or it's not funny :D

Tricks:
- Same tricks as above (XPath instead of JsonPath)
- Learn more about the XPath API, example in the doc: https://openclassrooms.com/courses/java-et-le-xml/utiliser-xpath

## Part 3
Now, you have to: 
- Add some external configuration (i.e. the values that were hard-coded in the java code 
must be in an external file, usually named application.properties or application.conf 
that must be placed in src/main/resources, and are called from the program)
- Add loggers (it's prettier than println), so you have to inquire about Slf4j and Log4j.