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

DROP TABLE TBL_FREEWRITE;





SELECT * FROM TBL_FREEWRITE;


