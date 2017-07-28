Enter password: ****
Welcome to the MySQL monitor.  Commands end with ; or \g.
Your MySQL connection id is 5
Server version: 5.5.18 MySQL Community Server (GPL)

Copyright (c) 2000, 2011, Oracle and/or its affiliates. All rights reserved.

Oracle is a registered trademark of Oracle Corporation and/or its
affiliates. Other names may be trademarks of their respective
owners.

Type 'help;' or '\h' for help. Type '\c' to clear the current input statement.

mysql> use springcustomer;
Database changed

mysql> show tables;
+--------------------------+
| Tables_in_springcustomer |
+--------------------------+
| customer                 |
| customeremail            |
| item                     |
| market                   |
| offer                    |
| vendor                   |
+--------------------------+
6 rows in set (0.00 sec)

mysql> select * from customer;
+----+-----------+----------+---------+-------+
| ID | FirstName | LastName | Address | City  |
+----+-----------+----------+---------+-------+
|  4 | Ekta      | G        | Sec49   | BNDA  |
|  5 | Shraddha  | G        | Sec49   | NOIDA |
|  6 | Manul     | Lahariya | Sec49   | Noida |
+----+-----------+----------+---------+-------+
3 rows in set (0.00 sec)

mysql> desc customer;
+-----------+-------------+------+-----+---------+----------------+
| Field     | Type        | Null | Key | Default | Extra          |
+-----------+-------------+------+-----+---------+----------------+
| ID        | int(11)     | NO   | PRI | NULL    | auto_increment |
| FirstName | varchar(75) | YES  |     | NULL    |                |
| LastName  | varchar(75) | NO   |     | NULL    |                |
| Address   | varchar(55) | YES  |     | NULL    |                |
| City      | varchar(55) | YES  |     | NULL    |                |
+-----------+-------------+------+-----+---------+----------------+
5 rows in set (0.00 sec)
