# https://www.geeksforgeeks.org/dsa/searching-algorithms-in-python/
# JUMP SEARCH

# Jump search is another searching algorithm for sorted arrays.
# It jumps ahead by a fixed number of steps and then performs a linear search in the smaller range
# STEPS
#   Determine the block size to jump ahead
#   Jump ahead by block size until the target value is greater than the current block's last element
#   Perform linear search within the current block to find the target value
#   If the target value is found, return index
#   If the target value is not found after iterating through al blocks, return -1

import math

def jump_search(arr, target):
#   Parameters:
#   arr(List):  The sorted list to be searched
#   target:     The value to be searched for

#   Returns:
#   int:        The index of the target to be found, otherwise -1
    n = len(arr)
    step = int(math.sqrt(n))
    prev = 0
    while arr[min(step,n)-1] < target:
        prev = step
        step += int(math.sqrt(n))
        if prev >= n:
            return -1
    while arr[prev] < target:
        prev += 1
        if prev == min(step,n):
            return -1
    if arr[prev] == target:
        return prev
    return -1

#Example
arr = [2, 3, 4, 10, 40]
target = 10
result = jump_search(sorted(arr), target)
if result != -1:
    print(f"Jump Search: Element found at index {result}")
else:
    print("Jump Search: Element not found")