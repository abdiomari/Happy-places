# Happy-places — "Discover and share your happy places"

## Overview
Happy-places is a mobile application that allows users to discover and share their favorite locations. It provides a platform for users to create and manage content related to their happy places, including images and descriptions. This project aims to create a user-friendly and engaging experience for users to share their experiences and connect with others who share similar interests.

## Tech Stack
* Java
* Android
* Firebase Database
* Firebase Storage
* Gradle

## Features
* User authentication and authorization
* Content creation and management (images and descriptions)
* Navigation between activities (e.g. after login, watch content, create content)
* Image upload and storage using Firebase Storage
* Data storage and retrieval using Firebase Realtime Database

## Screenshots
> 📸 Screenshots coming soon. Run the project locally to see it in action.

## Setup & Installation

1. Clone the repository using the following command:
```bash
git clone https://github.com/abdiomari/Happy-places.git
```
2. Navigate to the project directory:
```bash
cd Happy-places
```
3. Install the required dependencies using Gradle:
```bash
./gradlew assembleDebug
```
4. Set up Firebase by creating a new project in the Firebase console and adding the necessary configuration files to the project:
```bash
cp google-services.json app/google-services.json
```
5. Run the application on an Android device or emulator:
```bash
./gradlew installDebug
```
6. Start the application on the device or emulator:
```bash
adb shell am start -n com.example.myapplication/.MainActivity
```
Note: Make sure to replace `com.example.myapplication` with the actual package name of the application.