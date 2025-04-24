# Rearrange-String-k-Distance-Apart
Given a string s and an integer k, rearrange the characters in s such that the same characters are at least distance k from each other.
Explanation:
Frequency Map: Count how many times each character appears.

Max Heap: We use a priority queue to always place the character with the highest remaining frequency.

Wait Queue (Size k): Once a character is used, we put it in a wait queue of size k. This ensures that the same character isn't reused too soon.

Placement & Checking:

If a character’s frequency is still greater than 0 after using it, it will be added back to the heap only after k characters have been placed in between.

Final Validation:

If the result’s length matches the original string, the rearrangement is valid.

Otherwise, it wasn’t possible (return "").
