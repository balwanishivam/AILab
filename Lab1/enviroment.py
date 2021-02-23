def swap(li, pos1, pos2):
        #function to copy the list and perform swap
        li_copy=[]
        li_copy.extend(li)
        li_copy[pos1],li_copy[pos2] = li_copy[pos2], li_copy[pos1]
        return li_copy

def next_move(list_original):
    dict={0: [1,3],     #defining_dictionary
          1: [0,2,4],
          2: [1,5],
          3: [0,4,6],
          4 :[1,3,5,7],
          5: [2,4,8],
          6: [3,7],
          7: [4,6,8],
          8: [5,7] }
    #storing the position of dash      
    zero_index=list_original.index(0)
    possible_paths=[]    
    values_i=[]
        
    #storing no. of times loop will go and for what values
    values_i.extend([dict.get(zero_index)])
    for x in values_i[0]:
        possible_paths.append( swap(list_original,zero_index,x) )
    return possible_paths