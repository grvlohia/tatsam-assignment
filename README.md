# Tatsam Spring Assignment

## Assignment Description
There are 4 areas that a user can allot different priorities to.
1. Connection
2. Relationships
3. Career
4. Wealth
Along with priority, he/she needs to rate the satisfaction for all the
above areas on a scale of 1 to 5.
Company admin/creator should have the ability to add more areas in
the backend later if needed.

Create REST APIs that
* Returns a list of all the priority areas from the database
* Accepts the order of priority along with the satisfaction rating for each area for a user and stores it in the database

## Solution Description
The Database design has three tables,
1. priority(id, category)
2. user(id, name, phone, email)
3. user_priority(user_id, priority_id, satisfaction, priority). Here user_id and priority_id are foreign keys to user and priority table respectively.
An SQL script is included for details.

The application exposes the following REST API endpoints

* > GET /priorities - get a list of all priority areas
* > POST /users/:userId/priorities - save priority order for each area for a user with id :userId into the database
The above endpoint expects **application/json** data in the request body. And the format for the JSON object should be as follows,

```json
{
    "connection": {
        "priority": 1,
        "satisfaction": 5
    },
    "relationships": {
        "priority": 2,
        "satisfaction": 10
    },
    "career": {
        "priority": 3,
        "satisfaction": 5
    },
    "wealth": {
        "priority": 4,
        "satisfaction": 5
    }
}
```
There are additional endpoints for CRUD operations for User.
* > GET /users - get list of all users
* > GET /users/:userId - get user with id = :userId
* > POST /users - save a new user
* > PUT /users/:userId - update a user with id = :userId
* > DELETE /users/:userId - delete a user with id = :userId