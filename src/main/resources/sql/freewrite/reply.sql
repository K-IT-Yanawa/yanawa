CREATE SEQUENCE SEQ_REPLY;


CREATE TABLE TBL_REPLY (
                           ID NUMBER PRIMARY KEY,
                           REPLY_CONTENT VARCHAR2(255) NOT NULL,
                           MEMBER_ID NUMBER,
                           POST_ID NUMBER,
                           CREATED_DATE DATE DEFAULT SYSDATE NOT NULL,
                           UPDATED_DATE DATE DEFAULT SYSDATE NOT NULL,
                           CONSTRAINT FK_REPLY_MEMBER FOREIGN KEY (MEMBER_ID)
                               REFERENCES TBL_MEMBER (ID),
                           CONSTRAINT FK_REPLY_POST FOREIGN KEY (POST_ID)
                               REFERENCES TBL_FREEWRITE (ID)
);



