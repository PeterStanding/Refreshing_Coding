# https://www.geeksforgeeks.org/dsa/searching-algorithms-in-python/
# Interpolation Search
# It's an improved version of binary search, especially suitable for large and uniformly distributed arrays
# It calculates the probable position of the target value based on the value of the key and the range of the search space

#Steps
#   Calculate the probable position of the target value using interpolation formula
#   Compare the target value with the element at the calculated position
#   If the element matches the target value, return index
#   If the element is less than the target value, search in the right half of the list
#   If the element is greater than the target value, search in the left half of the list
#   Repeat steps 1-5 until the target value is found or the search interval is empty

import math

def interpolation_search(arr, target):
#   Parameters:
#   arr (list): The sorted list can be searched
#   target:     The value to tbe searched for

#   Returns:
#   int:        The index of the target value if found, otherwise -1
    low = 0
    high = len(arr) - 1
    while low <= high and target >= arr[low] and target <= arr[high]:
        pos = low + ((high - low) // (arr[high] - arr[low])) * (target - arr[low])
        if arr[pos] == target:
            return pos
        elif arr[pos] < target:
            low = pos + 1
        else:
            high = pos - 1
    return -1

# Example
arr = [2, 3, 4, 10, 40]
target = 10
result = interpolation_search(sorted(arr), target)
if result != -1:
    print(f"Interpolation Search: Element found at index {result}")
else:
    print("Interpolation Search: Element not found")