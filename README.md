# Technologie-aplikacji-serwerowych

#### How to run:
```
    mvn install
```
```
    cd target
```
```    
    java -jar artifact-1.0-SNAPSHOT.jar
```
##### Swagger

```
http://localhost:8080/swagger-ui.html#/
```
## Podstawowe informacje

### Dla wszystkich tabel:
    GET(all), POST, DELETE, PUT, GET(one)

### Dla faculty:
    GET(facultiesList) - lista wydziałów uniwersytetu, którego podano id
### Dla teacher:
    GET(teacherList) - lista prowadzących wydziału, którego podano id
### Dla vote:
    GET(voteList) - lista głósów prowadzacego, którego podano id
    GET(attractivenessAverage) - średnia ocena atrakcyjności zajęć prowadzącego o podanym id
    GET(competencyAverage) - średnia ocena kompetencji prowadzącego o podanym id
    GET(difficultyAverage)- średnia ocena łatwości zaliczenia prowadzącego o podanym id
    GET(friendshipAverage) - średnia ocena przyjazności prowadzącego o podanym id
    GET(systemAverage) - średnia ocena systemu oceniania prowadzącego o podanym id
    GET(classesAverage) - średnia ocena odpracowania zajęć prowadzącego o podanym id
    GET(commentsList) - lista komentarzy prowadzącego o podanym id
## university

#### allUniversities

Curl
```
curl -X GET --header 'Accept: application/json' 'http://localhost:8080/universities'
```
Request URL
```
http://localhost:8080/universities
```

#### addUniversity

Curl
```
curl -X POST --header 'Content-Type: application/json' --header 'Accept: application/json' -d '{ \ 
   "city": "string", \ 
   "name": "string", \ 
   "universityId": 0 \ 
 }' 'http://localhost:8080/universities/add'
```
Request URL
```
http://localhost:8080/universities/add
```

Model
```
University {
city (string, optional),
name (string, optional),
universityId (integer, optional)
}
```

Example Value
```
{
  "city": "string",
  "name": "string",
  "universityId": 0
}
```

#### deleteUniversity
Podajemy id uniwersytetu (tu 1).

Curl
```
curl -X DELETE --header 'Accept: application/json' 'http://localhost:8080/universities/delete/1'
```
Request URL
```
http://localhost:8080/universities/delete/1
```
#### editUniversity

Curl
```
curl -X PUT --header 'Content-Type: application/json' --header 'Accept: */*' -d '{ \ 
   "city": "string", \ 
   "name": "string", \ 
   "universityId": 0 \ 
 }' 'http://localhost:8080/universities/edit/1'
```
Request URL
```
http://localhost:8080/universities/edit/1
```

#### oneUniversity
Podajemy id uniwersytetu (tu 1).

Curl
```
curl -X GET --header 'Accept: application/json' 'http://localhost:8080/universities/1'
```
Request URL
```
http://localhost:8080/universities/1
```

## faculty

#### allFaculties
Curl
```
curl -X GET --header 'Accept: application/json' 'http://localhost:8080/faculties'
```
Request URL
```
http://localhost:8080/faculties
```
#### addFaculty

Curl
```
curl -X POST --header 'Content-Type: application/json' --header 'Accept: application/json' -d '{ \ 
   "facultyId": 0, \ 
   "name": "string", \ 
   "university": { \ 
     "city": "string", \ 
     "name": "string", \ 
     "universityId": 0 \ 
   } \ 
 }' 'http://localhost:8080/faculties/add'
```
Request URL
```
http://localhost:8080/faculties/add
```

Model
```
Faculty {
facultyId (integer, optional),
name (string, optional),
university (University, optional)
}University {
city (string, optional),
name (string, optional),
universityId (integer, optional)
}
```

Example Value
```
{
  "facultyId": 0,
  "name": "string",
  "university": {
    "city": "string",
    "name": "string",
    "universityId": 0
  }
}
```
#### deleteFaculty
Podajemy id wydziału (tu 1).

Curl
```
curl -X DELETE --header 'Accept: application/json' 'http://localhost:8080/faculties/delete/1'
```
Request URL
```
http://localhost:8080/faculties/delete/1
```
#### editFaculty

Curl
```
curl -X PUT --header 'Content-Type: application/json' --header 'Accept: */*' -d '{ \ 
   "facultyId": 0, \ 
   "name": "string", \ 
   "university": { \ 
     "city": "string", \ 
     "name": "string", \ 
     "universityId": 0 \ 
   } \ 
 }' 'http://localhost:8080/faculties/edit/1'
```
Request URL
```
http://localhost:8080/faculties/edit/1
```
#### oneFaculty
Podajemy id wydziału (tu 1).

Curl
```
curl -X GET --header 'Accept: application/json' 'http://localhost:8080/faculties/1'
```
Request URL
```
http://localhost:8080/faculties/1
```

#### facultiesList
Lista wydziałów uniwerystetu, którego podano id.

Curl
```
curl -X GET --header 'Accept: application/json' 'http://localhost:8080/faculties/statistics/facultiesList/1'
```

Request URL

```
http://localhost:8080/faculties/statistics/facultiesList/1
```

## teacher

#### allTeachers
Curl
```
curl -X GET --header 'Accept: application/json' 'http://localhost:8080/teachers'
```
Request URL
```
http://localhost:8080/teachers
```
#### addTeacher

Curl
```
curl -X POST --header 'Content-Type: application/json' --header 'Accept: application/json' -d '{ \ 
   "faculty": { \ 
     "facultyId": 0, \ 
     "name": "string", \ 
     "university": { \ 
       "city": "string", \ 
       "name": "string", \ 
       "universityId": 0 \ 
     } \ 
   }, \ 
   "name": "string", \ 
   "surname": "string", \ 
   "teacherId": 0 \ 
 }' 'http://localhost:8080/teachers/add'
```
Request URL
```
http://localhost:8080/teachers/add
```

Model
```
Teacher {
faculty (Faculty, optional),
name (string, optional),
surname (string, optional),
teacherId (integer, optional)
}Faculty {
facultyId (integer, optional),
name (string, optional),
university (University, optional)
}University {
city (string, optional),
name (string, optional),
universityId (integer, optional)
}
```

Example Value
```
{
  "faculty": {
    "facultyId": 0,
    "name": "string",
    "university": {
      "city": "string",
      "name": "string",
      "universityId": 0
    }
  },
  "name": "string",
  "surname": "string",
  "teacherId": 0
}
```
#### deleteTeacher
Podajemy id prowadzacego (tu 1).

Curl
```
curl -X DELETE --header 'Accept: application/json' 'http://localhost:8080/teachers/delete/1'
```
Request URL
```
http://localhost:8080/teachers/delete/1
```
#### editTeacher

Curl
```
curl -X PUT --header 'Content-Type: application/json' --header 'Accept: */*' -d '{ \ 
   "faculty": { \ 
     "facultyId": 0, \ 
     "name": "string", \ 
     "university": { \ 
       "city": "string", \ 
       "name": "string", \ 
       "universityId": 0 \ 
     } \ 
   }, \ 
   "name": "string", \ 
   "surname": "string", \ 
   "teacherId": 0 \ 
 }' 'http://localhost:8080/teachers/edit/1'
```
Request URL
```
http://localhost:8080/teachers/edit/1
```
#### oneTeacher
Podajemy id prowadzacego (tu 1).

Curl
```
curl -X GET --header 'Accept: application/json' 'http://localhost:8080/teachers/1'
```
Request URL
```
http://localhost:8080/teachers/1
```

#### teachersList
Lista prowadzacych wydzialu, któego podano id.
Curl
```
curl -X GET --header 'Accept: application/json' 'http://localhost:8080/teachers/statistics/teachersList/1'
```

Request URL
```
http://localhost:8080/teachers/statistics/teachersList/1
```
## vote

#### allVotes
Curl
```
curl -X GET --header 'Accept: application/json' 'http://localhost:8080/votes'
```
Request URL
```
http://localhost:8080/votes
```
#### addVote

Curl
```
curl -X POST --header 'Content-Type: application/json' --header 'Accept: application/json' -d '{ \ 
   "attractiveness": 0, \ 
   "classes": 0, \ 
   "comment": 0, \ 
   "competency": 0, \ 
   "difficulty": 0, \ 
   "friendship": 0, \ 
   "system": 0, \ 
   "teacher": { \ 
     "faculty": { \ 
       "facultyId": 0, \ 
       "name": "string", \ 
       "university": { \ 
         "city": "string", \ 
         "name": "string", \ 
         "universityId": 0 \ 
       } \ 
     }, \ 
     "name": "string", \ 
     "surname": "string", \ 
     "teacherId": 0 \ 
   }, \ 
   "voteId": 0 \ 
 }' 'http://localhost:8080/votes/add'
```
Request URL
```
http://localhost:8080/votes/add
```

Model
```
Vote {
attractiveness (integer, optional),
classes (integer, optional),
comment (integer, optional),
competency (integer, optional),
difficulty (integer, optional),
friendship (integer, optional),
system (integer, optional),
teacher (Teacher, optional),
voteId (integer, optional)
}Teacher {
faculty (Faculty, optional),
name (string, optional),
surname (string, optional),
teacherId (integer, optional)
}Faculty {
facultyId (integer, optional),
name (string, optional),
university (University, optional)
}University {
city (string, optional),
name (string, optional),
universityId (integer, optional)
}
```

Example Value
```
{
  "attractiveness": 0,
  "classes": 0,
  "comment": "string",
  "competency": 0,
  "difficulty": 0,
  "friendship": 0,
  "system": 0,
  "teacher": {
    "faculty": {
      "facultyId": 0,
      "name": "string",
      "university": {
        "city": "string",
        "name": "string",
        "universityId": 0
      }
    },
    "name": "string",
    "surname": "string",
    "teacherId": 0
  },
  "voteId": 0
}
```
#### deleteVote
Podajemy id głosu (tu 1).

Curl
```
curl -X DELETE --header 'Accept: application/json' 'http://localhost:8080/votes/delete/1'
```
Request URL
```
http://localhost:8080/votes/delete/1
```
#### editVote

Curl
```
curl -X PUT --header 'Content-Type: application/json' --header 'Accept: */*' -d '{ \ 
   "attractiveness": 0, \ 
   "classes": 0, \ 
   "comment": "string", \ 
   "competency": 0, \ 
   "difficulty": 0, \ 
   "friendship": 0, \ 
   "system": 0, \ 
   "teacher": { \ 
     "faculty": { \ 
       "facultyId": 0, \ 
       "name": "string", \ 
       "university": { \ 
         "city": "string", \ 
         "name": "string", \ 
         "universityId": 0 \ 
       } \ 
     }, \ 
     "name": "string", \ 
     "surname": "string", \ 
     "teacherId": 0 \ 
   }, \ 
   "voteId": 0 \ 
 }' 'http://localhost:8080/votes/edit/1'
```
Request URL
```
http://localhost:8080/votes/edit/1
```
#### oneVote
Podajemy id głosu (tu 1).

Curl
```
curl -X GET --header 'Accept: application/json' 'http://localhost:8080/votes/1'
```
Request URL
```
http://localhost:8080/votes/1
```
#### votesList
Zwraca listę oddanych głosów na prowadzącego, którego id zostało podane.

Curl
```
curl -X GET --header 'Accept: application/json' 'http://localhost:8080/votes/statistics/votesList/1'
```

Request URL
```
http://localhost:8080/votes/statistics/votesList/1
```

#### attractivenessAverage
Curl
```
curl -X GET --header 'Accept: application/json' 'http://localhost:8080/votes/statistics/attractivenessAverage/1'
```
Request URL
```
http://localhost:8080/votes/statistics/attractivenessAverage/1
```
#### competencyAverage
Curl
```
curl -X GET --header 'Accept: application/json' 'http://localhost:8080/votes/statistics/competencyAverage/1'
```
Request URL
```
http://localhost:8080/votes/statistics/competencyAverage/1
```
#### difficultyAverage
Curl
```
curl -X GET --header 'Accept: application/json' 'http://localhost:8080/votes/statistics/difficultyAverage/1'
```
Request URL
```
http://localhost:8080/votes/statistics/difficultyAverage/1
```
#### friendshipAverage
Curl
```
curl -X GET --header 'Accept: application/json' 'http://localhost:8080/votes/statistics/friendshipAverage/1'
```
Request URL
```
http://localhost:8080/votes/statistics/friendshipAverage/1
```
#### systemAverage
Curl
```
curl -X GET --header 'Accept: application/json' 'http://localhost:8080/votes/statistics/systemAverage/1'
```
Request URL
```
http://localhost:8080/votes/statistics/systemAverage/1
```
#### classesAverage
Curl
```
curl -X GET --header 'Accept: application/json' 'http://localhost:8080/votes/statistics/classesAverage/1'
```
Request URL
```
http://localhost:8080/votes/statistics/classesAverage/1
```
#### commentsList
Curl
```
curl -X GET --header 'Accept: application/json' 'http://localhost:8080/votes/statistics/commentsList/1'
```
Request URL
```
http://localhost:8080/votes/statistics/commentsList/1
```
