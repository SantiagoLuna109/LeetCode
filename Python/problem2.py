import bisect 
from typing import List
class Solution(object):
    def minPatches(self, nums, n):
        patches = 0
        i = 0
        acum = 1 #pk iniciamos en 1
        while acum <= n:
            if i < len(nums) and nums[i] <= acum:#Eran separados pero pro esto funciono idk
                acum += nums[i]#aumenta lo que equivalga el numero
                #print('acum ',acum)
                i+=1
                #print('i ',i)
            else:
                patches += 1 #Si no entra quieer decir que ocupamos un patch
                #print('patches ',patches)
                acum += acum #aumenta en si pk vamos por el sigueinte nummero y ya teneindo en cuenta el patch     
                #print('acum2 ',acum)

        return patches
        
        

        
