# Avengers: Infinity War Utilities

## Introduction
This project consists of a collection of utilities and classes designed for simulations related to the Avengers: Infinity War storyline. It includes functionalities to simulate forging Stormbreaker, locating Titan, predicting the outcome of Thanos' snap, using the Time Stone, and analyzing Mind Stone's neural network.

## Table of Contents
- [Installation](#installation)
- [Usage](#usage)
- [Features](#features)
- [Dependencies](#dependencies)
- [Configuration](#configuration)
- [Examples](#examples)
- [Troubleshooting](#troubleshooting)
- [Contributors](#contributors)
- [License](#license)

## Installation
Ensure you have Java installed on your system. Clone the repository and compile the Java files:

```bash
javac -d bin src/avengers/*.java
```

## Usage
Each utility can be run from the command line with specific arguments. For example, to use the `ForgeStormBreaker` utility:

```bash
java -cp bin avengers/ForgeStormBreaker forgestormbreaker.in forgestormbreaker.out
```

Replace `ForgeStormBreaker` with the utility class you wish to run, and adjust the input and output files accordingly.

## Features
- **ForgeStormBreaker:** Calculates the total flux Thor has to endure while forging Stormbreaker.
- **LocateTitan:** Uses Dijkstra’s Algorithm to find the minimum cost path to reach Titan from Earth.
- **PredictThanosSnap:** Predicts whether the graph representing the universe remains connected after Thanos' snap.
- **UseTimeStone:** Determines possible timelines and those with a utility above a certain threshold after using the Time Stone.
- **MindStoneNeighborNeurons:** Identifies neurons connected to the Mind Stone in Vision's neural network.

## Dependencies
- Java Development Kit (JDK)

## Configuration
No additional configuration is needed to run these utilities beyond the setup mentioned in [Installation](#installation).

## Examples
Each utility requires specific input and generates output to a file. For instance, to predict outcomes with the Time Stone, run:

```bash
java -cp bin avengers/UseTimeStone usetimestone.in usetimestone.out
```

Input and output file formats vary by utility. Refer to individual utility documentation for details.

## Troubleshooting
Ensure all classes are compiled and input files are formatted correctly as per utility requirements. If errors occur, check the Java version and paths to input and output files.

## Contributors
- Haider Ali

