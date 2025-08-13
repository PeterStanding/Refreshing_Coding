# Trying to Open a lock, wheel has integers 1 -> N
# Wheel initally points at 1
# It Takes 1 seconds to rotate the wheel 1 place in either direction, and the lock will open if you enter a certain code
# Code is sequence of M integers, which is C
# Determine the min number of seconds required to select all M of code in order

# Solution found on link below
# https://www.youtube.com/watch?v=9gYwDmPRZrw

def getMinCodeEntryTime(N,M,C):
    st = 1
    out = 0
    for x in C:
        out += min((st-x)%N,(x-st)%N)
        st = x
    return out

#Should output 2
print(getMinCodeEntryTime(3,3,[1,2,3]))
#Should output 11
print(getMinCodeEntryTime(10,4,[9,4,4,8]))