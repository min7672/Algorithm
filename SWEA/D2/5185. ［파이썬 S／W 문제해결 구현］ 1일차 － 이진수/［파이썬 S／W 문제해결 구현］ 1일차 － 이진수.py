
T = int(input())
arr16=['0',        '1',   '2',    '3',    '4',     '5',     '6',    '7',     '8',     '9',      'A',    'B',    'C',     'D',   'E',      'F']
arr2=['0000','0001','0010','0011','0100','0101','0110','0111','1000','1001','1010','1011','1100','1101','1110','1111']
for test_case in range(1, T + 1):
    N, num=input().split()
    result=''
    for x in num:
        result=result+arr2[arr16.index(x)]
    print(f'#{test_case} {result}')