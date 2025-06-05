# 제출시간 : 2021. 9. 1. 오전 9:29:22 
T =  int(input())

for test_case in range(1,T+1):
    N, M = map(int, input().split())
    arr = [input() for _ in range(N)]
    for j in range(N):

        for i in range(N-M+1):

            cnt1=0
            cnt2=0
            for k in range(M//2):
                if(arr[j][i+k]==arr[j][i+M-1-k]):
                    cnt1=cnt1+1
                if(arr[i+k][j]==arr[i+M-1-k][j]):
                     cnt2=cnt2+1
            
            if(cnt1==M//2):
                print(f"#{test_case} {arr[j][i:i+M]}")
            if(cnt2==M//2 ):
                result=[]
                for n in range(M):
                    result.append(arr[i+n][j])
                print(f"#{test_case} {''.join(result)}")
            