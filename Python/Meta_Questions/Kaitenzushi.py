# There are N dishes in a row on a kaiten belt, with the ith dish being of type Di. Some dishes may be of the same type as one another.
# You're very hungry, but you'd also like to keep things interesting. The N dishes will arrive in front of you, one after another in order,
# and for each one you'll eat it as long as it isn't the same type as any of the previous K dishes you've eaten.
# You eat very fast, so you can consume a dish before the next one gets to you. Any dishes you choose not to eat as they pass will be eaten by others.
# Determine how many dishes you'll end up eating.
# Please take care to write a solution which runs within the time limit.

# Constraints
# 1 <= N <= 500,000
# 1 <= K <= N
# 1 <= D <= 1,000,000


# Passes on All Tests expect 1 which exceeds the time limit
from typing import List
def dishCount(N: int, D: List[int], K:int) -> int:
    # N --> Dished in Row
    # D --> Dish Order
    # K --> Previous Number
    count = 0
    prev = []
    for x in D:
        if prev.__contains__(x):
            pass
        else:
            count += 1
            if len(prev) == K:
                prev.pop(0)
                prev.append(x)
            else:
                prev.append(x)

    return count



# Should return 5
print(dishCount(6, [1,2,3,3,2,1], 1))
# Should return 4
print(dishCount(6, [1,2,3,3,2,1], 2))
# Should return 2
print(dishCount(7, [1,2,1,2,1,2,1], 2))