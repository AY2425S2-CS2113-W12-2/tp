# Navi 

Navi is your friendly and efficient companion designed to enhance your dining experience on the
National University of Singapore (NUS) Kent Ridge campus. Whether you're looking for the nearest halal-certified canteen
with air-conditioning, trying to keep track of your weekly expenses, or want a convenient way to save and organize your
favorite spots on campus, Navi has you covered. This guide will walk you through all the features and commands, ensuring
you can easily navigate and make the most of everything Navi offers. Get ready to simplify your campus life with Navi!

## Setting up in Intellij

Prerequisites: JDK 17 (use the exact version), update Intellij to the most recent version.

1. **Ensure Intellij JDK 17 is defined as an SDK**, as described [here](https://www.jetbrains.com/help/idea/sdk.html#set-up-jdk) -- this step is not needed if you have used JDK 17 in a previous Intellij project.
2. **Import the project _as a Gradle project_**, as described [here](https://se-education.org/guides/tutorials/intellijImportGradleProject.html).
3. **Verify the setup**: After the importing is complete, locate the `src/main/java/seedu/navi/Navi.java` file, right-click it, and choose `Run Navi.main()`. If the setup is correct, you should see something like the below:

```
> Task :compileJava UP-TO-DATE
> Task :processResources NO-SOURCE
> Task :classes UP-TO-DATE

> Task :seedu.navi.Navi.main()
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

Type some word and press enter to let the execution proceed to the end.

**Warning:** Keep the `src\main\java` folder as the root folder for Java files (i.e., don't rename those folders or move Java files to another folder outside of this folder path), as this is the default location some tools (e.g., Gradle) expect to find Java files.

## Build automation using Gradle

* This project uses Gradle for build automation and dependency management. It includes a basic build script as well (i.e. the `build.gradle` file).
* If you are new to Gradle, refer to the [Gradle Tutorial at se-education.org/guides](https://se-education.org/guides/tutorials/gradle.html).

## Testing

### I/O redirection tests

* To run _I/O redirection_ tests (aka _Text UI tests_), navigate to the `text-ui-test` and run the `runtest(.bat/.sh)` script.

### JUnit tests

* A skeleton JUnit test (`src/test/java/seedu/navi/NaviTest.java`) is provided with this project template. 
* If you are new to JUnit, refer to the [JUnit Tutorial at se-education.org/guides](https://se-education.org/guides/tutorials/junit.html).

## Checkstyle

* A sample CheckStyle rule configuration is provided in this project.
* If you are new to Checkstyle, refer to the [Checkstyle Tutorial at se-education.org/guides](https://se-education.org/guides/tutorials/checkstyle.html).

## CI using GitHub Actions

The project uses [GitHub actions](https://github.com/features/actions) for CI. When you push a commit to this repo or PR against it, GitHub actions will run automatically to build and verify the code as updated by the commit/PR.

## Documentation

`/docs` folder contains the project documentation.

Steps for publishing documentation to the public: 
1. If you are using this project template for an individual project, go your fork on GitHub.<br>
   If you are using this project template for a team project, go to the team fork on GitHub.
2. Click on the `settings` tab.
3. Scroll down to the `GitHub Pages` section.
4. Set the `source` as `master branch /docs folder`.
5. Optionally, use the `choose a theme` button to choose a theme for your documentation.
