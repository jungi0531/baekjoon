select 
    B.book_id as BOOK_ID, 
    A.author_name as AUTHOR_NAME, 
    date_format(B.published_date, '%Y-%m-%d') as PUBLISHED_DATE
from BOOK B
inner join AUTHOR A on B.author_id = A.author_id
where category = '경제'
order by published_date asc