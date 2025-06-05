T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    numL=list(map(int,(input().split())))
    _max=numL[0]
    _min=numL[0]
    for i in range(1,len(numL)):
        if _max<numL[i]:
            _max=numL[i]
        if _min>numL[i]:
            _min=numL[i]
    numL.remove(_max)
    numL.remove(_min)
    print(f'#{test_case} {int(round(sum(numL)/len(numL),0))}')
    