# Developer Guide

## Acknowledgements

{list here sources of all reused/adapted ideas, code, documentation, and third-party libraries -- include links to the original source as well}

## Design & implementation

{Describe the design and implementation of the product. Use UML diagrams and short code snippets where applicable.}


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
