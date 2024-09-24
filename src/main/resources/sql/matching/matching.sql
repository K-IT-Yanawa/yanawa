CREATE TABLE TBL_MATCHING(
                             POST_ID NUMBER PRIMARY KEY,
                             MATCHING_STATUS VARCHAR2(255) NOT NULL,
                             TIME_ID NUMBER,
                             TEAM_ID NUMBER,
                             TIME_CORDINATE NUMBER DEFAULT 0 NOT NULL,
                             DATE_CORDINATE NUMBER DEFAULT 0 NOT NULL,
                             LOCAL_CITY_ID NUMBER,
                             LOCAL_CITY_DETAIL VARCHAR2(255) NOT NULL,
                             CREATED_DATE DATE DEFAULT SYSDATE NOT NULL,
                             UPDATED_DATE DATE NOT NULL,
                             CONSTRAINT FK_MATCHING_POST FOREIGN KEY(POST_ID)
                                 REFERENCES TBL_POST(ID),
                             CONSTRAINT FK_MATCHING_TIME FOREIGN KEY(TIME_ID)
                                 REFERENCES TBL_MATCHING_TIME(ID),
                             CONSTRAINT FK_MATCHING_TEAM FOREIGN KEY(TEAM_ID)
                                 REFERENCES TBL_TEAM(ID),
                             CONSTRAINT FK_MATCHING_LOCAL_CITY FOREIGN KEY(LOCAL_CITY_ID)
                                 REFERENCES TBL_LOCAL_CITY(ID)
);

CREATE SEQUENCE SEQ_MATCHING;