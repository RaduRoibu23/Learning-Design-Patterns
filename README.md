## Design Patterns Used in the Project

This project utilizes several design patterns to ensure code reusability, maintainability, and scalability. Below is a description of the design patterns used, their benefits, and where they are implemented within the project.

### Singleton Pattern
**Class:** `Database`

**Description:** The Singleton pattern ensures that a class has only one instance and provides a global point of access to it.

**Benefits:**
- **Controlled Access to a Single Instance:** Ensures that there is only one instance of the class, reducing memory usage.
- **Lazy Initialization:** The instance is created only when it is needed, which can improve performance if the instance is resource-intensive to create.

---

### Factory Pattern
**Class:** `CommandExecutor`

**Description:** The Factory pattern provides a way to create objects without specifying the exact class of the object that will be created.

**Benefits:**
- **Encapsulation:** The creation logic is encapsulated in a single place, making the code easier to manage and understand.
- **Scalability:** New command types can be added without modifying the existing code, adhering to the Open/Closed Principle.

---

### Command Pattern
**Classes:** Various command classes like `CreateUser`, `AddFriend`, etc.

**Description:** The Command pattern encapsulates a request as an object, thereby allowing for parameterization of clients with queues, requests, and operations.

**Benefits:**
- **Decoupling:** The sender of the request is decoupled from the object that performs the action.
- **Flexibility:** Commands can be manipulated, stored, and passed around as objects.

---

### How It Works
1. **Initialization:** The `Main` class initializes the `Database` and `CommandExecutor` singletons.
2. **Command Execution:** The `Main` class reads commands from a file and uses the `CommandExecutor` to create command objects.
3. **Execution:** Each command object is executed, performing the specified action.

By using these design patterns, the project achieves a high level of modularity and flexibility, making it easier to maintain and extend.
