# 제출시간 : 2021. 8. 24. 오후 2:46:53
T= int(input())

for test_case in range(1, T+1):
    N=int(input())
    arr_2d= [list(map(int, input().split())) for _ in range(N)]
    arr_painted=[[0]*10 for _ in range(10)]
    for info in arr_2d:
        for i in range(info[0],info[2]+1):
            for j in range(info[1],info[3]+1):
                if(arr_painted[i][j]==0):
                    arr_painted[i][j]=info[-1]
                elif(arr_painted[i][j]!=info[-1]):
                    arr_painted[i][j]=3
                    
    count=0
    for i in range(len(arr_painted)):
        for j in range(len(arr_painted[i])):
            if (arr_painted[i][j]==3):
                count = count +1
   
    print(f"#{test_case} {count}")
                