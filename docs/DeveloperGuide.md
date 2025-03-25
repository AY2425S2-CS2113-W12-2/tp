# Developer Guide

## Acknowledgements

{list here sources of all reused/adapted ideas, code, documentation, and third-party libraries -- include links to the original source as well}

## Design & implementation

{Describe the design and implementation of the product. Use UML diagrams and short code snippets where applicable.}
### Canteen Finder Feature 
The canteen finder feature allows the user to find the nearest canteen relative to where the user is in NUS.
This functionality is controlled by the `CanteenFinder` class where it calls `findNearestCanteen(userLocation, dietRestrictions)`, 
a class level method, of the `CanteenFinderParser` class. `findNearestCanteen()` would then call a helper 
method to search the collection of landmark objects to find the landmark that corresponds to `userLocation`. Once the landmark is found,
`findNearestCanteen()` will then call `getNearestCanteen(dietRestrictions)` of landmark to get the nearest canteen that fits the criteria
stated by the user listed in `dietRestrictions`. Once retrieved, `getNearestCanteen()` would also call a helper method 
`getCanteenDistance(nearestCanteen)` to retrieve the distance of the canteen to the landmark where the user is located.
`getNearestCanteen()` would then return the object `nearestCanteenData` of the Record `NearestCanteenData` which stores the three attributes: 
`nearestCanteen`, `landmarkToCanteenDist` and `validStalls`. `nearestCanteenData` is then return back to `CanteenFinder` which will print
the attributes to the user.

The following UML Sequence diagram shows the Canteen Finder Feature. The starting arrow indicates `Navi`, the main program, calling the class
level method `startCanteenFinder()` of `CanteenFinder` to begin the canteen finding process.

![CanteenFinderDiagram.drawio.png](diagrams/CanteenFinderDiagram.drawio.png)

### Storage feature
The Storage class handles the persistent storage of canteen, faculty, hostel, and other building data. 
This functionality is managed through the Storage class, which calls processDataFromFiles() to load data from various 
files into appropriate data structures. `processDataFromFiles()` first clears the CANTEEN_MAP, which is a 
static Map<String, Canteen>, and then sequentially calls methods to process data from the files: `processCanteenFromFile()`,
`processFacultyFromFile()`, `processHostelFromFile()`, and `processOtherBuildingFromFile()`. Each of these methods reads the 
respective file and parses the data to create objects such as Canteen, Faculty, Landmark, and stores them in the CANTEEN_MAP 
and `CanteenFinderParser.LANDMARKS`. Once all the data has been processed, `processDataFromFiles()` ensures that
`CanteenFinderParser.LANDMARKS` is populated with the loaded objects. This list is used by the CanteenFinder feature to 
determine the nearest canteen relative to the location of various landmarks. In case of errors, such as missing files, 
the method throws a FileNotFoundException and prints appropriate error messages to System.err.

The following UML Sequence diagram shows the process of loading data from files in the Storage class. 
The first arrow represents Navi, the main program, calling the class-level method processDataFromFiles() of the 
Storage class to begin loading data into the application.

![](diagrams/StorageRefactored.png)


## Product scope
### Target user profile

{Describe the target user profile}

### Value proposition

{Describe the value proposition: what problem does it solve?}

## User Stories

|Version| As a ... | I want to ... | So that I can ...|
|--------|----------|---------------|------------------|
|v1.0|new user|see usage instructions|refer to them when I forget how to use the application|
|v2.0|user|find a to-do item by name|locate a to-do without having to go through the entire list|

## Non-Functional Requirements

{Give non-functional requirements}

## Glossary

* *glossary item* - Definition

## Instructions for manual testing

{Give instructions on how to do a manual product testing e.g., how to load sample data to be used for testing}
