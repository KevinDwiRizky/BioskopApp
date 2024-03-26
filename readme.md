Customer :

1.Create
POST : http://localhost:8080/customers

{
    "name" : "zee",
    "birthDate" : "2000-02-03"
}

2.Get all 
GET : http://localhost:8080/customers

3.Get by id
GET : http://localhost:8080/customers/09cc168f-a6d7-4cf9-b792-3df17258d409

4.Update 
PUT : http://localhost:8080/customers

{
    "id"   : "09cc168f-a6d7-4cf9-b792-3df17258d409"
    "name" : "zee",
    "birthDate" : "2000-02-03"
}

5.Delete 
DELETE : http://localhost:8080/customers/09cc168f-a6d7-4cf9-b792-3df17258d409

Theater :

1.Create 
POST : http://localhost:8080/theater
{
    "theaterNumber": "C01",
    "stock": 0
}

2.Get all
GET : http://localhost:8080/theater

Seats : 

1.Create
POST : http://localhost:8080/seats

{
    "seatNumber" : "C110",
    "theaterId": "9e4754c1-612e-4600-81c6-5cf9f88810d3"
}

2.Get all
GET : http://localhost:8080/seats

Rating : 

1.Create 
POST : http://localhost:8080/movies

{
    "name": "The Raid",
    "duration": 120,
    "showDate": "2024-04-01",
    "price": 10.000,
    "ratingId": "b79cdcce-a4c2-42a9-9f3f-9a407105c173"
}

2.Get all
GET : http://localhost:8080/movies

3.Get by id
GET : http://localhost:8080/movies/eb33462e-053b-4fce-8467-054d043f22a5

4.Update
PUT : http://localhost:8080/movies/

{
    "id" : "eb33462e-053b-4fce-8467-054d043f22a5"
    "name": "Merantau",
    "duration": 120,
    "showDate": "2024-04-01",
    "price": 10.000,
    "ratingId": "b79cdcce-a4c2-42a9-9f3f-9a407105c173"
}

5.Get by id
DELETE : http://localhost:8080/movies/eb33462e-053b-4fce-8467-054d043f22a5

Rating : 

1.Create 
POST : http://localhost:8080/rating

{
"code" : "A",
"description" : "Umum"
}

2.GET All
POST : http://localhost:8080/rating

Transaction :

1.Purchase tickets
POST : http://localhost:8080/purchase-tickets

{
    "customerId": "7ad1decd-0718-4b40-9616-daee9e1869b2",
    "movieId": "eb33462e-053b-4fce-8467-054d043f22a5",
    "seatId": "10040afc-76e4-429a-9026-05d6a41c199a"
}
