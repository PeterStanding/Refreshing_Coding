# Given 3 Integers A, B and C determine their sum
# Implement a function which returns A+B+C
# A, B, C are all 1<= X <= 100

def getSum(A,B,C):
    if A >=1 and B >= 1 and C >= 1\
            and A <=100 and B <=100 and C <=100:
        return A + B + C

# Test Cases from Meta Website
print(getSum(1,2,3))
print(getSum(100,100,100))
print(getSum(85, 16, 93))