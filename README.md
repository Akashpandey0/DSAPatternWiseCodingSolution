# 📘 DSA Patterns Cheat Sheet — When to Use What

> A quick reference guide for recognizing patterns in LeetCode & GFG problems.

---

## 🔁 1. Two Pointers

**When to use:**
- Array/string is **sorted** or needs to be traversed from both ends
- Finding pairs, triplets with a target sum
- Removing duplicates in-place
- Comparing characters from start and end (palindrome)

**Trigger keywords:** "sorted array", "pair with sum", "remove duplicates", "palindrome"

**Classic Problems:**
| Problem | Platform |
|--------|----------|
| Two Sum II | LeetCode #167 |
| 3Sum | LeetCode #15 |
| Squares of a Sorted Array | LeetCode #977 |
| Valid Palindrome | LeetCode #125 |
| Container With Most Water | LeetCode #11 |

---

## 🪟 2. Sliding Window

**When to use:**
- Subarray/substring of **fixed or variable size**
- Finding max/min/longest/shortest contiguous block
- "At most K distinct", "longest without repeating"
- Flip at most K zeros, binary subarrays

**Trigger keywords:** "subarray", "substring", "contiguous", "window", "at most K", "consecutive 1s", "flip", "distinct characters"

**Sub-patterns:**
- **Fixed Window** → window size K is given, slide without shrinking
- **Variable Window (expand/shrink)** → grow right, shrink left when condition breaks

**Code Template (Variable Window):**
```java
int left = 0, maxLen = 0;
Map<?, Integer> map = new HashMap<>(); // or int[] freq

for (int right = 0; right < n; right++) {
    // 1. Add nums[right] to window

    // 2. Shrink from left while window is invalid
    while (/* invalid condition */) {
        // remove nums[left] from window
        left++;
    }

    // 3. Update answer
    maxLen = Math.max(maxLen, right - left + 1);
}
```

**Classic Problems:**
| Problem | Platform | Type |
|--------|----------|------|
| Maximum Sum Subarray of Size K | GFG | Fixed |
| Minimum Size Subarray Sum | LeetCode #209 | Variable |
| Longest Substring Without Repeating Characters | LeetCode #3 | Variable |
| Longest Substring with K Uniques | GFG | Variable |
| Fruit Into Baskets | LeetCode #904 | Variable |
| Max Consecutive Ones II (flip 1 zero) | LeetCode #487 | Variable |
| Max Consecutive Ones III (flip K zeros) | LeetCode #1004 | Variable |
| Longest Repeating Character Replacement | LeetCode #424 | Variable |

---

## 🔍 3. Binary Search

**When to use:**
- Array is **sorted** or answer lies in a **monotonic range**
- "Find minimum/maximum satisfying condition"
- Search in rotated array

**Trigger keywords:** "sorted", "find position", "minimum capacity", "rotated array"

**Classic Problems:**
| Problem | Platform |
|--------|----------|
| Binary Search | LeetCode #704 |
| Search in Rotated Sorted Array | LeetCode #33 |
| Find Minimum in Rotated Array | LeetCode #153 |
| Koko Eating Bananas | LeetCode #875 |
| Aggressive Cows | GFG |

---

## 🔗 4. Fast & Slow Pointers (Floyd's Cycle)

**When to use:**
- Detecting **cycle** in linked list or array
- Finding **middle** of linked list
- Finding start of cycle

**Trigger keywords:** "cycle", "loop", "middle node", "linked list"

**Classic Problems:**
| Problem | Platform |
|--------|----------|
| Linked List Cycle | LeetCode #141 |
| Find the Duplicate Number | LeetCode #287 |
| Middle of Linked List | LeetCode #876 |
| Happy Number | LeetCode #202 |

---

## 🌲 5. Tree Traversals (DFS / BFS)

**When to use:**
- **BFS** → Level-order, shortest path in unweighted graph/tree
- **DFS** → Path sum, subtree problems, backtracking on tree

**Trigger keywords:** "level order", "shortest path", "root to leaf", "subtree"

**Classic Problems:**
| Problem | Platform |
|--------|----------|
| Binary Tree Level Order Traversal | LeetCode #102 |
| Maximum Depth of Binary Tree | LeetCode #104 |
| Path Sum | LeetCode #112 |
| Lowest Common Ancestor | LeetCode #236 |
| Left View of Binary Tree | GFG |

---

## 🔙 6. Backtracking

**When to use:**
- Generate **all combinations/permutations/subsets**
- Constraint satisfaction (N-Queens, Sudoku)
- "Find all possible ways"

**Trigger keywords:** "all combinations", "permutations", "subsets", "generate all"

**Classic Problems:**
| Problem | Platform |
|--------|----------|
| Subsets | LeetCode #78 |
| Permutations | LeetCode #46 |
| Combination Sum | LeetCode #39 |
| N-Queens | LeetCode #51 |
| Rat in a Maze | GFG |

---

## 🧮 7. Dynamic Programming (DP)

**When to use:**
- Problem has **overlapping subproblems** + **optimal substructure**
- "Count ways", "minimum cost", "maximum profit"
- Decision at each step affects future

**Trigger keywords:** "minimum/maximum", "count ways", "longest", "can you reach"

**Sub-patterns:**
- 0/1 Knapsack → include or exclude item
- Unbounded Knapsack → item can be reused
- LCS/LIS → subsequence problems
- DP on Grids → paths in matrix

**Classic Problems:**
| Problem | Platform |
|--------|----------|
| Climbing Stairs | LeetCode #70 |
| 0/1 Knapsack | GFG |
| Longest Common Subsequence | LeetCode #1143 |
| Coin Change | LeetCode #322 |
| House Robber | LeetCode #198 |

---

## 📊 8. Heap / Priority Queue

**When to use:**
- "Top K elements", "K closest", "K largest/smallest"
- Merge K sorted lists
- Continuously finding min/max from a stream

**Trigger keywords:** "K largest", "K smallest", "top K", "median stream"

**Classic Problems:**
| Problem | Platform |
|--------|----------|
| Kth Largest Element | LeetCode #215 |
| Top K Frequent Elements | LeetCode #347 |
| Merge K Sorted Lists | LeetCode #23 |
| Find Median from Data Stream | LeetCode #295 |

---

## 🗺️ 9. Graph (BFS / DFS / Union-Find)

**When to use:**
- Connected components, islands
- Shortest path (BFS for unweighted, Dijkstra for weighted)
- Cycle detection, topological sort

**Trigger keywords:** "islands", "connected", "shortest path", "dependencies", "course schedule"

**Classic Problems:**
| Problem | Platform |
|--------|----------|
| Number of Islands | LeetCode #200 |
| Course Schedule | LeetCode #207 |
| Clone Graph | LeetCode #133 |
| Dijkstra's Algorithm | GFG |
| Flood Fill | LeetCode #733 |

---

## 🔢 10. Prefix Sum

**When to use:**
- Range sum queries on array
- Subarray sum equals K
- 2D matrix range queries

**Trigger keywords:** "range sum", "subarray sum", "sum between indices"

**Classic Problems:**
| Problem | Platform |
|--------|----------|
| Range Sum Query | LeetCode #303 |
| Subarray Sum Equals K | LeetCode #560 |
| Product of Array Except Self | LeetCode #238 |

---

## 🧩 11. Monotonic Stack

**When to use:**
- Next greater/smaller element
- Largest rectangle problems
- "Span", "temperature", "stock prices"

**Trigger keywords:** "next greater", "next smaller", "daily temperatures", "histogram"

**Classic Problems:**
| Problem | Platform |
|--------|----------|
| Daily Temperatures | LeetCode #739 |
| Next Greater Element | LeetCode #496 |
| Largest Rectangle in Histogram | LeetCode #84 |
| Stock Span Problem | GFG |

---

## 🧠 Quick Pattern Recognition Table

| Clue in Problem | Pattern to Use |
|----------------|----------------|
| Sorted array + pair/triplet | Two Pointers |
| Subarray / substring window | Sliding Window |
| Sorted + find position | Binary Search |
| Linked list cycle / middle | Fast & Slow Pointers |
| Level-by-level tree | BFS |
| All combinations / subsets | Backtracking |
| Min/max with choices | Dynamic Programming |
| Top K elements | Heap |
| Islands / connected components | Graph DFS/BFS |
| Range sum queries | Prefix Sum |
| Next greater element | Monotonic Stack |

---

> ⭐ Star this repo if it helped you! Feel free to contribute more patterns.
