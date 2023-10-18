# Todo App

This is a simple Java command-line application for managing a to-do list. It allows you to add, edit, and delete tasks, as well as mark them as completed or not completed. The program uses a menu-based interface, and it stores tasks and their statuses in two separate dictionaries.

## Features

- **Check Your Todo List**: View your current to-do list, including task numbers, task descriptions, and their completion status.

- **Add New Todo**: Add a new task to your to-do list.

- **Edit Task Status**: Edit the completion status (Yes/No) of a specific task.

- **Delete Task**: Remove a task from your to-do list.

- **Exit**: Close the application.

## How to Use

1. Run the program by executing the `Todo.java` file.
   ```
   java Todo.java
   ```
2. Use the menu to navigate the different features.
3. To add a new task, select option 2 and provide the task description. Type 'exit' to finish adding tasks.
4. To edit a task's completion status, select option 1 to check the to-do list, then enter the task number and the new status (Yes/No) when prompted.
5. To delete a task, select option 3 to delete a task, then enter the task number when prompted.
6. To exit the application, select option 4.

## Code Structure
* `Todo.java`: The main Java file that contains the application logic.
* `Dictionary`: A Java interface for storing key-value pairs, used to manage tasks and their statuses.
* `Hashtable`: A class implementing the Dictionary interface for storing and managing tasks and their statuses.

## Compatibility
This program is written in Java and should be compatible with Java 8 and later versions.

## Contributing
If you would like to contribute to this project, feel free to submit a pull request or open an issue on GitHub.
