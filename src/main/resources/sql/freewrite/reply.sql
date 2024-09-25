CREATE TABLE TBL_REPLY (
                           ID NUMBER PRIMARY KEY,
                           REPLY_CONTENT VARCHAR2(255) NOT NULL,
                           USER_ID NUMBER,
                           POST_ID NUMBER,
                           CREATED_DATE DATE DEFAULT SYSDATE NOT NULL,
                           UPDATED_DATE DATE NOT NULL,
                           CONSTRAINT FK_REPLY_USER FOREIGN KEY(USER_ID)
                               REFERENCES TBL_USER(ID),
                           CONSTRAINT FK_REPLY_POST FOREIGN KEY (POST_ID)
                               REFERENCES TBL_FREEWRITE(POST_ID)
);
