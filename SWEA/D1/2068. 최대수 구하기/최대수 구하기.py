#완전 탐색, 그리디? 

T=int(input())

for test_case in range(1,T+1):
    
    num_list=map(int,input().split())
    max_num=0  
    """
    if len(num_list)>0:
       max_num=num_list[0]
    esle:
       max_num=0    
    """
    for x in num_list:
        if max_num<x:
            max_num=x
    print(f'#{test_case} {max_num}')