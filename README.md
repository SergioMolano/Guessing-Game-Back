# Guessing Number Game Back End

Welcome to the Guessing Number Game Backend! This backend is built with Java, Spring Boot version 2.7.17, and JDK 11. It serves as the server-side logic for the guessing number game.

## Table of Contents

- [Features](#features)
- [Prerequisites](#prerequisites)
- [Installation](#installation)
- [Usage](#usage)
- [API Endpoints](#api-endpoints)

## Features

- **Game Logic:** Handles the game logic, including generating a random number, evaluating guesses, and keeping track of attempts.
- **RESTful API:** Provides a RESTful API for interacting with the guessing number game.

## Prerequisites

Make sure you have the following installed before setting up the backend:

- [JDK 11](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)
- Make sure to use Gradle Groovy

## Installation

To run the backend locally, follow these steps:

1. Clone the repository:

```bash
   git clone https://github.com/SergioMolano/Guessing-Game-Back.git
```

Navigate to the project directory:

```bash
cd guessing-number-game-backend
```

Build gradle.



## Usage

To start the backend server, run the project.

The backend will be available at http://localhost:8080.

## API Endpoints

Check Guess:

GET /adivinar/{suposicion}
Checks the user's guess against the target number.

Get Attempts Count:

GET /intentos
Retrieves the number of attempts made in the game.

After running the project, it is necessary to run the Front End in order to play the guessing number game.
