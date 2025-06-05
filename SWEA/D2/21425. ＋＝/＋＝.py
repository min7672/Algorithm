
T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    A,B,N = map(int, input().split())
    if A>B:
        tmp=A
        A=B
        B=tmp
    i=0
   
    while True:
        if i%2==0: 
            A=A+B
        else:
            B=B+A        
        i=i+1
        if N<A or N<B:
            break
    print(f'{i}')