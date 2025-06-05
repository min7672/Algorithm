#제출시간 : 2021. 8. 21. 오전 10:37:11

T=int(input())

for test_case in range(1,T+1):
    N, M = map(int,input().split())
    arr=list(map(int,input().split()))
    #exhaust search , N-M+1

    sum=0
    
    for i in range(0,M):
        sum=sum+arr[i]
    max=min=sum
    for i in range(1, N-M+1):
        sum=0
        for j in range(i,i+M):
            sum=sum+arr[j]
            
        
        max = sum if( sum >max) else max
        min = sum if ( sum < min) else min
  
    print(f"#{test_case} {max-min}")
