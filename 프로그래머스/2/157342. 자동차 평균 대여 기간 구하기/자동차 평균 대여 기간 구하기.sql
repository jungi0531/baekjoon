select CAR_ID, round(avg(datediff(end_date, start_date) + 1), 1) as AVERAGE_DURATION from CAR_RENTAL_COMPANY_RENTAL_HISTORY
group by CAR_ID
having AVERAGE_DURATION >= 7
order by AVERAGE_DURATION desc, CAR_ID desc