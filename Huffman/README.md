# Huffman Coding

## Introduction
This project implements the Huffman Coding algorithm for compressing and decompressing text files. It demonstrates the use of a binary heap, priority queue, and binary search trees to efficiently encode and decode text based on the frequency of character occurrence.

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
Ensure Java is installed on your system. Compile the Java files using the command:

```
javac *.java
```

## Usage
Run the Driver.java to start the application:

```
java Driver
```

Follow the prompts to encode or decode a file using Huffman Coding.

## Features
- Efficient text compression and decompression using Huffman Coding.
- Interactive command-line interface for encoding and decoding files.
- Visualization of the Huffman tree for educational purposes.

## Dependencies
This project requires the Java Development Kit (JDK) to compile and run.

## Configuration
No additional configuration is needed to run this project.

## Examples
Example usage of encoding a text file:

```
Enter an input text file name => example.txt
What method would you like to test?
1. makeSortedList
2. makeTree
3. makeEncodings
4. encode
5. decode
Enter a number => 4
File to encode into (can be new) => encoded.bin
```

Example usage of decoding a previously encoded file:

```
Enter an input text file name => encoded.bin
What method would you like to test?
1. makeSortedList
2. makeTree
3. makeEncodings
4. encode
5. decode
Enter a number => 5
File to decode into (can be new) => decoded.txt
```

## Troubleshooting
Ensure all files are in the same directory and that file names are entered correctly. If you encounter errors related to StdIn or StdOut, ensure these classes are correctly implemented and included in your directory.

## Contributors
- Haider Ali
