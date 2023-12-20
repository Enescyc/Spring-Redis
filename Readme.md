Make a curl request to save cities to the database in root directory of the project

```bash
curl -X POST -H "Content-Type: application/json" -d @cities.json http://localhost:8080/api/v1/city/save
```

and then make a curl request to get the cities from the database

```bash
curl -X GET http://localhost:8080/api/v1/city/get/5
```

and you can see application logs in the terminal.

