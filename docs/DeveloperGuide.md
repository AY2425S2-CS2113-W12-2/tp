# Developer Guide

## Acknowledgements

{list here sources of all reused/adapted ideas, code, documentation, and third-party libraries -- include links to the original source as well}

## Design & implementation

{Describe the design and implementation of the product. Use UML diagrams and short code snippets where applicable.}
### Canteen Finder Feature 
The canteen finder feature allows the user to find the nearest canteen relative to where the user is in NUS.
This functionality is controlled by the `CanteenFinder` class where it calls `findNearestCanteen(userLocation, canteenCriteria)`, 
a class level method, of the `CanteenFinderParser` class. `findNearestCanteen()` would then call a helper 
method to search the collection of landmark objects to find the landmark that corresponds to `userLocation`. Once the landmark is found,
`findNearestCanteen()` will then call `getNearestCanteen(canteenCriteria)` of landmark to get the nearest canteen that fits the criteria
stated by the user listed in `canteenCriteria`. Once retrieved, `getNearestCanteen()` would also call a helper method 
`getCanteenDistance(nearestCanteen)` to retrieve the distance of the canteen to the landmark where the user is located.
`getNearestCanteen()` would then return the object `nearestCanteenData` of the Record `NearestCanteenData` which stores the three attributes: 
`nearestCanteen`, `landmarkToCanteenDist` and `validStalls`. `nearestCanteenData` is then return back to `CanteenFinder` which will print
the attributes to the user.

The following UML Sequence diagram shows the Canteen Finder Feature. The starting arrow indicates `Navi`, the main program, calling the class
level method `startCanteenFinder()` of `CanteenFinder` to begin the canteen finding process.

![CanteenFinderDiagram.drawio.png](diagrams/CanteenFinderDiagram.drawio.png)

### Favorites feature 
Favorites Feature
The favorites feature provides users with a system to manage their preferred items through a centralized `Favorites` 
class. This class maintains two core data structures - an ArrayList called `favoriteItems` that stores all favorite 
entries in a formatted string representation, and a Stack called `undoStack` that tracks recently deleted items to 
support undo functionality.

When adding new favorites, the `addFavorite` method accepts three parameters - description, rating, and category. 
These components are combined into a standardized string format "Description | Rating: X | Category: Y" which 
gets added to the `favoriteItems` collection. The method provides immediate visual feedback through console output to
confirm the successful addition.

For removal operations, the `removeFavorite` method first validates the provided index against the current list 
bounds. If valid, it extracts the target item from `favoriteItems`, pushes it onto the undoStack for potential recovery, 
and displays a removal confirmation message. Invalid indices trigger an appropriate warning message.

The `undoRemove` functionality checks the undoStack for available operations. When items exist in the stack, it pops the 
most recent deletion and restores it to `favoriteItems` while providing visual confirmation. If the stack is empty, it 
informs the user that no undo operations are available.

The `viewFavorites` method handles display operations by first checking if `favoriteItems` is empty. When populated, it 
presents all items in a clean numbered list format, while empty states trigger a "No favorites yet" message. This 
ensures users always receive appropriate feedback.

Advanced operations include the `sortFavorites` method which implements rating-based sorting through a custom 
Comparator. The method parses the rating values from the stored strings, performs the sort in either ascending
or descending order based on the boolean parameter, and confirms completion to the user. The `searchFavorites` method 
provides case-insensitive keyword matching across all favorite entries, displaying matches or notifying the user 
when no results are found.

The system architecture emphasizes simplicity through in-memory storage using formatted strings, though this 
requires parsing operations for certain features. The undo functionality currently supports single-level undo
for deletions only. All operations provide immediate visual feedback through the console interface. Future extensions
could introduce persistent storage, enhanced search capabilities, additional sorting criteria, and more comprehensive 
undo/redo functionality while maintaining the current straightforward user interaction model.

The following UML Sequence diagram illustrates the core favorite management workflow. The starting arrow indicates the 
main program initializing the Favorites feature through its constructor.

![Favorites Sequence Diagram](../uml/fav.png)



### Storage feature
The Storage class is responsible for managing the persistent storage of canteen, faculty, hostel, and other building data. 
The data loading process is initiated by calling processDataFromFiles(), which sequentially processes different 
categories of data from files into appropriate data structures.

The method follows these key steps:
It first clears CANTEEN_MAP, a static Map<String, Canteen>, to ensure that previously loaded data does not persist.
It then sequentially calls:
processCanteenFromFile() to read and parse canteen data, creating Canteen objects and storing them in CANTEEN_MAP.
processFacultyFromFile() to process faculty data, creating Faculty objects and updating CanteenFinderParser.LANDMARKS.
processHostelFromFile() to handle hostel data, creating Landmark objects for hostels.
processOtherBuildingFromFile() to process other buildings, creating Landmark objects accordingly.

Once all data is processed, CanteenFinderParser.LANDMARKS is populated with the loaded objects. This enables the 
CanteenFinder feature to determine the nearest canteens relative to various landmarks.

In case of missing or inaccessible files, processDataFromFiles() throws a FileNotFoundException and logs errors to 
System.err.

The following UML Sequence Diagram illustrates the interaction between different components during data loading. 
It shows Navi, the main program, invoking processDataFromFiles() in the Storage class, which in turn delegates the 
processing of specific data types to CanteenDataProcessor, FacultyDataProcessor, HostelDataProcessor, and 
OtherBuildingDataProcessor. These processors create appropriate objects (Canteen, Faculty, Landmark) and establish 
relationships such as nearest canteens and distances between entities.

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










































## Budget feature
This feature allows users to track their daily, weekly and monthly expenses on food as well as the weekly budget.
* Budget class: Handles core budget logic, including managing expenses, budget resets, and file persistence.
* BudgetParser class: Handles user interaction and command parsing
* Data storage: Data Storage - Budget data is stored persistently in a JSON-like format.

#### Core Logic
The Budget class maintains several key pieces of data:
* weeklyBudget: Current available budget
* dailyExpenses, weeklyExpenses, monthlyExpenses: Tracked expenses
* lastUpdatedDate: Ensures proper period resets


Key operations include:

1. addWeeklyBudget(): Adds to current weekly budget
2. deductExpense(): Records and deducts expenses
3. viewExpenses():  Displays the remaining weekly budget and total monthly spending.
4. resetIfNeeded(): Checks and performs periodic resets
* *Daily Reset*: Resets daily expenses at midnight.
* *Weekly Reset*: Resets weekly expenses every Monday. 
* *Monthly Reset*: Resets total monthly expenses at the start of a new month.
