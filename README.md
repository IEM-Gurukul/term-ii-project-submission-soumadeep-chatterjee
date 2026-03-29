[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/pG3gvzt-)
# PCCCS495 – Term II Project

## Project Title
 Student Attendance Management System Persistence  


## Problem Statement (max 150 words)
Managing student attendance manually often leads to inefficiencies, errors, and difficulty in tracking long-term 
records. Traditional paper-based registers or basic CRUD applications lack proper abstraction, modularity, and 
extensibility. The proposed Student Attendance Management System aims to provide a structured, object-oriented 
solution that records attendance, calculates percentages, and supports features like holiday management and date
range filtering. By incorporating file persistence and layered architecture, the system ensures usability, 
maintainability, and defendable design maturity.  


## Target User
Educational institutions (schools, colleges, training centers) and administrators who need a lightweight but reliable 
attendance tracking solution.  


## Core Features
▪ Add and manage student records   
▪ Mark attendance (Present/Late) for specific dates   
▪ View attendance percentage per student   
▪ Search student by ID or name   
▪ View attendance by date range (monthly or custom)   
▪ Holiday management (exclude holidays from totals)   
▪ Summary dashboard (total students, average attendance percentage)   
▪ Basic notifications (console confirmations and warnings for low attendance)   
▪ File persistence (records stored and retrieved from text/CSV files)  

## OOP Concepts Used
▪ Abstraction: Separate layers for model, DAO, service, and UI   
▪ Encapsulation: Student and AttendanceRecord classes with private fields and getters/setters   
▪ Inheritance/Polymorphism: Extendable design for different attendance types (e.g., Present, Late)   
▪ Exception Handling: Invalid student IDs, missing files, data access errors   
▪ Collections: Use of ArrayList, HashSet, and filtering for reports and dashboards .  

## Proposed Architecture Description
The system is built using a layered design to keep things organized and easy to maintain. The Model layer defines 
core classes like Student and Attendance Record. The DAO layer manages file storage and retrieval. The Service layer 
contains the main business logic, such as marking attendance, calculating percentages, and generating reports. 
Finally, the UI layer provides a simple console interface for users, while custom exceptions handle invalid inputs or 
data errors. 
Flow :Add Student → Mark Attendance → Save Records → Process Logic (Percentages, Search, Filters) →Dashboard 
→ Display Results to User

## How to Run
Run the program:
In terminal

The menu-driven system will start.

Follow on-screen options:
Add Student
Mark Attendance
Show All Students
Search Student
Calculate Attendance Percentage
Exit

Data will be automatically saved and loaded from file.

## Git Discipline Notes
Minimum 10 meaningful commits required.
