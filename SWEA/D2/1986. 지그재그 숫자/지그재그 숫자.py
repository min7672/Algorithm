
T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    N = int(input())
    result=0
    for i in range(1,N+1):
        if i%2==1:
            result=result+i
        else:
            result=result-i
    print(f'#{test_case} {result}')
            
    