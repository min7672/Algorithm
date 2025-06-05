
T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    h1,m1, h2,m2 = map(int, input().split())
    result_h=((m1+m2)//60+h1+h2)%12
    if result_h==0:
        result_h=12
    result_m=(m1+m2)%60
    print(f'#{test_case} {result_h} {result_m}')