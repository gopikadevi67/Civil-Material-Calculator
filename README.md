Civil Material Calculator 

This project is a simple Java-based application designed for civil engineers and construction professionals.
It helps calculate the estimated quantities and costs of construction materials, such as cement, sand, and aggregate, for concrete work.

Project Objective
The primary objective of this project is to develop a material estimation tool that enables users to calculate the required quantities and total cost of materials for concrete construction, based on user inputs and a predefined mix ratio.

Features

Calculates quantities of cement, sand, and aggregate
Estimates total material cost based on user-provided prices
Uses the standard concrete mix ratio (1:2:4)
Provides a simple command-line interface
Easy to extend with a graphical interface or database integration

Technologies Used

Programming Language: Java
Build Tool: Optional (Maven or Gradle)
Environment: Console or Command Line
Possible Extensions: JavaFX for GUI, MySQL or SQLite for data storage

Folder Structure

How to Run

1. Compile the program

2. Run the program


How It Works

* The program assumes a concrete mix ratio of 1:2:4 (Cement : Sand : Aggregate).
* It calculates dry volume using the formula: Dry Volume = Wet Volume × 1.54.
* The share of each material is calculated based on the ratio.
* The total estimated cost is calculated using the user-provided prices.

Future Enhancements

Add material estimation for brickwork and plastering
Include steel quantity calculations for RCC structures
Add a graphical user interface (JavaFX or Swing)
Save results to a database or export to a file
Generate PDF reports using the iText library
Add unit conversion support between metric and imperial systems


