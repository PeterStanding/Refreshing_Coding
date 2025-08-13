# Multiple Choice Test with N questions, numbered from 1 --> N
# Each questions has 2 options A and B, you know the correct answers in C
# But want to get 0 on the test

def getWrongAnswer(N,C):
    out = ""
    for x in C:
        if x == "A":
            out+= "B"
        else:
            out+= "A"
    return out

print(getWrongAnswer(3,"ABA"))