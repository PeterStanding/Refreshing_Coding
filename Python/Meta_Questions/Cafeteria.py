# Cafeteria Table consists of a row of N seats, numbered 1 - N from left to right
# Social Distancing requires each diner to be seated such that K seats to left and right remain empty
# There are currently M diners at the table, the ith is in seat Si. No two diners are in the same seat, and guideline are satisfied
# Determine the Max number of additional dineers who can potentially sit at the table without the guidelines being voilated
# Assuming existing diners cannot move and the additional diners will cooperate to maximize how many can sit
#
# Constraints:
# 1 <= N <= 10^15
# 1 <= K <= N
# 1 <= M <= 500,000
# M <= N
# 1 <= Si <= N
from typing import List

def additionalDinersCount(N:int, K:int, M:int, S: List[int]) -> int:
    # N --> Number of Seats in Row
    # K --> Distancing Guidelines
    # M --> Number of Diners
    # S --> Location of Diners
    maxSeats = N - M
    S.sort()
    # Checks if First Seat can fit anyone to the Left, if not Remove that number
    if (S[0] - K) <= 0:
        print("S0")
        maxSeats -= K
    else:
        pass
    # Checks if Last Seat can fit anyone to the Right, if not Remove that number
    if (S[-1] + K) >= N:
        print("S-1")
        maxSeats -= K

    return maxSeats

# Should output 3
# 1 2 3 4 5 6 7 8 9 10
# [ x ] S [ x ] S   SS
# Diners may sit at 4, 8 and 10
#print(additionalDinersCount(10,1,2,[2,6]))
# Should output 1
# Only one diner can join by sitting in any of the first 3
# 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15
#       [   x   ] [    xx  [ ]  xx  ]
print(additionalDinersCount(15,2,3,[11,6,14]))