# redis-util

# Reduce Redis Memory Usage using MsgPack and Snappy

Stats from storing `test_data.json`

## Normal JSON storage

```
127.0.0.1:6379> hgetall "Priscilla"
1) "Haymes"
2) "{\"firstName\":\"Priscilla\",\"lastName\":\"Haymes\",\"birthday\":1586690100000}"

127.0.0.1:6379> memory stats
21) "keys.count"
22) (integer) 100
23) "keys.bytes-per-key"
24) (integer) 1044
25) "dataset.bytes"
26) (integer) 32840
```

## With MsgPack

```
127.0.0.1:6379> hgetall "Priscilla"
1) "Haymes"
2) "\x83\xa9firstName\xa9Priscilla\xa8lastName\xa6Haymes\xa8birthday\xcf\x00\x00\x01qn\x19\x8b "

127.0.0.1:6379> memory stats
21) "keys.count"
22) (integer) 100
23) "keys.bytes-per-key"
24) (integer) 876
25) "dataset.bytes"
26) (integer) 15976
```

## With MsgPack and Snappy Compression

```
127.0.0.1:6379> hgetall "Priscilla"
1) "Haymes"
2) "7\\\x83\xa9firstName\xa9Priscilla\xa8la\t\x13`\xa6Haymes\xa8birthday\xcf\x00\x00\x01qn\x19\x8b "

127.0.0.1:6379> memory stats
21) "keys.count"
22) (integer) 100
23) "keys.bytes-per-key"
24) (integer) 876
25) "dataset.bytes"
26) (integer) 15976
```
---

|Normal | MessagePack | MessagePack With Snappy |
|-------|-------------|-------------------------|
|32840|15976|15976