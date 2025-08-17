# https://www.geeksforgeeks.org/dsa/searching-algorithms-in-python/
# LINEAR SEARCH
# Simplest Searching algorithm. It sequentially checks each element of the list until it finds the target value
# Steps:
#   Start from the first element of the list
#   Compare each element of the list with the target Value
#   If element matches the target value, return its index
#   If the target value is not found after iterating through the entire list, return -1

def linear_search(arr, target):
    # Parameters:
    # arr (List):   The list to be searched
    # target:       The Value to be searched for

    # Returns:
    # int:          The index of the target value if found, otherwise -1
    for i in range(len(arr)):
        if arr[i] == target:
            return i
    return -1

#Example
arr = [2,3,4,10,40]
target = 10
result = linear_search(arr, target)
if result != -1:
    print(f"Linear Search: Element found at index: {result}")
else:
    print("Linear Search: Element not found")