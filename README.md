<h1>Intersect Project</h1>

<h2>Project</h2>
<p>It reads from a specified JSON file rectangles. The rectangle numbers are defined by a MAX value.
  Then it returns two different list:</p>
  <ol>
    <li>contains every *valid rectangle</li>
    <li>contains every *valid intersections</li>
  </ol>

<i>*valid: width and height of rectangle is positive integer, this rectangle can be placed to 2d integer coordinate table</i>


<h3>Rules</h3>
<ul>
  <li>Must not contain duplicated rectangles intersection values.</li>
  <li>Must be able to list all intersections of two or more rectangles</li>
</ul>

<h3>Technical details</h3>
  <p>It is developed under JAVA 1.8.0.201 version.<br>
  Using Gradle building tool.<br>
  Following tool kits are built:</p>
  <ul>
    <li>junit 4.12</li>
    <li>com.googlecode.json-simple 1.1.1</li>
  </ul>

<p>As the build.gradle file is committed you can find the dependencies of them.
  <a href="https://github.com/kliba/intersect/blob/master/build.gradle">build.gradle</a></p>

<p>The entry point locates in the Main.class so it can be executed from:<br>
  <i>(path: ./intersect/src/main/java/Main.java)<i></p>

<p>jUnit test files location:<br>
<ul>
<li><a href="https://github.com/kliba/intersect/blob/master/src/test/java/test_readerer_of_JSON/TestJSONToRectangles.java">TestJSONToRectangles</a></li>
<li><a href="https://github.com/kliba/intersect/blob/master/src/test/java/test_intersectings/TestIntersectedRectangles.java">TestIntersectedRectangles</a></li>
</ul></p>


<h4>Idea</h4>
 <p> This project created to list the rectangles intersection. The project uses packages so the structure allows to
  implement another plane figures intersection (e.g: triangle, circle, lozenge etc...) functions. </p>

<p>If you like this feel free to use it. No license agreement required.</p>