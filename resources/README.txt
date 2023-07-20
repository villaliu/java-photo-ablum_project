# Photo Album Project

**IMPORTANT**

1. To make sure we can get the txt file, please put the input txt file in the root of the project
 (as I already did).
2. To successfully run the jar file, since my main has been compiled
by class file version 63.0, make sure your version of Java runtime has a version up to 63.0.

## Changes to the Model

I changed the way `ShapeFactory` is used to create shapes.
For the color part, instead of putting in an `IColor` object,
I choose to put in three `int`. This could help me more easily parse the file.

I also added a `getSnapshotList` method in the `PhotoAlbumBuilder` to help me
easily get every snapshot in the list. I added a `getShapes`
method in the `ISnapShot` class to help me get all the shapes
in the snapshot class. I added `getR`, `getG`, and `getB` methods
in the `IColor` to help me get them. I changed the color from `double` to `int`.

## Overall Design

For the overall design, in the `view` package, I created an `IView` interface
with two concrete classes, `WebView` and `GraphicView`.
In the `controller` package, I created a `PhotoAlbumController` interface and a concrete class.

I also have a `utilities` package with parsing tools,
snapshot creating tools, and shape creating tools.

## Special Thanks

Special thanks to my lab session TA Trang.
Thank you so much for offering me a tutor session on Sunday. I can not finish this project without
your help and encouragement.
