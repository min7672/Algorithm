T = int(input())
#날짜 소거 테이블 만들고 가장 큰 수 앞 인덱스 한번에 지우기
for test_case in range(1, T + 1):
    day=int(input())
    numL=list(map(int,(input().split())))
    maxI=0
    result=0
    for i in range( len(numL)):
        #최대 인덱스가 있으면 결과 값에 더한다.
        if maxI > i:
            result=result+numL[maxI]-numL[i]
        #최대 인덱스가 없으면 결과값에 0을 더한다.
        elif maxI == -1 and maxI>=i:
            result=result+0
        #최대 인덱스가 i보다  작거나 max index가 0일 때나 그외 어떤 경우에 max인덱스를 재탐색 한다.    
        else:
            sub_maxI=i
            for j in range(i+1, len(numL)):
                if numL[j]>numL[sub_maxI]:
                    sub_maxI=j
            if numL[sub_maxI]>numL[i]:
                maxI=sub_maxI
                result=result+numL[maxI]-numL[i]
            else:
                maxI=-1
    print(f'#{test_case} {result}')