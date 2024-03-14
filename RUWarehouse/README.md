# Warehouse Management System

## Introduction
This project implements a Warehouse Management System designed to handle inventory for a warehouse using a hash table-like structure where each entry of the table stores a priority queue. The system allows adding, deleting, and restocking products while keeping the space constant by deleting less popular items.

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
Ensure you have Java installed on your system. Compile the Java files:

```bash
javac warehouse/*.java
```

## Usage
Execute different operations like adding, deleting, and restocking products by running the corresponding Java files:

```bash
java warehouse.AddProduct input.txt output.txt
```

Replace `AddProduct` with the appropriate class name to execute different functionalities.

## Features
- **Add Products:** Allows adding new products to the warehouse.
- **Better Add Products:** Implements a better scheme for adding products by filling empty spaces efficiently.
- **Delete Products:** Enables deleting products from the warehouse.
- **Restock Products:** Supports restocking existing products.
- **Purchase Products:** Simulates the purchase of products.
- **Sector Management:** Manages products using a sector-based approach to prioritize popularity.

## Dependencies
- Java Development Kit (JDK)

## Configuration
No additional configuration is needed to run this project.

## Examples
Each operation (add, delete, restock, etc.) requires an input file specifying the operation details and an output file to write the operation's result. The input format varies based on the operation being performed.

## Troubleshooting
Ensure that all Java files are correctly compiled and that input files are formatted correctly according to the requirements of each operation.

## Contributors
- Haider Ali
