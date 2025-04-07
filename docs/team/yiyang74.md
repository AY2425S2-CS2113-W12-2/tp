# Chen Yiyang - Project Portfolio Page

## Overview
Navi is a Command Line Interface (CLI) application designed to help NUS students, faculty and staff 
find nearby canteens, manage food expenses, and track their favorite dining experiences.

## Summary of Contributions

### Code Contributed
Code contribution to project: [Reposense Page](https://nus-cs2113-ay2425s2.github.io/tp-dashboard/?search=yiyang74&breakdown=true&sort=groupTitle%20dsc&sortWithin=title&since=2025-02-21&timeframe=commit&mergegroup=&groupSelect=groupByRepos&checkedFileTypes=docs~functional-code~test-code~other&tabOpen=true&tabType=authorship&tabAuthor=yiyang74&tabRepo=AY2425S2-CS2113-W12-2%2Ftp%5Bmaster%5D&authorshipIsMergeGroup=false&authorshipFileTypes=docs~functional-code~test-code~other&authorshipIsBinaryFileTypeChecked=false&authorshipIsIgnoredFilesChecked=false)

### Enhancements Implemented
#### Canteen Feature
The Canteen feature acts as the central hub for canteen-related functionalities, 
delegating tasks to sub-features like Canteen Finder and Lookup. 

It uses a command-driven interface (`startCanteen`) to handle user inputs.
The modular design separates concerns into distinct classes, ensuring scalability. 
OOP principles like encapsulation and single responsibility were applied, 
with each class focusing on specific tasks.

#### Canteen Finder Feature
The Canteen Finder helps users locate the nearest canteen matching their criteria (e.g. halal certified, vegetarian). 

It uses `Landmark` and `Canteen` classes to model locations and canteens, with `StallCharacteristic` encapsulating stall attributes. 
OOP techniques like composition and data validation ensure flexibility and robustness. The hierarchical structure mirrors real-world relationships, 
making the system intuitive and extensible.

#### Canteen Lookup Feature
The Canteen Lookup allows users to explore stalls in specific canteens. 

A mapping system (`CanteenShortcuts`) standardises shorthand inputs (e.g., "te" → "Techno Edge"). 
Detailed stall information is displayed using clear, structured outputs. Abstraction and efficient data structures enhance modularity and performance. 
Error handling ensures a smooth user experience when invalid inputs are provided.

___
### User Guide Contributions
Contributed to all information relating to:
- Quick Start
- Starting Navi
- Features
- Canteen
  - Canteen Finder
  - Canteen Lookup
- FAQ
  - related to Canteen features
- Command Summary
  - related to Canteen features
- Canteen Feature Related Shortcuts

___
### Developer Guide Contributions
Contributed to all information relating to:
- Acknowledgements
- Design and Implementation
  - Navi
    - Canteen Feature
      - Canteen Finder Feature
      - Canteen Lookup Feature
- Product Scope
  - Target user profile
  - Value proposition
- User Stories 
  - related to Canteen features
- Non-Functional Requirements
- Glossary
- Instruction for Manual Testing
  - Launching Navi
  - Test cases
    - related to Canteen features

___
### Contributions to Team-based Tasks
- Necessary general code enhancements
- Maintaining the issue tracker
- Release management
- Manage workflow

___
### Mentoring Contributions
- Help resolve checkstyle errors
- Help resolve Continuous Integration (CI) errors
