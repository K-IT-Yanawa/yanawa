CREATE TABLE TBL_LOCAL_CITY(
                            ID NUMBER PRIMARY KEY,
                            LOCAL_CITY_NAME VARCHAR2(255) NOT NULL,
                            CITY_ID NUMBER,
                            CONSTRAINT FK_LOCAL_CITY_CITY FOREIGN KEY(CITY_ID)
                            REFERENCES TBL_CITY(ID)
);
