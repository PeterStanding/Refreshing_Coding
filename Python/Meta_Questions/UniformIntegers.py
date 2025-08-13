# Positive integer is uniform if all the digits are the same e.g. 222, 111, 99
# Given 2 positive integers A and B, determine the number of uniform integers between A and B
# Constraint 1<= A <= B <= 10^12

def uniformInts(A,B):
    curr = ""
    total = 0
    for x in range(A,B+1):
         curr = str(x)
         if curr.count(curr[0]) == len(curr):
             total += 1
    return total

#Should return 5
print(uniformInts(75,300))
#Should return 9
print(uniformInts(1,9))
#Should return 1
print(uniformInts(999999999999,999999999999))

# https://stackoverflow.com/questions/13905936/converting-integer-to-digit-list/51092473 Converting an Int to String list
#curr = list(map(int,str(x)))
#curr.sort()
# if curr[0] == curr[-1]:
#       uniList.append(curr)
# elif len(curr) == 1:
#       uniList.append(curr)