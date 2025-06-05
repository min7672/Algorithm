T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    plain_t=list(input())
    N= len(plain_t)
    if N%2==1:
        del plain_t[N//2]
        N=N-1
    result=1
    for i in range(N//2):
        if plain_t[N//2-1-i] != plain_t[N//2+i]:
            result=0
            break
            
    print(f'#{test_case} {result}')