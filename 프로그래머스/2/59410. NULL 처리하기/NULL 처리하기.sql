select 
    ANIMAL_TYPE, 
    if(NAME is null, 'No name', NAME), 
    SEX_UPON_INTAKE 
from ANIMAL_INS
order by ANIMAL_ID asc