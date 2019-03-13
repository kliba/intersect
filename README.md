Multiple Intersects

Project:
It is a simple console program. Reads rectangle parameters (xy coordinates and height width)
from a defined JSON array. After a JSON file validation there are two lists outputted:
1, all rectangles
2, all intersections (single intersections and multiple intersections

Rules:
- Must able to process max 10 valid rectangles.
- Must not contain duplicated rectangles intersection values.
- Must be able to list all intersections of two or more rectangles

Technical details:
It is developed under JAVA 1.8.0.201 version.
Using Gradle building tool.
Following tool kits are built:
junit 4.12
com.googlecode.json-simple 1.1.1

As the build.gradle file is committed you can find the dependencies of them.
(link: https://github.com/kliba/intersect/blob/master/build.gradle)

The entry point locates in the Main.class so it can be executed from:
./intersect/src/main/java/Main.java

Idea:
This project created to list the rectangles intersection. The project uses packages so the structure allows to
implement another plane figures intersections (e.g: triangle, circle, lozenge etc...) function.

If you like this feel free to use it. No license agreement necessary.