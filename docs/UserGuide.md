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
___
## Features
After the greeting message, Navi provides 3 main features which users can access. 
We will refer to this state as the **main menu**.
1. To enter [Canteen Feature](#canteen-canteen), user can enter `Canteen` or `c` in the main menu. <br/>
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
2. To enter [Budget Feature](#budget-budget), users can enter `Budget` in the main menu. <br>
Example: `Budget` <br>
```
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
Budget
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
Budget Tracker: Enter a command (add X, deduct X, view, exit)
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
```
3. To enter [Favorites Feature](#favorites-favorites), users can enter `Favorites` in the main menu. <br>
Example: `Favorites` <br>
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
___
## Canteen: `canteen`
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
### To enter Canteen Finder: `finder`
This sub-feature allows users to search for the nearest canteen in NUS Kent Ridge Campus 
based on user specified canteen criteria and location.

Users can enter `finder` or `f` from the canteen menu to use this sub-feature. 

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

#### 1. Enter desired canteen criteria: `CRITERIA`
Users can enter certain criteria to filter the search for the nearest canteen. 

These criteria include `halal certified`, `muslim owned`, `vegetarian` 
and `aircon`. User can enter multiple criteria at once by separating each criterion
with a `,`. 

User can also enter `nil` if they do not wish to specify any criteria.

**Tip 1:** There are very limited stalls that satisfies multiple criteria.

**Tip 2:** It is redundant to include both `halal certified` and `muslim owned` as 
if a stall is already halal, there is no nid to check if its muslim owned.

The full list of supported commands are listed in
[shortcuts for canteen criteria](#shortcuts-for-canteen-criteria) under Command Summary.

Format: `CRITERION 1, CRITERION 2`

Example: `halal certified, aircon`
```
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
halal certified, aircon
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
So you're looking for a canteen has: 
halal certified, aircon stalls.
I would need to know where are you now!
You can enter either faculties, hostels or other major landmarks in NUS!
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
```
#### 2. Enter location name: `LOCATION`
After specifying the canteen criteria, users can then enter the general location
of where they are at.

We only support locations at the `FACULTY` and `HOSTEL` level as well as 
other `KEY BUILDINGS` that don't belong to the two categories above.

The full list of supported commands are listed in 
[shortcuts for location of user](#shortcuts-for-location-of-user) under Command Summary.

Format: `LOCATION`

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
### To enter Canteen Lookup: `lookup`
This sub-feature allows user to check what kind of stalls are present in their desired canteen.

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
### Canteen Lookup
#### 1. Enter canteen name `CANTEEN`
Users can enter a specific canteen name in NUS Kent Ridge Campus.

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
#### 2. Exit Canteen Lookup `exit`
Users can exit Canteen Finder whenever they feel like it to exit to the canteen menu.

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
## Budget: `budget`

```
💰 Budget Tracker: Enter a command (add X, deduct X, view, exit)
```
### Weekly budget resets
Every mondays, system will prompt the following question

```
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
Do you want to carry over last week's remaining budget? (yes/no)
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
> no
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

```
### View status of budget and expenses
Format: `view`

Example:
```
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
view
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
Remaining weekly budget: $0.00
Total spent today: $0.00
Total spent this week: $0.00
Total spent this month: $100.00
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

```

### Add to weekly budget
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
👋 Exiting Budget Tracker.
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
```

### Automatic expenses resets
* Daily Reset: Expenses clear at midnight
* Weekly Reset: Expenses clear on Monday
* Monthly Reset: Expenses clear on 1st of month


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
### Canteen Feature related shortcuts
#### Shortcuts for canteen criteria
* `Halal Certified`
    * `hc`
* `Muslim Owned`
    * `mo`
* `vegetarian`
    * `v`
* `aircon`
    * `a`
* `nil`

#### Shortcuts for location of user

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

#### Shortcuts for canteen
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

| Feature                    | Command         |
|----------------------------|-----------------|
| Add funds to weekly budget | `add AMOUNT`    |
| Record expenses            | `deduct AMOUNT` |
| View expenses & budget     | `view`          |
| Exit Budget                | `exit`          |

___
### Favorites tracker 

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
