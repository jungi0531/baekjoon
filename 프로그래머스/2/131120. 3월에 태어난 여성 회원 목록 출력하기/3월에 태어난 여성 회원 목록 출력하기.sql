select 
    MEMBER_ID, 
    MEMBER_NAME, 
    GENDER, 
    DATE_FORMAT(DATE_OF_BIRTH, '%Y-%m-%d') as DATE_OF_BIRTH
from MEMBER_PROFILE
where GENDER = 'W' and DATE_OF_BIRTH like '____-03-%' and TLNO is not null
order by MEMBER_ID asc