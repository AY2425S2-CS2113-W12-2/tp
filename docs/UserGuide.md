# User Guide

* ### [Introduction](#introduction)
* ### [Quick start](#quick-start)
* ### [Starting Navi](#starting-navi)
* ### [Features](#features)
  * #### [Canteen: `canteen`](#canteen-canteen)
    * [Canteen finder: `finder`](#to-enter-canteen-finder-finder)
    * [Canteen lookup: `lookup`](#to-enter-canteen-lookup-lookup)
  * #### [Budget: `budget`](#budget-budget)
  * #### [Favorites: `favorites`](#favorites-favorites)
* ### [FAQ](#faq)
* ### [Command Summary](#command-summary)
* ### [Canteen feature related shortcuts](#canteen-feature-related-shortcuts)


## Introduction

Welcome to the Navi User Guide! Navi is your friendly and efficient companion designed to enhance your experience on the
National University of Singapore (NUS) Kent Ridge campus. Whether you're looking for the nearest halal-certified canteen 
with air-conditioning, trying to keep track of your weekly expenses, or want a convenient way to save and organize your 
favorite spots on campus, Navi has you covered. This guide will walk you through all the features and commands, ensuring 
you can easily navigate and make the most of everything Navi offers. Get ready to simplify your campus life with Navi!

## Quick Start

1. Ensure that you have Java 17 or above installed.
2. Down the latest zip file of `Navi` from [here](https://github.com/AY2425S2-CS2113-W12-2/tp/releases).
3. Unzip the file and cd into that directory on your terminal.
4. Enter `java -jar Navi.jar` and enjoy the app!

## Starting Navi
Whenever users start Navi, they will first be greeted by Navi.

Example:
```
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
Welcome! I'm:
 _   _             _
| \ | | __ ___   _(_)
|  \| |/ _` \ \ / / |
| |\  | (_| |\ V /| |
|_| \_|\__,_| \_/ |_|
Alright, what can I do for you?
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
```

## Features
After the greeting message, Navi provides 3 main features which users can access. 
We will refer to this state as the **main menu**.
1. [Canteen Feature](#canteen-canteen)
2. [Budget Feature](#budget-budget)
3. [Favorites Feature](#favorites-favorites)

## Canteen: `canteen`
To enter the canteen feature, user can enter `Canteen` or `c` in the main menu. <br/>
Example: `c` <br>
```
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
c
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
You've entered the Canteen feature!
You can enter "finder" to look for the nearest canteen to you,
or you can enter "lookup" to see a canteen's stalls information.
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
```

After entering `canteen` in the main menu, users will be prompted to pick which
canteen-related sub-feature to use in the **canteen menu**. <br>
The Canteen feature provides 2 sub-features which includes:
1. [Canteen Finder](#to-enter-canteen-finder-finder) 
2. [Canteen Lookup](#to-enter-canteen-lookup-lookup)


### To exit Canteen: `exit`
If users wish to exit the canteen feature, they can enter `exit` in the canteen menu
to return to the main menu. <br> Users need to have exited `Canteen Finder`
or `Canteen Lookup` to exit `Canteen`.

Format: `exit` or `e`

Example: `e`
```
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
e
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
You've exited the Canteen feature!
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
```
___
### Canteen Finder
This sub-feature allows users to search for the nearest canteen in NUS Kent Ridge Campus
based on user specified canteen criteria and location.
#### To enter Canteen Finder: `finder`

Format: `finder` or `f`

Example: `f`
```
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
f
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
So you wanna find where's the nearest canteen to you?
You can state your location first then enter your canteen
criteria after "c/"
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
```
Once in Canteen Finder, users can then enter their location and canteen criteria
to begin the search for the nearest canteen.

#### Searching for nearest canteen: `SEARCH TYPE | LOCATION | CRITERIA`
For `SEARCH TYPE`, Navi allows users to choose between a "match any criteria" or 
"match all criteria" search types. 

User can enter `1` for "match any criteria" search type and `2` for "match all criteria" search type.

For `LOCATION`, Navi only support locations at the `FACULTY` and `HOSTEL` level as well as
other `KEY BUILDINGS` that don't belong to the two categories above.

The full list of supported locations are listed in
[shortcuts for location of user](#shortcuts-for-location-of-user) under Command Summary.

For `CRITERIA`, supported criteria include `halal certified`, `muslim owned`, `vegetarian` 
and `aircon`. Users can enter multiple criteria at once by separating each criterion
with a `,`. Users can also enter `nil` if they do not wish to specify any criteria.

The full list of supported commands are listed in
[shortcuts for canteen criteria](#shortcuts-for-canteen-criteria) under Command Summary.

**Tip 1:** There are very limited stalls that satisfies multiple criteria.

**Tip 2:** Navi does not support users to enter both `halal certified` and `muslim owned`.
Reasoning is answered in the [FAQ section](#faq).

Format: `SEARCH | LOACTION | CRITERION 1, CRITERION 2`

Example 1: `1 | School of Computing | halal certified, aircon`
```
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
1 | School of Computing | halal certified, aircon
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
Alright! The nearest canteen to you that fit your criteria is
The Deck
which is:
Liang Ban Gong Fu
  [N] Halal Certified
  [N] Muslim Owned
  [N] Vegetarian
  [Y] In Aircon Area
Pasta Express
  [N] Halal Certified
  [N] Muslim Owned
  [N] Vegetarian
  [Y] In Aircon Area
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
Example 2: `2 | School of Computing | halal certified, aircon`
```
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
2 | School of Computing | halal certified, aircon
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
Alright! The nearest canteen to you that fit your criteria is
The Deck
which is:
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

#### Exit Canteen Finder `exit`
Users can exit Canteen Finder whenever they feel like it to exit to the canteen menu.

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
### Canteen Lookup

This sub-feature allows user to check what kind of stalls are present in a specific canteen.

#### To enter Canteen Lookup: `lookup`

Users can enter `lookup` or `l` from the canteen menu to use this sub-feature.

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
Once in Canteen Lookup, users can enter a specific canteen name in NUS Kent Ridge Campus.

#### Enter canteen name `CANTEEN`

The full list of supported commands are listed in
[shortcuts for canteen](#shortcuts-for-canteen) under Command Summary.

Format: `CANTEEN`

Example: `techno`
```
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
techno
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
Here are all the stalls in Techno Edge:
Western Food
  [N] Halal Certified
  [N] Muslim Owned
  [N] Vegetarian
  [N] In Aircon Area
Nasi Padang
  [N] Halal Certified
  [Y] Muslim Owned
  [N] Vegetarian
  [N] In Aircon Area
Vegetarian
  [N] Halal Certified
  [N] Muslim Owned
  [Y] Vegetarian
  [N] In Aircon Area
Mala Hotpot
  [Y] Halal Certified
  [N] Muslim Owned
  [N] Vegetarian
  [N] In Aircon Area
Indian
  [N] Halal Certified
  [N] Muslim Owned
  [N] Vegetarian
  [N] In Aircon Area
Mixed Rice
  [N] Halal Certified
  [N] Muslim Owned
  [N] Vegetarian
  [N] In Aircon Area
Drinks & Snacks
  [N] Halal Certified
  [N] Muslim Owned
  [N] Vegetarian
  [N] In Aircon Area
Fruit Juice
  [N] Halal Certified
  [N] Muslim Owned
  [N] Vegetarian
  [N] In Aircon Area
Taiwan
  [N] Halal Certified
  [N] Muslim Owned
  [N] Vegetarian
  [N] In Aircon Area
Ramen & Soup
  [N] Halal Certified
  [N] Muslim Owned
  [N] Vegetarian
  [N] In Aircon Area
Noodles
  [N] Halal Certified
  [N] Muslim Owned
  [N] Vegetarian
  [N] In Aircon Area
Chicken Rice
  [N] Halal Certified
  [N] Muslim Owned
  [N] Vegetarian
  [N] In Aircon Area
Bistro Box
  [Y] Halal Certified
  [N] Muslim Owned
  [N] Vegetarian
  [Y] In Aircon Area
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
```
#### Exit Canteen Lookup `exit`
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

## Budget: `budget`
To enter budget tracker feature, users can enter `budget` in the main menu.

Format: `budget`

```
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
budget
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
Budget Tracker: Enter a command (add X, deduct X, view, exit)
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
```
#### Weekly budget resets
Every mondays only, system will prompt the following question, before showing the above prompt (`Budget Tracker: Enter a command (add X, deduct X, view, exit`)) 

```
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
Do you want to carry over last week's remaining budget? (yes/no)
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
> no
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

```

#### Add to weekly budget

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

#### Deduct from weekly budget and add to expenses

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

#### View remaining budget and expenses

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
#### Exit budget feature
Format: `exit`
```
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
> exit
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 Exiting Budget Tracker.
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
```

#### Automatic expenses resets
Navi automatically resets the following attributes at appropriate times.
* Daily Reset: Daily expenses clear at midnight
* Weekly Reset: Weekly expenses clear on Sundays
* Monthly Reset: Monthly expenses clear on 1st of month

## Favorites: `favorites`
To enter the favorites feature, users can enter `favorites` in the main menu.

```
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
favorites
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
#### Add to favorites list
Format: `add <description> : <rating> : <location>`

```

> add milo:3:com
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
✅ Added: milo | Rating: 3 | Category: com
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
```
#### Remove from favorites list
Format: `remove N`

```
> remove 1
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
❌ Removed: milo | Rating: 3 | Category: com
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
```
#### View favorites list
Format:`view`

```
> view
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
🌟 Your favorite items:
1. milo | Rating: 3 | Category: com
2. cheese prata | Rating: 10 | Category: utown
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
```
#### Sort favorites list in ascending order
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
#### Sort favorites list in descending order
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
#### Search for your favorite item
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
#### Undo any accidental remove commands
Format: `Undo`

```
> undo 
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
🔄 Restored: milo | Rating: 8 | Category: deck
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
```
#### Exit favorites tracker
Format: `exit`

```
> exit
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
👋 Exiting Favorites Tracker.
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
```

## FAQ

**Q**: How do I transfer my data to another computer? 

**A**: {your answer here}

**Q**: For Canteen Finder feature, what is the difference between Halal Certified and 
Muslim Owned?

**A**: Halal Certified strictly refers to stalls that has been provided the Halal Certification
by Majlis Ugama Islam Singapura (MUIS) in Singapore. This certification is not free and is costly.
Muslim owned refers to stalls that aren't halal certified but are owned by muslims who would 
prepare food to the halal standard and are not willing or able to afford the certification by MUIS. 

**Q**: Why can't I enter both Halal Certified and Muslim Owned into the canteen criteria?

**A**: If a stall is already Halal Certified, there is no need to worry about whether the stall is
muslim owned. Hence, there is no point in putting both Halal Certified and Muslim Owned into the
canteen criteria field.

**Q**: What does [Y] and [N] mean regarding canteen stalls?

**A**: [Y] indicates that the canteens stall has that characteristic whereas [N]
means it doesn't. <br/> For example: <br/>
```
Bistro Box
  [Y] Halal Certified
  [N] Muslim Owned
  [N] Vegetarian
  [Y] In Aircon Area
```
This means that Bistro Box is both Halal Certified and in an aircon area.

## Command Summary
___
### Main Application

| Feature                 | Command          |
|-------------------------|------------------|
| Enter Canteen feature   | `canteen` or `c` |
| Enter budget tracker    | `budget`         |
| Enter favorites manager | `favorites`      |
| Exit Navi               | `exit`           |
___

### Canteen feature (main)

| Feature              | Command         |
|----------------------|-----------------|
| Enter Canteen finder | `finder` or `f` |
| Enter Canteen lookup | `lookup` or `l` |
| Exit Canteen         | `exit` or `e`   |

#### Canteen finder

| Feature              | Command                                | Example                                               |
|----------------------|----------------------------------------|-------------------------------------------------------|
| Find nearest canteen | `SEARCH TYPE  \| LOCATION \| CRITERIA` | `1 \| School of Computing \| halal certified, aircon` |
| Exit Canteen Finder  | `exit` or `e`                          | `e`                                                   |

#### Canteen lookup

| Feature                | Command       | Example |
|------------------------|---------------|---------|
| View stalls in canteen | `CANTEEN`     | `deck`  |
| Exit Canteen Lookup    | `exit` or `e` | `e`     |
___
### Budget tracker

| Feature                              | Command         | Prompt                                                             |
|--------------------------------------|-----------------|--------------------------------------------------------------------|
| Enter Budget                         | `budget`        |                                                                    |
| Carry over budget from previous week | `yes` or `no`   | `Do you want to carry over last week's remaining budget? (yes/no)` |
| Add funds to weekly budget           | `add AMOUNT`    | -                                                                  |
| Record expenses                      | `deduct AMOUNT` | -                                                                  |
| View expenses & budget               | `view`          | -                                                                  |
| Exit Budget                          | `exit`          | -                                                                  |

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
