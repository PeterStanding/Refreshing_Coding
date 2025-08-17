# https://www.geeksforgeeks.org/python/sorting-algorithms-in-python/
# Bubble Sort
# Bubble Sort is the simplest sorting algorithm that works by repeatedly swapping the adjacent elements if they are in the wrong order

# Bubble sort algorithm, sorts an array by repeatedly comparing adjacent elements and swapping them if they are in the wrong order
# The algorithm iterated through the array multiple times, with each pass pushing the largest unsorted element to its correct position at the end
# Code includes an optimization: If no swaps are made during a pass, the array is already sorted, and the sorting process stops


# https://www.geeksforgeeks.org/python/python-program-for-bubble-sort/
def bubble_sort(arr):
    #Outer loop to iterate through the list n times
    for n in range(len(arr) - 1, 0, -1):
        #Initialize swapped to track if any swaps occur
        swapped = False
        #Inner Loop to compare adjacent Elements
        for i in range(n):
            if arr[i] > arr[i + 1]:
                #Swap elements if they are in the wrong order
                arr[i], arr[i + 1] = arr[i + 1], arr[i]
                #Mark that the swap has occured
                swapped = True

        #If no swaps occured, the list is already sorted
        if not swapped:
            break

# Examples
arr = [6,6,2]
print("Unsorted list is:")
print(arr)

bubble_sort(arr)

print("Sorted list is:")
print(arr)