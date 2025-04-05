# User Guide

* ### [Introduction](#introduction)
* ### [Quick start](#quick-start)
* ### [Features](#features)
  * [Canteen: `canteen`](#canteen-canteen)
    * [Canteen finder: `finder`](#to-enter-canteen-finder-finder)
    * [Canteen lookup: `lookup`](#to-enter-canteen-lookup-lookup)
  * [Budget: `budget`](#budget-budget)
  * [Favorites: `favorites`](#favorites-favorites)
* ### [Command Summary](#command-summary)
* ### [Canteen feature related shortcuts](#canteen-feature-related-shortcuts)


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
User may use the following features by entering `canteen`, `budget` or `favorites`.
1. Canteen Feature
2. Budget Feature
3. Favorites Feature

User can only use one feature at a time. To switch from one feature to another, user need to exit the current feature they are in.
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

User can refer [here](#shortcuts-for-canteen-criteria) for all criteria available.

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

User can refer [here](#shortcuts-for-location-of-user) for all locations available.

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

User can refer [here](#shortcuts-for-canteen) for all canteen available.

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
## Budget: `budget`
To enter budget tracker feature:

Format: `budget`

```
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
budget
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
Budget Tracker: Enter a command (add X, deduct X, view, exit)
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
```
### Weekly budget resets
Every mondays only, system will prompt the following question, before showing the above prompt (`Budget Tracker: Enter a command (add X, deduct X, view, exit`)) 

```
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
Do you want to carry over last week's remaining budget? (yes/no)
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
> no
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

```

### Add to weekly budget

Tip 1: Add valid numbers (letters, negative numbers, special characters and blanks are not allowed )

Tip 2: Add amounts that are not too large (amounts greater than 1 million is discouraged while amounts greater than 1.7976931348623157E308 is not allowed) 

Format: `add AMOUNT`

Example:
```
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
>add 100
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
Added $100.00 to this week's budget.
Remaining weekly budget: $100.00
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
```

### Deduct from weekly budget and add to expenses

Tip 1: Deduct valid numbers (letters, negative numbers, special characters and blanks are not allowed )

Tip 2: Deduct amounts that are not too large (amounts greater than 1 million is discouraged while amounts greater than 1.7976931348623157E308 is not allowed)

Format: `deduct AMOUNT`

Example:
```
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
deduct 20
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
Deducted $20.00 from your weekly budget.
Remaining weekly budget: $80.00
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
```

### View remaining budget and expenses

Tip 1: Navi ignores any extra parameters after 'view' and works as expected.

Format: `view`

Example:
```
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
view
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
Remaining weekly budget: $80.00
Total spent today: $20.00
Total spent this week: $20.00
Total spent this month: $120.00
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
```
### Exit budget feature
Format: `exit`
```
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
> exit
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 Exiting Budget Tracker.
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
```

### Automatic expenses resets
Navi automatically resets the following attributes at appropriate times.
* Daily Reset: Daily expenses clear at midnight
* Weekly Reset: Weekly expenses clear on Monday
* Monthly Reset: Monthly expenses clear on 1st of month
___
## Favorites: `favorites`

```
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
🌟 Favorites Tracker: Enter a command:
  - add <description> : <rating> : <location>
  - remove N
  - view
  - sort asc
  - sort desc
  - search X
  - undo
  - exit
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
```
### Add to favorites list
Format: `add <description> : <rating> : <location>`

```

> add milo:3:com
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
✅ Added: milo | Rating: 3 | Category: com
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
```
### Remove from favorites list
Format: `remove N`

```
> remove 1
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
❌ Removed: milo | Rating: 3 | Category: com
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
```
### View favorites list
Format:`view`

```
> view
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
🌟 Your favorite items:
1. milo | Rating: 3 | Category: com
2. cheese prata | Rating: 10 | Category: utown
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
```
### Sort favorites list in ascending order
Format: `sort asc`

```
> sort asc
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
📊 Favorites sorted in ascending order.
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
> view
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
🌟 Your favorite items:
1. milo | Rating: 3 | Category: com
2. cheese prata | Rating: 10 | Category: utown
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
```
## Sort favorites list in descending order
Format: `sort desc`

```
> sort desc
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
📊 Favorites sorted in descending order.
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
> view
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
🌟 Your favorite items:
1. cheese prata | Rating: 10 | Category: utown
2. milo | Rating: 3 | Category: com
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
```
### Search for your favorite item
Format: `search X`

```
> search milo
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
🔎 Search results for 'milo':
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
milo | Rating: 3 | Category: com
milo | Rating: 8 | Category: deck
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
```
### Undo any accidental remove commands
Format: `Undo`

```
> undo 
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
🔄 Restored: milo | Rating: 8 | Category: deck
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
```
### Exit favorites tracker
Format: `exit`

```
> exit
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
👋 Exiting Favorites Tracker.
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
```

## Command Summary
___
### Main Application

| Feature                 | Command          |
|-------------------------|------------------|
| Enter Canteen feature   | `canteen` or `c` |
| Enter budget tracker    | `budget`         |
| Enter favorites manager | `favorites`      |
| Exit chatbot            | `bye`            |
___

### Canteen feature (main)

| Feature              | Command         |
|----------------------|-----------------|
| Enter Canteen finder | `finder` or `f` |
| Enter Canteen lookup | `lookup` or `l` |
| Exit Canteen         | `quit` or `q`   |

#### Canteen finder

| Feature                          | Command                                                                                        | Example |
|----------------------------------|------------------------------------------------------------------------------------------------|---------|
| Specify desired canteen criteria | `CRITERIA 1, CRITERIA 2`<br/> ( halal certified, muslim owned, <br/> vegetarian, aircon, nil ) | `hc,a`  |
| Enter location of user           | `FACULTY` or `HOSTEL` or `KEY BUILDINGS`                                                       | `soc`   |
| Exit Canteen Finder              | `exit` or `e`                                                                                  | `e`     |

#### Canteen lookup

| Feature                | Command       | Example |
|------------------------|---------------|---------|
| View stalls in canteen | `CANTEEN`     | `deck`  |
| Exit Canteen Lookup    | `exit` or `e` | `e`     |
___
### Budget tracker

| Feature                              | Command         | Prompt                                                           |
|--------------------------------------|-----------------|------------------------------------------------------------------|
| Enter Budget                         | `budget`        |                                                                  |
| Carry over budget from previous week | `yes` or `no`   | Do you want to carry over last week's remaining budget? (yes/no) |
| Add funds to weekly budget           | `add AMOUNT`    | -                                                                |
| Record expenses                      | `deduct AMOUNT` | -                                                                |
| View expenses & budget               | `view`          | -                                                                |
| Exit Budget                          | `exit`          | -                                                                |

___
### Favorites manager

| Feature          | Command                                     |
|------------------|---------------------------------------------|
| Add favorites    | `add <description> : <rating> : <location>` |
| Remove favorites | `remove N`                                  |
| View favorites   | `view`                                      |
| Sort ascending   | `sort asc`                                  |
| Sort descending  | `sort desc`                                 |
| Search favorites | `search X`                                  |
| Undo Remove      | `undo`                                      |
| Exit favorites   | `exit`                                      |

## Canteen Feature related shortcuts
### Shortcuts for canteen criteria
* `Halal Certified`
    * `hc`
* `Muslim Owned`
    * `mo`
* `vegetarian`
    * `v`
* `aircon`
    * `a`
* `nil`

### Shortcuts for location of user

<u>Faculties</u>
* `College of Design and Engineering`
    * `cde` / `eng`
* `School of Computing`
    * `soc` / `computing` / `comp`
* `Faculty of Arts and Social Sciences`
    * `fass`
* `NUS Business School`
    * `nbs` / `biz` / `business`
* `Faculty of Science`
    * `science` / `fos`
* `School of Public Health`
    * `soph`
* `School of Medicine`
    * `som`

<u>Hostels</u>
* `Raffles Hall`
    * `raffles` / `rh`
* `Eusoff Hall`
    * `eusoff` / `eh`
* `Temasek Hall`
    * `temasek` / `th`
* `Sheares Hall`
    * `sheares` / `sh`
* `Kent Ridge Hall`
    * `krh`
* `King Edward Hall`
    * `king edward` / `keh`
* `Prince George's Park Residence`
    * `pgp residence` / `pgpr`
* `UTown Residence`
    * `utr`
* `Residential College 4`
    * `rc4`
* `College of Alice and Peter Tan`
    * `college of alice & peter tan` / `capt`
* `Ridge View Residential College`
    * `ridge view` / `rvrc`
* `Tembusu`
    * `t`
* `Cinnamon`
    * `c`

<u>Key Buildings</u>
* `Centre for English Language Communication`
    * `celc`
* `Hon Sui Sen Memorial Library`
    * `hssml`
* `Central Library`
    * `clb`
* `Medicine+Science Library`
    * `medicine science library` / `med sci lib` / `msl`
* `Stephen Riady Centre`
    * `utown src` / `utsrc`
* `Education Resource Centre`
    * `utown erc` / `uterc`
* `University Hall`
    * `u hall` / `uh`
* `Multipurpose Sports Hall`
    * `mpsh`
* `University Health Centre`
    * `uhc`

### Shortcuts for canteen
* `Techno Edge`
    * `techno` / `te`
* `Frontier`
    * `fr`
* `The Deck`
    * `deck` / `d`
* `Terrace`
    * `t`
* `Prince George's Park Canteen`
    * `pgp canteen` / `pgp`
* `Fine Food`
    * `ff`
* `Flavours`
    * `fl`
