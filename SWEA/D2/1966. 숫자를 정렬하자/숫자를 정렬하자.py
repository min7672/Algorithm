
T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    N=int(input())
    arr=list(map(int,input().split()))
    #bubble sort
    for i in range(1,N):
        for j in range(0,N-i):
            if arr[j]>arr[j+1]:
                tmp=arr[j+1]
                arr[j+1]=arr[j]
                arr[j]=tmp
    result=" ".join(map(str,arr))
    print(f'#{test_case} {result}')