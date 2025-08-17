# https://www.geeksforgeeks.org/dsa/searching-algorithms-in-python/
# Binary Search
# Binary Search is a more efficient searching algorithm suitable for sorted lists
# It repeatedly divides the search interval in half until the target is found

# Steps
#   Start with the entire sorted list
#   Compute the middle of the list
#   If the middle element is equal to the target value, return index
#   If the middle element is less than the target value, search in the right half of the list
#   If the middle element is greater than the target value, search in the left half of the list
#   Repeat steps 2-5 until the target value is found or te search interval is empty

def binary_search(arr, target, low, high):
#     Parameters:
#     arr(list):    The sorted list to be searched.
#     target:       The value to be searched for.
#     low(int):     The lower index of the search interval.
#     high(int):    The upper index of the search interval.

#     Returns:
#     int: The index of the target value if found, otherwise - 1.
    if low <= high:
        mid = (low+high)//2
        if arr[mid] == target:
            return mid
        elif arr[mid] < target:
            return binary_search(arr, target, mid+1, high)
        else:
            return binary_search(arr, target, low, mid-1)
    else:
        return -1
# Binary Search Without Recursion
# https://www.tutorialspoint.com/python-program-to-implement-binary-search-without-recursion
def binary_search_while(arr, target):
    L, R = 0, len(arr)-1
    while L <= R:
        mid = (L+R)//2
        if arr[mid] < target:
            L = mid+1
        elif arr[mid] > target:
            R = mid-1
        else:
            return mid
    return -1

#Example
arr = [2,3,4,10,40]
target = 10
#result = binary_search(sorted(arr), target, 0, len(arr)-1)
result = binary_search_while(sorted(arr), target)
if result != -1:
    print(f"Binary Search Result: Element found at index: {result}")
else:
    print(f"Binary Search Result: Element not found")