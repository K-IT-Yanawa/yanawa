CREATE TABLE TBL_FREEWRITE (
                               ID NUMBER CONSTRAINT PK_FREEWRITE PRIMARY KEY,
                               FREEWRITE_READ_COUNT NUMBER DEFAULT 0,
                               REPLY_COUNT NUMBER DEFAULT 0,
                               USER_ID NUMBER NOT NULL,
                               CREATED_DATE DATE DEFAULT CURRENT_TIMESTAMP,
                               UPDATED_DATE DATE DEFAULT CURRENT_TIMESTAMP,
                               CONSTRAINT FK_FREEWRITE_POST FOREIGN KEY(ID)
                                   REFERENCES TBL_POST(ID),
                               CONSTRAINT FK_FREEWRITE_MEMBER FOREIGN KEY (MEMBER_ID)
                                   REFERENCES TBL_MEMBER(ID)
);

SELECT * FROM TBL_FREEWRITE ORDER BY CREATED_DATE DESC;






SELECT
    f.POST_ID,
    p.POST_TITLE,
    p.POST_CONTENT,
    u.USER_NICKNAME,
    f.POST_READ_COUNT,
    f.REPLY_COUNT,
    f.CREATED_DATE,
    f.UPDATED_DATE
FROM
    TBL_FREEWRITE f
        JOIN TBL_POST p ON f.POST_ID = p.ID
        JOIN TBL_USER u ON f.USER_ID = u.ID
WHERE
    p.TYPE = 1 -- FREEWRITE만 가져오기 위한 조건
ORDER BY
    f.CREATED_DATE DESC;

SELECT * FROM TBL_FREEWRITE;


