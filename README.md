CougLens 

2019 Crimson Code Hackathon 

2/23-2/24 

Kyle Newton, Jason Bowen, Dustin Peters, Colin Greeley 


Software: 

Android Studio 

GitKraken 

Github 

Hardware: 

Any android device we can use 

Android Studio built in emulators 

Languages: 

Java 

Will be used as the primary functionality 

XML 

Layout and Configuration 

JSON 

Files Returned by the Clarifai API 

Overview: 

This app is intended to be written for the 2019 Crimson Code Hackathon. All code will be written between 2/23/2019 and 2/24/2019 for the original submitted project. As of 1/30/2019 there are no plans to release the app to the general public, but that could change. 

The general purpose behind this app is to allow the user (A) to be able to take a picture with their smartphone and the app will be able to identify what the user was taking a picture of. There may also be plans to return an amazon or google search for the item. A will be able to either take a picture using either camera on the phone, while defaulting to the rear-facing camera, as well as choosing a photo from the photo gallery to use. 

The images will eventually be loaded into the API and used to further the machine learning of the program. This will however require a large database, so while in development stages this likely will not be implemented on a large scale, likely using a Raspberry Pi with access to a Hard Drive to store uploaded images as proof of concept. 

A will have the option to upload an unrecognized image to the servers, as well as a setting that will be a toggle on first app start to allow images processed through the app to be uploaded with no identifying information. This will allow the neural network/machine learning to evolve and become more accurate with increased app usage. 

This app will be built in Android Studio, using Java and the Clarifai API (https://clarifai.com/) and the Java interface for Clarifai (https://github.com/Clarifai/clarifai-java). This will be built using the Gradle Build Tools and will be expected to run on API 15: Android 4.0.3 (IceCreamSandwich) which has compatibility with ~100% of mobile devices running an Android operating system. 

Screen Specifications 

This app will consist of multiple screens. They will follow a standard design that will be designed in the future. All screens will be created in XML through the android studio visual IDE.  

Each screen will be known by one specific name which will appear in this document as underlined, for example Home Page. 


Home Page 

The Home Page will Feature 3 buttons; Take Photo, Lookup Photo, Saved Searches 

The Buttons will lead to 

Take Photo 

Lead to a camera that will take a photo and then analyze it 

Lookup Photo 

Will open the photo gallery and allow the user to select a photo to analyze 

Saved Searches 

Leads to a list of n searches (Not sure size, maybe a toggleable size?) 

Take Photo Screen 

This screen allows the user to take a photo and the app will analyze it and tell the result. This screen will include a button to take a picture. After the picture is taken the user will have the option to crop the photo to better select the object they want to identify. There will also be an option to discard the photo and to take another. After the user finishes cropping the photo they will press an “identify” button. That button will use the clarifai API to analyze the picture. They will then be given the option to save their search to the Saved Searches screen. 

 

Lookup Photo Screen 

This screen will allow the user to select a photo from their saved pictures to analyze. The functionality of this screen will be identical to the Take Photo Screen after the picture is taken. 

Saved Searches Screen 

This screen will contain a list of entries of n size that will be able to be selected and the entry for the photo will appear above the photo. The size will be configurable. Maybe 5 searches for a free version and unlimited for paid? (Use a stack probably, want the most recent on top) 

Division of Responsibilities 

General Code 

TBD 

Visual Programming (XML Layout) 

TBD 

JSON Interpretation 

TBD 

 

 

There will likely be multiple people working on different parts of the app simultaneously. This will require using GIT and branching to make sure that we are all on the same page of what is being worked on at the moment. Goals for the project will be agreed upon before the hackathon begins.