# leetcode
Java solutions to Leetcode problems with comments and basic test cases for each problem.. 

Todo:
 - Check test line coverage
 - Add checkstyle check.


## Techniques

### Hashing
- rolling hashing
- key counts

### Array, List
- Comparison Sorting
  - Quick sort
  - Merge sort
- Linear Sorting
  - Counting sort
  - Bucket sort
  - Radix sort
- Binary search
- Two pointers
  - end of checked/next to check
  - start/end meet in the middle
- Reverse

### Linked list
- Dummy head node
- Fast/slow pointers, circle detection
- Reverse 


### Stack

### Deque

### Binary Tree & BST
- Traversal
  - Inorder
    - Recursion
    - Stack
    - Morris
  - PostOrder
    - Recursion
    - Stack
    - Morris
  - PreOrder
    - Recursion
    - Stack
    - Morris
  - Level Order
- Searching
  - Find value, next greater, previous smaller in BST
- Updating
  - insert, delete and update of
    - non-balanced
    - balanced
  
- JDK TreeSet, TreeMap
- Serialization and deserialization

### N-ary Tree

### Graph
- DFS
- BFS
- Single node shortest path
- All nodes shortest path


### String
- KMP*
- BMH
- Rabin-Karp
- String parsing
- concat two strings

### Maths
- GCD
- long division
- Group theory
- Handle integer overflow
  - Use long
  - Find max value x such that Op(x) <= INT_MAX and Op(x + 1) overflows
- Pascal's triangle
- Factorial
- Combination and permutation
- Newton's method

### Bit Hacks

### Special
- Trie
- Segment Tree
- Binary Indexed Tree
- Union Find
- JDK util
  - Arrays
  - Collections
  - LinkedHashMap

### Recursion
- Enumerate all combination or permutation.

### Greedy

### Dynamic Programming
Overlapping sub-problems: two sub-problems require the same computation
Optimal sub-structure: easy to find a solution from solutions to sub-problems

- 1d/2d/3d with state

### Symmetric

### Divide and Conquer

Left to right then right to left scan

### Compression/Encoding
- Represent the data in a different way to improve performance. Either compress or decompression (establish indexing or convert to a structure where fast solution exists).

### Relaxation/Generalize
- Map the problem to a more generic one where a solution to the generic one can be easily mapped back to the solution to the original problem
- Sometimes a looser definition of the problem is easier to solve because there will be less conceptual/physical conditions

### Augmented Data Structure



## Development
 

If you are using IntelliJ you still need to configure your email in the git local copy:
<pre>
git config --global user.email "your_email@example.com"
</pre>

How to load JaCoCo coverage results created in the Maven build in IntelliJ
* In the target directory you can find jacoco.exec file, which contains the coverage data 
* Load this file in IntelliJ with Analyze -&gt; Show Coverage Data... (<kbd>Ctrl + Alt + F6</kbd>)
* Note: In IntelliJ 14 you can go up to 0.7.4.201502262128 of JaCoCo Maven plugin, 0.7.5.x data file cannot be correctly loaded
