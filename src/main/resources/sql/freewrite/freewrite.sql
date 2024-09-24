CREATE TABLE TBL_FREEWRITE (
                               POST_ID NUMBER PRIMARY KEY,
                               POST_READ_COUNT NUMBER DEFAULT 0,
                               REPLY_COUNT NUMBER DEFAULT 0,
                               USER_ID NUMBER NOT NULL,
                               CREATED_DATE DATE DEFAULT CURRENT_TIMESTAMP,
                               UPDATED_DATE DATE DEFAULT CURRENT_TIMESTAMP,
                               CONSTRAINT FK_FREEWRITE_POST FOREIGN KEY(POST_ID)
                                   REFERENCES TBL_POST(ID),
                               CONSTRAINT FK_FREEWRITE_USER FOREIGN KEY (USER_ID)
                                   REFERENCES TBL_USER(ID)
);
CREATE SEQUENCE SEQ_FREEWRITE
START WITH 1
          INCREMENT BY 1;


