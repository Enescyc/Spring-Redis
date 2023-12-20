Make a curl request to save cities to the database in root directory of the project

```bash
curl -X POST -H "Content-Type: application/json" -d @cities.json http://localhost:8080/api/v1/city/save
```

and then make a curl request to get the cities from the database

```bash
curl -X GET http://localhost:8080/api/v1/city/get/5
```

and you can see application logs in the terminal.

An example of cached data from redis-cli

```bash
127.0.0.1:6379> GET cities::6
"\xac\xed\x00\x05sr\x00\x19com.enes.redis.model.City\xce\xa1\xa3\xb4\x19\xc8\xa7\xdf\x02\x00\x03L\x00\x02idt\x00\x10Ljava/lang/Long;L\x00\x04namet\x00\x12Ljava/lang/String;L\x00\npopulationt\x00\x12Ljava/lang/Double;xpsr\x00\x0ejava.lang.Long;\x8b\xe4\x90\xcc\x8f#\xdf\x02\x00\x01J\x00\x05valuexr\x00\x10java.lang.Number\x86\xac\x95\x1d\x0b\x94\xe0\x8b\x02\x00\x00xp\x00\x00\x00\x00\x00\x00\x00\x06t\x00\x05Adanasr\x00\x10java.lang.Double\x80\xb3\xc2J)k\xfb\x04\x02\x00\x01D\x00\x05valuexq\x00~\x00\x06A@\xf0.\x80\x00\x00\x00"
127.0.0.1:6379>
 ```
