INSERT INTO STUDENT(ID, CREATED_AT, MODIFIED_AT, VERSION, EMAIL, GENDER, NAME) VALUES (1, '1983-01-15 00:14', '2000-03-18 00:15',1, 'ali@gmail.com','MALE','ALI' );
INSERT INTO STUDENT(ID, CREATED_AT, MODIFIED_AT, VERSION, EMAIL, GENDER, NAME) VALUES (2, '1983-01-15 00:14', '2000-03-18 00:15',1, 'mohamed@gmail.com','MALE','MOHAMED' );
INSERT INTO STUDENT(ID, CREATED_AT, MODIFIED_AT, VERSION, EMAIL, GENDER, NAME) VALUES (3, '1983-01-15 00:14', '2000-03-18 00:15',1, 'salma@gmail.com','FEMALE','SALMA' );

INSERT INTO BOOK (ID, CREATED_AT, MODIFIED_AT, VERSION, AUTHOR, PUBLISHED_ON, TITLE) VALUES (1,'1983-01-15 00:14', '2000-03-18 00:15',1, 'VICTOR HUGO', '1983-01-15', 'SAVE OF TIME');
INSERT INTO BOOK (ID, CREATED_AT, MODIFIED_AT, VERSION, AUTHOR, PUBLISHED_ON, TITLE) VALUES (2,'1983-01-15 00:14', '2000-03-18 00:15',1, 'VICTOR HUGO', '1983-01-15', 'SAVE OF MONEY');
INSERT INTO BOOK (ID, CREATED_AT, MODIFIED_AT, VERSION, AUTHOR, PUBLISHED_ON, TITLE) VALUES (3,'1983-01-15 00:14', '2000-03-18 00:15',1, 'VICTOR HUGO', '1983-01-15', 'SAVE OF DEGNITY');

INSERT INTO STUDENT_BOOK (BOOK_ID, STUDENT_ID, FINISHED_READING_ON, STARTED_READING_ON) VALUES (1,1,'2022-01-13', '2022-01-01');
INSERT INTO STUDENT_BOOK (BOOK_ID, STUDENT_ID, FINISHED_READING_ON, STARTED_READING_ON) VALUES (2,1,'2022-02-20', '2022-02-01');