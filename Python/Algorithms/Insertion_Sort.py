# https://www.geeksforgeeks.org/python/sorting-algorithms-in-python/
# Insertion Sort
# Insertion sort is a simple sorting algorithm that works by iteratively inserting each element
# of an unsorted list into its correct position in a sorted portion of the list

#   The insertionSort function takes an array arr as input. It caluclates the length of the array (n). If the length is 0 or 1, the function returns immediatley as an array with 0 or 1 is considered sorted
#   For arrays with more than one element, we start with the second element of the array as first element is assumed sorted
#   Compare second element with the first element and check if the second element is smaller then swap them
#   Move to the third element and compare it with the first two elements and put at its correct position
#   Repeat until the entire Array is sorted

# https://www.geeksforgeeks.org/python/python-program-for-insertion-sort/
def insertionSort(arr):
    n = len(arr) #Get length of Array
    if n <=1:
        return # If array has 0 or 1 elements, its already sorted
    for i in range(1,n): # Iterate over the array starting from second position
        key = arr[i] # Store current element as key to be inserted into correct position
        j = i-1
        while j >= 0 and key < arr[j]: # Move elements greater than key one position ahead
            arr[j+1] = arr[j] # Shift elements to the right
            j -= 1
        arr[j+1] = key # Insert the key in the correct position
# Sorting the array [12, 11, 13, 5, 6] using insertionSort
arr = [12, 11, 13, 5, 6]
print(arr)
insertionSort(arr)
print(arr)