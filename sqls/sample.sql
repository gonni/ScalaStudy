having
recursive

------

SELECT ORDER_ID, PRODUCT_ID, DATE_FORMAT(OUT_DATE,'%Y-%m-%d') AS OUT_DATE,
       CASE WHEN OUT_DATE <= '2022-05-01' THEN '출고완료'
            WHEN OUT_DATE > '2022-05-01' THEN '출고대기'
            ELSE '출고미정' END '출고여부'
FROM FOOD_ORDER
ORDER BY ORDER_ID

------
CASE
   WHEN LENGTH(TLNO) = 11 THEN CONCAT_WS('-', SUBSTRING(TLNO, 1, 3), SUBSTRING(TLNO, 4, 4), SUBSTRING(TLNO, 8, 4))
END AS 전화번호

SELECT CONCAT(CONCAT_WS("/", "/home/grep/src", F.BOARD_ID, F.FILE_ID), F.FILE_NAME, F.FILE_EXT) AS FILE_PATH
FROM USED_GOODS_BOARD AS B
         JOIN USED_GOODS_FILE AS F
              ON B.BOARD_ID = F.BOARD_ID
WHERE B.VIEWS = (SELECT MAX(VIEWS) FROM USED_GOODS_BOARD)
ORDER BY F.FILE_ID DESC


---

-- 코드를 입력하세요
SELECT MONTH(START_DATE) AS MONTH
        , CAR_ID
        , COUNT(HISTORY_ID) AS RECORDS
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
WHERE CAR_ID IN (SELECT CAR_ID
    FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
    WHERE MONTH(START_DATE) IN (8, 9, 10)
    GROUP BY CAR_ID
    HAVING COUNT(HISTORY_ID) >= 5)
  AND MONTH(START_DATE) IN (8, 9, 10)
GROUP BY MONTH, CAR_ID
HAVING COUNT(HISTORY_ID) >= 1
ORDER BY MONTH
        , CAR_ID DESC;

SELECT FOOD_TYPE, REST_ID, REST_NAME,FAVORITES
FROM (SELECT FOOD_TYPE, REST_ID, REST_NAME,FAVORITES,
             RANK() OVER (PARTITION BY FOOD_TYPE ORDER BY FAVORITES DESC) AS R
      FROM REST_INFO) A
WHERE R = 1
ORDER BY FOOD_TYPE DESC;

--

SELECT a.FOOD_TYPE, a.REST_ID, a.REST_NAME, a.FAVORITES FROM REST_INFO a
                                                                 inner join (
    SELECT FOOD_TYPE, MAX(FAVORITES) AS FAVORITES FROM REST_INFO
    GROUP BY FOOD_TYPE ) b
                                                                            ON a.FOOD_TYPE = b.FOOD_TYPE and a.FAVORITES = b.FAVORITES
ORDER BY a.FOOD_TYPE desc ;
--
SELECT animal_type, count(*) as count
from animal_ins
group by animal_type
having animal_type in ('cat', 'dog')
order by 1

--
HAVING
    HAVING은 간단하게 생각해서 GROUP BY한 결과에 조건을 붙이고 싶을때, 즉 GROUP BY의 WHERE 절과도 같다고 볼 수 있습니다.
    위의 예제에서, 각각 status의 총 갯수(COUNT)가 4이상인 경우를 예제로 보여드리겠습니다.

                                                             SELECT
    status, COUNT(*)
FROM
    orders
GROUP BY status
HAVING COUNT(*) > 4;

---
SELECT YEAR(SALES_DATE) AS YEAR, MONTH(SALES_DATE) AS MONTH, GENDER, COUNT(DISTINCT(B.USER_ID)) AS USERS
FROM USER_INFO A
    JOIN ONLINE_SALE B
ON A.USER_ID = B.USER_ID
WHERE A.GENDER IS NOT NULL
GROUP BY MONTH, GENDER
ORDER BY 1,2,3

--- +++
WITH RECURSIVE TIME AS (
    SELECT 0 AS HOUR
    UNION ALL
    SELECT HOUR + 1 FROM TIME WHERE HOUR < 23
    )


    (SELECT HOUR, (0) AS COUNT FROM TIME
    WHERE HOUR NOT IN (SELECT HOUR(DATETIME) FROM ANIMAL_OUTS
    GROUP BY HOUR(DATETIME)
    )
    UNION ALL
    SELECT HOUR(DATETIME), COUNT(*) FROM ANIMAL_OUTS
    GROUP BY HOUR(DATETIME))
ORDER BY HOUR

--
SELECT
    L.HOUR,
    IFNULL(R.COUNT, 0) AS COUNT
FROM
    (
    WITH RECURSIVE HOURS (HOUR) AS
    (
    SELECT 0
    UNION
    SELECT HOUR + 1 FROM HOURS WHERE HOUR < 23
    )
    SELECT HOUR FROM HOURS
    ) AS L
    LEFT OUTER JOIN
    (
    SELECT EXTRACT(HOUR FROM DATETIME) AS HOUR, COUNT(*) AS COUNT
    FROM ANIMAL_OUTS GROUP BY HOUR ORDER BY HOUR
    ) AS R
ON L.HOUR = R.HOUR;

----

SET @i = -1;

SELECT (@i := @i + 1) AS HOUR
        , (SELECT COUNT(*)
           FROM animal_outs
           WHERE HOUR(datetime) = @i) AS COUNT
FROM animal_outs
WHERE @i < 23

----- GOOD>


WITH RECURSIVE cte AS (
    SELECT 0 AS n
    UNION ALL
    SELECT n+1 FROM cte WHERE n < 23)

SELECT n 'HOUR', 0
FROM cte
WHERE n NOT IN (SELECT HOUR(DATETIME) HOUR
FROM ANIMAL_OUTS
GROUP BY HOUR)

UNION ALL

SELECT HOUR(DATETIME) HOUR, COUNT(ANIMAL_ID) COUNT
FROM ANIMAL_OUTS
GROUP BY HOUR
ORDER BY HOUR
-----

SELECT HOUR(DATETIME) AS HOUR, COUNT(DATETIME) FROM ANIMAL_OUTS
GROUP BY HOUR
ORDER BY HOUR ;

------ CASE WHEN .. THEN .. ELSE .. END
SELECT
    CASE
        WHEN price >= 10000 AND price < 20000 THEN 10000
        WHEN price >= 20000 AND price < 30000 THEN 20000
        WHEN price >= 30000 AND price < 40000 THEN 30000
        WHEN price >= 40000 AND price < 50000 THEN 40000
        WHEN price >= 50000 AND price < 60000 THEN 50000
        WHEN price >= 60000 AND price < 70000 THEN 60000
        WHEN price >= 70000 AND price < 80000 THEN 70000
        WHEN price >= 80000 AND price < 90000 THEN 80000
        END AS PRICEGROUP
     ,COUNT(productid) AS PRODUCTS
FROM PRODUCT
GROUP BY 1
ORDER BY 1

---- IF NULL
SELECT ANIMAL_TYPE, IFNULL(NAME,'No name') AS NAME, SEX_UPON_INTAKE
FROM ANIMAL_INS
ORDER BY ANIMAL_ID ASC;

--- left-outer join
SELECT o.ANIMAL_ID, o.NAME FROM ANIMAL_OUTS o
    left outer join ANIMAL_INS i
    on i.ANIMAL_ID = o.ANIMAL_ID
WHERE i.ANIMAL_ID is null ;

---
SELECT p.PRODUCT_CODE, sum(p.PRICE * s.SALES_AMOUNT) SALES FROM PRODUCT p
inner join OFFLINE_SALE s on p.PRODUCT_ID = s.PRODUCT_ID
GROUP by p.PRODUCT_CODE
ORDER by SALES desc , PRODUCT_CODE;

----
SELECT YEAR(SALES_DATE) YEAR, MONTH(SALES_DATE) MONTH, count(distinct(user_id)) PURCHASED_USERS,round(count(distinct(user_id))/(SELECT count(DISTINCT(user_id)) FROM user_info
    where joined like '%2021%'),1) as PURCHASED_RATIO
FROM ONLINE_SALE
WHERE USER_ID IN (SELECT DISTINCT(user_id)
    FROM USER_INFO
    WHERE JOINED LIKE '%2021%')
GROUP BY 1,2
ORDER BY 1, 2;

-- 코드를 입력하세요
SELECT b.BOOK_ID, a.AUTHOR_NAME, DATE_FORMAT(b.PUBLISHED_DATE, '%Y-%m-%d') FROM BOOK b
inner join AUTHOR a
on b.AUTHOR_ID = a.AUTHOR_ID
where
    b.CATEGORY = '경제'
order by b.PUBLISHED_DATE ;

-- ONLY ONE COMPARE
SELECT
    A.MEMBER_NAME, B.REVIEW_TEXT, DATE_FORMAT(B.REVIEW_DATE, '%Y-%m-%d') AS REVIEW_DATE
FROM MEMBER_PROFILE AS A
         JOIN REST_REVIEW AS B
              ON A.MEMBER_ID = B.MEMBER_ID
WHERE
    A.MEMBER_ID = (
        SELECT
            MEMBER_ID
        FROM
            REST_REVIEW
        GROUP BY
            MEMBER_ID
        ORDER BY COUNT(*) DESC LIMIT 1
    )
ORDER BY
    3, 2

--
SELECT A.CAR_ID, A.CAR_TYPE,
       ROUND((A.DAILY_FEE * 30 / 100 * (100 -
                                        (SELECT DISCOUNT_RATE
                                         FROM CAR_RENTAL_COMPANY_DISCOUNT_PLAN
                                         WHERE CAR_TYPE = A.CAR_TYPE AND DURATION_TYPE = "30일 이상")))) AS FEE
FROM CAR_RENTAL_COMPANY_CAR AS A
         JOIN CAR_RENTAL_COMPANY_RENTAL_HISTORY AS B
              ON A.CAR_ID = B.CAR_ID
WHERE A.CAR_TYPE IN ("SUV", "세단") AND
    (A.CAR_ID NOT IN (SELECT CAR_ID
                      FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
                      WHERE start_date <= '2022-11-01' and end_date >= '2022-11-01'))
GROUP BY A.CAR_ID
HAVING FEE >= 500000 AND FEE < 2000000
ORDER BY FEE DESC, CAR_TYPE ASC, CAR_ID DESC
