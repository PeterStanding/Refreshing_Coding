# https://www.geeksforgeeks.org/python/sorting-algorithms-in-python/
# Selection Sort
# Selection Sort is a compsarison based sorting algorithm. It sorts an array by repeatedly selecting the smallest (or Largest) element
# from the unsorted portion and swappinf it with the first unsorted element. This process continues until the entire array is sorted

#   First we find the smallest element and swap it with the first element. This way we get the smallest element in the correct position
#   Then we find the smallest amnong the rest (or second smallest) and swap it with the second element
#   We keep doing this until we get all the elements moved into the correct position
# https://www.geeksforgeeks.org/python/python-program-for-selection-sort/

def selectionSort(arr, size):
    for ind in range(size):
        min_index = ind

        for j in range(ind+1, size):
            #Select the minimum element in every iteration
            if arr[j] < arr[min_index]:
                min_index = j
        # Swapping the elements to sort the array
        (arr[ind], arr[min_index]) = (arr[min_index], arr[ind])

arr = [-2, 45, 0, 11, -9,88,-97,-202,747]
size = len(arr)
print('The array before sorting by selection sort is:')
print(arr)
selectionSort(arr, size)
print('The array after sorting in Ascending Order by selection sort is:')
print(arr)