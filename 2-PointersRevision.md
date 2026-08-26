# Two Pointers Revision

## When to Use Two Pointers

- Works on **array / linked list**
- Data is either **sorted** or you sort it to simplify the problem
- Problem is phrased as: **rearrange, merge, remove duplicates, subarrays**
- Need to **find more than one thing** — pairs / triplets / quadruplets
- Brute force is O(n²) or O(n³) — two pointers brings it down to **O(n) or O(n²)**

---

## Types of Two Pointer Setups

| Type | Description |
|------|-------------|
| **Opposite ends** | `left = 0`, `right = n-1`, move toward each other |
| **Same direction (slow-fast)** | Both start at 0, fast runs ahead — used for duplicates, in-place edits |
| **Three pointers** | One fixed outer loop + two inner pointers (triplets problems) |

---

## Key Patterns & Tricks

- **Sort first** — makes it easy to decide which pointer to move
- **Skip duplicates** — after finding a valid answer, skip equal elements to avoid repeats
- **Shrink window** — if sum > target → move `right--`, if sum < target → move `left++`
- **Count valid pairs** — if `sum < target`, all elements between `left` and `right` are valid → add `right - left` directly (avoids inner loop)
- **In-place editing** — use a slow pointer `i` to track the write position, fast pointer `j` to scan

---

## Problems Solved

| Problem | Approach | Time |
|---------|----------|------|
| **Two Sum (sorted)** | Opposite ends, move based on sum vs target | O(n) |
| **Sorted Squares** | Opposite ends, fill result from back | O(n) |
| **Remove Duplicates** | Slow-fast same direction | O(n) |
| **Sort Colors (Dutch Flag)** | 3 pointers: low, mid, high | O(n) |
| **Triplets with Sum Zero** | Fix one + opposite ends, skip duplicates | O(n²) |
| **Triplets Closest to Target** | Fix one + opposite ends, track min diff | O(n²) |
| **Triplets Sum Smaller** | Fix one + opposite ends, count with `right - left` | O(n²) |

---

## Common Mistakes

- Forgetting to **skip duplicates** after recording a valid triplet/pair
- Using `left < right` vs `left <= right` — use `<=` only when both pointers can land on the same index (e.g. Sorted Squares)
- Not sorting the array before applying two pointers
- Updating `closestSum` **outside** the if-else block so every sum is compared
