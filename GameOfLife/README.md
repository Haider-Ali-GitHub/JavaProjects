# Conway's Game of Life

## Introduction
This project is an implementation of Conway's Game of Life, a cellular automaton devised by the British mathematician John Horton Conway in 1970. The game is a zero-player game, meaning its evolution is determined by its initial state, requiring no further input from human players. One interacts with the Game of Life by creating an initial configuration and observing how it evolves.

## Table of Contents
- [Installation](#installation)
- [Usage](#usage)
- [Features](#features)
- [Dependencies](#dependencies)
- [Configuration](#configuration)
- [Examples](#examples)
- [Troubleshooting](#troubleshooting)
- [Contributors](#contributors)

## Installation
To run this project, you'll need Java installed on your machine. Clone this repository and compile the Java files:

```
javac *.java
```

## Usage
To start the game, run the `Driver.java` file:

```
java Driver
```

This will open a graphical user interface where you can interact with the game.

## Features
- Interactive GUI to play Conway's Game of Life.
- Various modes to create the game's initial state, including default, from an input file, or custom creation.
- Functionality to save and load game states.
- Implementation of Conway's Game of Life rules to simulate cell evolution.
- Tools to analyze the current state, including checking cell states, counting alive neighbors, and determining the number of communities.

## Dependencies
- Java Development Kit (JDK) - The project is developed in Java.
- StdDraw library for graphical representation.

## Configuration
No additional configuration is needed to run the project.

## Examples
1. **Creating a Default Game:** Select "Create Default Game" to load a predefined grid.
2. **Using an Input File:** Choose "Create Game with Input File" and specify the path to your file.
3. **Creating a Custom Game:** Opt for "Create Custom Game" to manually create an initial state on the grid.

## Troubleshooting
If you encounter any issues running the program, ensure Java is properly installed and that all files are compiled. For graphical issues, adjusting the window size or ensuring your screen's resolution is compatible might help.

## Contributors
- Haider Ali (ha484@scarletmail.rutgers.edu)
