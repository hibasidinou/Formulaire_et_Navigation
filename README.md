# Formulaire et Navigation

## Description

This Android application demonstrates a simple form interface with navigation between activities.
The user can enter information in a form and navigate to another screen to display or process the data.


## Features

* User input form (name, fields, etc.)
* Navigation between activities
* Data passing between screens
* Simple and clean UI
* Reset or interaction handling


## Technologies

* Java
* XML
* Android Studio


## Project Structure

```bash
Formulaire_et_Navigation/
└── app/
    └── src/
        └── main/
            ├── java/com/example/formactivitynav/
            │   ├── MainActivity.java
            │   ├── SummaryActivity.java
            │
            ├── res/
            │   ├── layout/
            │   │   ├── activity_main.xml
            │   │   ├── activity_summary.xml
            │   │
            │   └── values/
            │       ├── colors.xml
            │       ├── strings.xml
            │       └── themes.xml
            │
            └── AndroidManifest.xml
```


## How it works

1. The user fills in a form in the main activity
2. On button click, the app navigates to another activity
3. Data is passed and displayed or processed
4. The user can interact or go back


## Screenshots

### Initial Interface

![Start](screenshots/screen_initial.jpg)

### Form Input

![Input](screenshots/screen_input.jpg)

### Result / Navigation

![Result](screenshots/screen_result.jpg)
![Result](screenshots/screen_result1.jpg)


## How to run

1. Open the project in Android Studio
2. Build the project
3. Run it on an emulator or Android device


## Notes

This project is created for learning purposes and demonstrates basic Android development concepts such as UI design, user input handling, and activity navigation.
