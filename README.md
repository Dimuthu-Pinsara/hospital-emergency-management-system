# Mini Hospital Emergency Management System

## Project Explanation

This is a console-based Java application for managing patients in a hospital emergency unit. It demonstrates how common data structures can be used in a practical system.

The system supports patient registration, patient searching and deletion, emergency queue management, treatment history, and patient visit history.

## Data Structures Used

- **Binary Search Tree (BST):** Stores patient records using the patient ID as the key. Supports insertion, searching, deletion, and in-order display.
- **Queue:** Stores patients waiting for emergency treatment using the FIFO principle.
- **Stack:** Stores completed treatment records using the LIFO principle.
- **Singly Linked List:** Stores each patient's previous hospital visits. Supports adding, searching, removing, and displaying visits.

## Project Structure

```text
src/
├── Main.java
├── Patient.java
├── PatientBST.java
├── EmergencyQueue.java
├── TreatmentRecord.java
├── TreatmentStack.java
├── Visit.java
├── VisitHistory.java
└── HospitalSystem.java
```

## Main Menu Features

1. Register a patient
2. Search for a patient
3. Delete a patient
4. Display all patients in ascending patient ID order
5. Add a patient to the emergency queue
6. Treat the next waiting patient
7. Display the waiting queue
8. Complete a treatment and store the record
9. View treatment history
10. Remove the latest treatment record
11. Add a patient visit
12. Search for a patient visit
13. Remove a patient visit
14. Display a patient's visit history
0. Exit

## Requirements

- Java JDK 14 or newer
- A terminal or Java-supported IDE

The application uses modern Java switch syntax, so Java 14 or newer is recommended.

## How to Run

Open a terminal in the project directory:

```bash
cd "/Users/rightmo_web_solutions/Desktop/My Projects/hospital-emergency-management-system"
```

Compile the source files into an output directory:

```bash
mkdir -p out
javac -d out src/*.java
```

Run the application:

```bash
java -cp out Main
```

On Windows PowerShell, use these equivalent commands from the project directory:

```powershell
New-Item -ItemType Directory -Force out
javac -d out src\*.java
java -cp out Main
```

## Example Patient Workflow

1. Select **Register patient**.
2. Enter patient ID `1005`.
3. Enter patient name `Amal Perera`.
4. Enter age `25`.
5. Enter contact number `0771234567`.
6. Enter medical condition `Chest pain`.
7. Add the patient to the emergency queue.
8. Treat the next patient and record the completed treatment.
9. Add or view the patient's previous visits.

## Testing

The project can be tested by compiling and running it, then checking the following operations:

- Register, search, display, and delete patients
- Enqueue and dequeue emergency patients
- Push, display, and pop treatment records
- Add, search, display, and remove patient visits
- Attempt operations on empty queues, stacks, and visit histories
