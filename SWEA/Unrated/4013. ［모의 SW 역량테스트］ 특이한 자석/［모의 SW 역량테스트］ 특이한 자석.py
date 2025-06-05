
TC = int(input())

for tc in range(1, TC+1):
    K = int(input())
    lst = [list(map(int, input().split())) for _ in range(4)]
    result = 0
    
    for i in range(K):
        rotate_lst = [0 for _ in range(4)]    
        magnet_num, dir =  list(map(int, input().split()))
        magnet_num = magnet_num-1
        rotate_lst[magnet_num] = dir
        
        
        if(magnet_num != 0):
            for j in range(magnet_num, 0,-1):
                if(lst[j-1][2] == lst[j][-2]):
                    break
                else:
                    rotate_lst[j-1] = 0-dir
                    dir=  0-dir
                
                    
        dir =rotate_lst[magnet_num]
        
        if(magnet_num != 3):
            for l in range(magnet_num,3,1):
                if(lst[l][2] ==lst[l+1][-2]):
                    break
                else:
                    rotate_lst[l+1] = 0-dir
                    dir= 0-dir
                    
        for j in range(4):
            if(rotate_lst[j] == -1):
                lst[j].append(lst[j].pop(0))
            elif(rotate_lst[j] == 1):
                lst[j].insert(0,(lst[j].pop()))
                
    for i in range(4):
        result= result+lst[i][0]*(2**i)
                

    print(f'#{tc} {result}')