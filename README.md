Intersect Project

Project:
  It reads from a specified JSON file rectangles. The rectangle numbers are defined by a MAX value.
  Then it returns two different list:
    1, contains every *valid rectangle
    2, contains every *valid intersections

(*valid: width and height of rectangle is positive integer, this rectangle can be placed to 2d integer coordinate table)


Rules:
  - Must not contain duplicated rectangles intersection values.
  - Must be able to list all intersections of two or more rectangles


Technical details:
  It is developed under JAVA 1.8.0.201 version.
  Using Gradle building tool.
  Following tool kits are built:
    -junit 4.12
    -com.googlecode.json-simple 1.1.1

As the build.gradle file is committed you can find the dependencies of them.
  (link: https://github.com/kliba/intersect/blob/master/build.gradle)

The entry point locates in the Main.class so it can be executed from:
  (path: ./intersect/src/main/java/Main.java)

Idea:
  This project created to list the rectangles intersection. The project uses packages so the structure allows to
  implement another plane figures intersections (e.g: triangle, circle, lozenge etc...) function.

If you like this feel free to use it. No license agreement required.