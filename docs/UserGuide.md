# User Guide

## Introduction

{Give a product intro}

## Quick Start

1. Ensure that you have Java 17 or above installed.
2. Down the latest zip file of `Navi` from [here](https://github.com/AY2425S2-CS2113-W12-2/tp/releases).
3. Unzip the file and cd into that directory on your terminal.
4. Enter `java -jar Navi.jar` and enjoy the app!

___
## Starting Navi
Whenever users start Navi, they will first be greeted and then prompted to first enter their name.

Example:
`Alfred`
```
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
Welcome! I'm:
 _   _             _
| \ | | __ ___   _(_)
|  \| |/ _` \ \ / / |
| |\  | (_| |\ V /| |
|_| \_|\__,_| \_/ |_|
What’s your name?
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
Alfred
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
Hello, Alfred! Nice to meet you!
Alright, what can I do for you?
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
```
___
## Features
1. Canteen Feature
2. Budget Feature
3. Favorites Feature
___
## Canteen: `canteen`
The Canteen feature provides 2 sub-features which includes:
1. Canteen Finder 
2. Canteen Lookup

Format: `Canteen` or `c`

Example: `c`
```
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
c
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
You've entered the Canteen feature!
You can enter "finder" to look for the nearest canteen to you,
or you can enter "lookup" to see a canteen's stalls information.
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
```
___
### To enter Canteen Finder: `finder`
This sub-feature allows users to search for the nearest canteen in NUS Kent Ridge Campus 
based on user specified canteen criteria and location.

Format: `finder` or `f`

Example: `f`
```
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
f
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
So you wanna find where's the nearest canteen to you?
What kind of canteen are you looking for?
You can list out: "Halal Certified", "Muslim Owned", "Vegetarian", "Aircon"
or "NIL" if you're fine with anything!
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
```
### Canteen Finder

#### 1. Enter desired canteen criteria: `criteria`
Users can enter certain criteria to filter the search for the nearest canteen. 

These criteria include `halal certified`/`hc`, `muslim owned`/`mo`, `vegetarian`/`v` 
and `aircon`/`a`. User can enter multiple criteria at once by separating each criterion
with a `,`. 

User can also enter `nil` if they do not wish to specify any criteria.

**Tip 1:** There are very limited stalls that satisfies multiple criteria.

**Tip 2:** It is redundant to include both `halal certified` and `muslim owned` as 
if a stall is already halal, there is no nid to check if its muslim owned.

Format: `criterion 1, criterion 2`

Example: `hc, a`
```
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
hc, a
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
So you're looking for a canteen has:
halal certified, aircon stalls.
I would need to know where are you now!
You can enter either faculties, hostels or other major landmarks in NUS!
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
```
#### 2. Enter location name: `location`
After specifying the canteen criteria, users can then enter the general location
of where they are at.

We only support locations at the `faculty` and `hostel` level as well as 
other `key buildings` that don't belong to the two categories above.

Format: `location`

Example: `soc`
```
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
soc
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
Alright! The nearest canteen to you that fit your criteria is
The Deck
which has:
Mrs Hen
  [Y] Halal Certified
  [N] Muslim Owned
  [N] Vegetarian
  [Y] In Aircon Area
and it is approximately at most 220m from where you are.
You can enter your canteen criteria again to start the search again,
or "exit" to exit canteen finder.
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
```
#### 3. Exit Canteen Finder `exit`
Users can exit Canteen Finder whenever they feel like it.

Format: `exit` or `e`

Example: `e`
```
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
e
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
You have exited the Canteen Finder feature!
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
```
___
### To enter Canteen Lookup: `lookup`
This sub-feature allows user to check what kind of stalls are present in their desired canteen.

Format: `lookup` or `l`

Example: `l`
```
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
l
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
You've entered the Canteen Lookup feature!
Enter any Canteen in NUS to check what kind of stalls it have!
Eg. Techno Edge
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
```
### Canteen Lookup
#### 1. Enter canteen name `canteen`
Users can enter a specific canteen name in NUS Kent Ridge Campus.

Format: `canteen`

Example: `techno`
```
```
#### 2. Exit Canteen Lookup `exit`
Users can exit Canteen Finder whenever they feel like it.

Format: `exit` or `e`

Example: `e`
```
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
e
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
You've exited the Canteen Lookup feature
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
```
___
### To quit Canteen: `quit`
This is to quit the canteen feature. Users need to have exited `Canteen Finder`
or `Canteen Lookup` to quit `Canteen`.

Format: `quit` or `q`

Example: `q`
```
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
q
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
You've exited the Canteen feature!
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
```
___

## FAQ

**Q**: How do I transfer my data to another computer? 

**A**: {your answer here}

## Command Summary

{Give a 'cheat sheet' of commands here}

* Add todo `todo n/TODO_NAME d/DEADLINE`
