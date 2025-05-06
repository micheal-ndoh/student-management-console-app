# student-management-console-app


### 🔹 Java Memory Model
The Java Memory Model defines **how Java programs store and share data in memory**, especially when **multiple threads** (like workers) are running at the same time.

It has different parts:

* **Heap** – A shared area where all objects and class instances live. Every thread can access it.
* **Stack** – Each thread has its own space for method calls and local variables. Not shared.
* **Method Area** – Stores information about classes and static variables.
* **Program Counter** – Keeps track of where each thread is in the code.

When multiple threads access the same data, the JMM makes sure:

* Threads **see the latest changes** (visibility).
* **Actions happen in the correct order** (ordering).
* Some actions are done **safely, without being interrupted** (atomicity).

This model helps prevent bugs like **race conditions**, where two threads change the same data at the same time without proper coordination.

### 🔹 JVM Memory Structure

* **Heap Memory**: Divided into **Young Generation** and **Old Generation**.

  * **Young Generation**: Where new objects are created. Divided into **Eden** and two **Survivor** spaces.

    * **Minor GC**: Happens when Eden is full; surviving objects are moved to Survivor spaces.
    * After multiple GCs, objects are promoted to Old Generation.
  * **Old Generation**: Stores long-lived objects. When full, **Major GC** (slower) is triggered.

* **PermGen (Permanent Generation)**: Holds JVM metadata like class and method info (not part of heap).

  * **Method Area**: Stores class structure, constants, and method code.
  * **Runtime Constant Pool**: Contains per-class runtime constants.

* **Stack Memory**: Thread-specific, short-lived data like local variables and method calls.

* **Memory Pools**: Pools like String Pool optimize reuse of immutable objects.

---

### 🔹 Garbage Collection (GC)

* **GC Types**:

  1. **Serial GC**: Simple and single-threaded; best for small applications.
  2. **Parallel GC**: Multi-threaded Minor GC; uses single thread for Major GC.
  3. **Parallel Old GC**: Multi-threaded for both Minor and Major GC.
  4. **CMS (Concurrent Mark Sweep)**: Low-pause collector for responsive apps.
  5. **G1 GC (Garbage First)**: Splits heap into regions; collects low-live-data regions first. Suitable for large heaps and low-latency apps.

* **GC Phases**:

  1. **Marking**: Identify used vs. unused objects.
  2. **Deletion**: Remove unused objects.
  3. **Compacting**: Rearrange memory to reduce fragmentation.

* **Stop the World**: All GCs pause application threads during collection. Major GCs cause longer pauses than Minor GCs.

---

### 🔹 JVM Memory Tuning Options

| Switch                         | Description            |
| ------------------------------ | ---------------------- |
| `-Xms`                         | Initial heap size      |
| `-Xmx`                         | Max heap size          |
| `-Xmn`                         | Young Generation size  |
| `-XX:PermSize` / `MaxPermSize` | PermGen size           |
| `-XX:SurvivorRatio`            | Eden to Survivor ratio |
| `-XX:NewRatio`                 | Old to Young ratio     |


### 🔹 Monitoring Tools

* **jstat**: CLI tool to monitor memory and GC activity. Requires process ID.
* **VisualVM**: GUI-based monitoring; supports Visual GC plugin to graphically view GC and memory usage.

