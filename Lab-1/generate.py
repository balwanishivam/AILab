from enviroment import next_move
import random
import copy

def generate(start,depth):
    mat=start
    for i in range(depth):
        prev=copy.deepcopy(mat)
        next_moves=next_move(mat)
        mat=random.choice(next_moves)
        if mat==start and prev==mat:
            mat=random.choice(next_moves)
    
    return mat

    