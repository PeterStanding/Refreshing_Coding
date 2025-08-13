# You're playing Battleship on a grid of cells with
# R rows and C columns. There are 0 or more Ships on the grid, each occupying a single distinct Cell
# The cell in the ith row from the top and jth column from the left either contains a battleship (Gi,j=1) or doesn't (Gi,j=0).
# Fire a single shot at random into the grid, interested in the Probability that the cell hit by shot contains a ship

def probabilityOfHit(R,C,G):
    # R = Number of Rows, C = Number of Columns, G = Grid
    count = 0.0
    for x in range(R):
        for y in range(C):
            if G[x][y] == 1:
                count += 1
    return count / (R * C)

#Should return 0.5
print(probabilityOfHit(2,3,[[0,0,1],[1,0,1]]))
#Should return 1.0
print(probabilityOfHit(2,2,[[1,1],[1,1]]))