T = int(input())

for test_case in range(1,T+1):
    x,y=input().split()
    result='='
    if x<y:
        result='<'
    if x>y:
        result='>'
    print(f'#{test_case} {result}')