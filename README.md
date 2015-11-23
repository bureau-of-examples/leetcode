# leetcode
Java solutions to Leetcode problems with comments and basic test cases for each problem.. 



Todo:
 - Check test line coverage
 - Add checkstyle check.


## Techniques:

### Sorting
- The solution is a particular order of items, define the order relationship and sort
- Sort to establish an index which improves time complexity

### Binary Search

### Compression/Encoding
- Represent the data in a different way to improve performance.Either compress or decompression (establish indexing or convert to a structure where fast solution exists).

### DP
- Overlapping sub-problems: two sub-problems require the same computation
- Optimal sub-structure: easy to find a solution from solutions to sub-problems

### Relaxation/Generalize
- Map the problem to a more generic one where a solution to the generic one can be easily mapped back to the solution to the original problem
- Sometimes a looser definition of the problem is easier to solve because there will be less conceptual/physical conditions

### Recursion
- Enumerate all combination or permutation.


### Special
- Reverse sentence and then reverse each word
- 



If you are using IntelliJ you still need to configure your email in the git local copy:
<pre>
git config --global user.email "your_email@example.com"
</pre>

How to load JaCoCo coverage results created in the Maven build in IntelliJ
* In the target directory you can find jacoco.exec file, which contains the coverage data 
* Load this file in IntelliJ with Analyze -&gt; Show Coverage Data... (<kbd>Ctrl + Alt + F6</kbd>)
* Note: In IntelliJ 14 you can go up to 0.7.4.201502262128 of JaCoCo Maven plugin, 7.5.x data file cannot be correctly loaded
