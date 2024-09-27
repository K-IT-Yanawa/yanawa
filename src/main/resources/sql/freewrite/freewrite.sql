CREATE TABLE TBL_FREEWRITE (
                               ID NUMBER CONSTRAINT PK_FREEWRITE PRIMARY KEY,
                               FREEWRITE_READ_COUNT NUMBER DEFAULT 0,
                               REPLY_COUNT NUMBER DEFAULT 0,
                               MEMBER_ID NUMBER NOT NULL,
                               CREATED_DATE DATE DEFAULT CURRENT_TIMESTAMP,
                               UPDATED_DATE DATE DEFAULT CURRENT_TIMESTAMP,
                               CONSTRAINT FK_FREEWRITE_POST FOREIGN KEY(ID)
                                   REFERENCES TBL_POST(ID),
                               CONSTRAINT FK_FREEWRITE_MEMBER FOREIGN KEY (MEMBER_ID)
                                   REFERENCES TBL_MEMBER(ID)
);


SELECT * FROM TBL_FREEWRITE ORDER BY CREATED_DATE DESC;






SELECT * FROM TBL_FREEWRITE;





SELECT *
FROM (
         SELECT ROWNUM R, P1.*
         FROM (
                  SELECT F.ID, F.FREEWRITE_READ_COUNT, F.REPLY_COUNT, F.MEMBER_ID, F.CREATED_DATE, F.UPDATED_DATE,
                         P.POST_TITLE, P.POST_CONTENT
                  FROM TBL_FREEWRITE F
                           JOIN TBL_POST P ON F.ID = P.ID
                  ORDER BY F.FREEWRITE_READ_COUNT DESC
              ) P1
         WHERE ROWNUM <= 15
     ) P2
WHERE P2.R >= 1;

