CREATE TABLE TBL_VOLUNTEER(
                              ID NUMBER PRIMARY KEY,
                              USER_ID NUMBER,
                              TEAMPOST_ID NUMBER,
                              INTRODUCE VARCHAR2(255) NOT NULL,
                              CREATED_DATE DATE DEFAULT CURRENT_TIMESTAMP,
                              UPDATED_DATE DATE DEFAULT CURRENT_TIMESTAMP,
                              CONSTRAINT FK_VOLUNTEER_USER FOREIGN KEY(USER_ID)
                                  REFERENCES TBL_USER(ID),
                              CONSTRAINT FK_VOLUNTEER_TEAM FOREIGN KEY(TEAMPOST_ID)
                                  REFERENCES TBL_TEAMPOST(POST_ID)
);
