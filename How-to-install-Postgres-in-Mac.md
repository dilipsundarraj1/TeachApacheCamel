# PostGresSql

## How to install PostGres?

Run the below command :

```
brew install postgres

```

How to Start PostGres?

```
brew services start postgresql
```

How to Stop PostGres?

```
brew services stop postgresql

```

#### How to Create a user in Postgres via command line?

https://www.postgresql.org/docs/9.1/static/app-createuser.html

```
createuser -h localhost -p 5432 -S -D -R -e postgres

```

#### How to create a DB in Postgres via command line?

https://www.postgresql.org/docs/9.1/static/app-createdb.html

```
createdb -p 5432 -h localhost -e localDB

```

## PostGres Client

Download the postgres client **pgAdmin** from the below link.

[PostGres Client](https://www.postgresql.org/ftp/pgadmin3/pgadmin4/v1.1/macos/)
