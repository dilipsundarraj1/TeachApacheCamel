# PostGresSql

## How to install PostGres?

Run the below command :

```
brew install postgres

```

How to check the postgres version?  

```
postgres --version
```

How to Start PostGres?

```
brew services start postgresql
```

How to Stop PostGres?

```
brew services stop postgresql

```

#### How to create a DB in Postgres via command line?

https://www.postgresql.org/docs/9.1/static/app-createdb.html

```
createdb -p 5432 -h localhost -e localDB

```

## How to connect to Postgres DB server from Terminal:

```
psql <DB> -h <Server> -U <userid> -W "sslmode=require"
```

By Default user id postgres will be created.

Conmmand to connect to Localhost:  

```
psql localDB localhost -U postgres
```

## How to connect to Postgres from Intellij:

Step 1:  

**Mac :**

```
Intellij IDEA -> Preferences -> Plugins
```

**Windows:**  

```
File -> Settings-> Plugins  
```

Below steps are the same for windows and Mac.  
Step 2:  

Search for **DataBase Navigator**.

Step 3:  

Install the plugin and restart the Intellij.

Step 4:  

There will be a **Database Navigator** in the Menu bar.

Step 5:  

Click on **DataBase Navigator**.   

Click on  **Open SQL Console**.  
