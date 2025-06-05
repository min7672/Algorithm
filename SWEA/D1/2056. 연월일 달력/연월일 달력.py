    
T=int(input())
for test_case in range(1, T+1):
    date=input()
    if len(date)<8:
        print(f'#{test_case} {yy}/{mm}/{dd}')
        
    yy, mm, dd=date[:4], date[4:6], int(date[6:])
    if int(mm)<1 or int(mm)>12 or dd< 1 or dd>31 or (mm in ['02'] and dd >28) or (mm in ['04','06','09','11'] and dd >30):
        print(f'#{test_case} -1')
    else:
        if dd<10:
            dd='0'+str(dd)
        print(f'#{test_case} {yy}/{mm}/{dd}')
    