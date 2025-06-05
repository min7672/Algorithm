
de=[]
for i in range(65,91):
    de.append(chr(i))

for j in range(97,123):
    de.append(chr(j))
    
for k in range(48,58):
    de.append(chr(k))
de.append('+')
de.append('/')

T = int(input())
for test_case in range(1, T + 1):
    plain_text= input()
    origin_tB=''
    for i in range(len(plain_text)):
        tmp=bin(de.index(plain_text[i]))[2:]
        while len(tmp)!=6:
            tmp='0'+tmp

        origin_tB= origin_tB+tmp
    print(f'#{test_case}', end=' ')
    for j in range(0,len(origin_tB),8):
        myW='0b'+origin_tB[j:j+8]
        tm=int(myW,2)
        print(chr(tm),end='')
    print('')