# 🌍 Globetrotter Challenge – The Ultimate Travel Guessing Game!

**Globetrotter** is a fun and interactive travel guessing game where users receive cryptic clues about famous destinations and must guess the correct location. Players get rewarded with fun facts and trivia while tracking their scores. 

---

🔗 **Live :** https://globetrotter-site.netlify.app/game.html
(The backend server is hosted on Render's free tier, which may take 1-2 minutes to start after the first request due to cold start delays. Please allow some time for the server to initialize after making the initial API call.)
## 🚀 Tech Stack

### **Frontend**
- **HTML, CSS, JavaScript** – Core technologies for building an interactive UI

### **Backend**
- **Spring Boot** – REST API development
- **PostgreSQL** – Database for storing destinations, clues, and user data
- **JPA (Java Persistence API)** – ORM for database interaction

---

## 📌 Features
✅ Fun facts & trivia for destinations  
✅ Score tracking & leaderboard  
✅ Challenge-a-friend functionality  
✅ Secure backend with database storage



## 📖 API Reference 
##### BASE URL OF SERVER : 
baseurl ( HOST BACKEND URL)
## 1 .Load Game

## Overview
The **Load Game API** allows users to load a game session, retrieving a unique game ID along with 2 clues.

---

## **Endpoint**
### `GET /load`

---

## **Request**
### **Method:**
`GET`

### **Request Body:**
Not required.

---

## **Response**
### **Success Response (200 OK)**
If the game loads successfully, the response will contain the game ID and a list of clues.

#### **Response Body:**
```json
{
    "id": 123,
    "clues": [
        "Clue 1",
        "Clue 2"
    ]
}

```
## 2. Validate Answer

## Overview
The **Validate Answer API** checks whether a given answer for a destination (game ID) is correct or not.  
If the answer is correct, a fun fact is returned. Otherwise, a trivia fact is provided.

---

## **Endpoint**
### `GET /isValid`

---

## **Request**
### **Method:**
`GET`


### **Query Parameters:**
| Parameter  | Type    | Required | Description                        |
|------------|--------|----------|------------------------------------|
| `id`       | `Long` | Yes      | The unique identifier of the game (destination ID). |
| `answer`   | `String` | Yes     | The user-submitted answer for validation. |

## *Responses*
### Success Response (200 OK)
If the provided id exists, the response returns whether the answer is valid (true or false) along with a relevant text (fun fact or trivia).

### Response Body (Correct Answer)
```json

{
"isValid": true,
"text": "Paris is known as the City of Light!"
}
```

### Response Body (Incorrect Answer)
```json
{
"isValid": false,
"text": "Did you know? The Eiffel Tower can be 15 cm taller in summer."
}
```
## 3. User Registration

## Overview
The **User Registration API** allows a new user to register by providing a unique `userId`.  
A new user record is created with an initial score and timestamp.

---

## **Endpoint**
### `POST /register`

---

## **Request**
### **Method:**
`POST`


### **Request Body:**
| Field    | Type      | Required | Description                            |
|----------|----------|----------|----------------------------------------|
| `userId` | `String` | Yes      | Unique identifier for the user.        |
| `score`  | `int`    | No       | Initial score (default is 0).          |
| `timestamp` | `Long` | No       | Registration timestamp (default is current time). |

#### **Example Request Body:**
```json
{
    "userId": "bhishma123",
    "score": 0,
    "timestamp": 1709251200000
}
```
## Response
### Success Response (200 OK)
If the registration is successful, a confirmation message is returned.

Response Body:
```json

{
    "message": "User registered successfully!"
}
```

## 4. Get User Score

## Overview
The **Get User Score API** retrieves the score of a user based on their `userId` and a specific timestamp.

---

## **Endpoint**
### `GET /score`

---

## **Request**
### **Method:**
`GET`


### **Query Parameters:**
| Parameter  | Type    | Required | Description                        |
|------------|--------|----------|------------------------------------|
| `userId`   | `String` | Yes    | The unique identifier of the user. |
| `ts`       | `Long`   | Yes    | The timestamp to fetch the score at. |

## **Response**
### Success Response (200 OK)
If the provided userId exists and the timestamp is valid, the API returns the user's score.

Response Body:
```json
{
"score": 2,
"userName": "bhishma123"
}
```