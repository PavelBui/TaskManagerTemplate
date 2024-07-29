# TaskManagerTemplate

REST API that allows to manage tasks. 


## How to run:
- Pre-installation of Maven and jdk17 is required
- Clone the Git repository: `https://github.com/PavelBui/TaskManagerTemplate` (implementation branch)
- Run the command `mvn clean package` in the root folder
- Run the command `java -jar TaskManagerTemplate-1.0-SNAPSHOT.jar` in the `target` folder

## Parameters
- **Port** - 8081
- **URL** - http://localhost:8081
- **Swagger** - http://localhost:8081/swagger-ui/index.html

## Task endpoints
- **Create task** - POST request http://localhost:8081/task
    - `RequestBody: TaskDto`
    - `ResponseBody: TaskDto`
- **Get task** - GET request http://localhost:8081/task/{id}
    - `PathVariable: task id`
    - `ResponseBody: TaskDto`
- **Get all tasks** - GET request http://localhost:8081/task
    - `ResponseBody: List of TaskDto`
- **Update task** - PUT request http://localhost:8081/task/{id}
    - `PathVariable: task id`
    - `RequestBody: TaskDto`
    - `ResponseBody: TaskDto`
- **Delete task** - DELETE request http://localhost:8081/task/{id}
    - `PathVariable: task id`
    - `ResponseBody: String` (Task was deleted successfully)

## Task with User endpoints
- **Create task with user** - POST request http://localhost:8081/task_user
  - `RequestBody: TaskUserDto`
  - `ResponseBody: TaskUserDto`
- **Get task with user** - GET request http://localhost:8081/task_user/{id}
  - `PathVariable: task id`
  - `ResponseBody: TaskUserDto`
- **Get all tasks by user id** - GET request http://localhost:8081/task_user/user/{id}
  - `ResponseBody: List of TaskUserDto`
- **Update task with user** - PUT request http://localhost:8081/task_user/{id}
  - `PathVariable: task id`
  - `RequestBody: TaskUserDto`
  - `ResponseBody: TaskUserDto`
- **Delete task with user** - DELETE request http://localhost:8081/task_user/{id}
  - `PathVariable: task id`
  - `ResponseBody: String` (Task was deleted successfully)

## User endpoints
- **Create user** - POST request http://localhost:8081/user
  - `RequestBody: UserDto`
  - `ResponseBody: UserDto`
- **Update user** - PUT request http://localhost:8081/user/{id}
  - `PathVariable: user id`
  - `RequestBody: UserDto`
  - `ResponseBody: UserDto`
- **Delete user** - DELETE request http://localhost:8081/user/{id}
  - `PathVariable: user id`
  - `ResponseBody: String` (User was deleted successfully)

## TaskDto (example)
```json
{
    "id": 0,
    "title": "string",
    "content": "string",
    "priority": "LOW",
    "status": "DONE",
    "createdDate": 0,
    "dueDate": 0
}
```

## Priority (available values)
- **LOW**
- **MEDIUM**
- **TOP**

## Status (available values)
- **TODO**
- **IN_PROGRESS**
- **REVIEW**
- **DONE**

## DateTime format
- **Pattern** - timestamp as a number of milliseconds since 1970-01-01 00:00:00.0 UTC
- **Usage** - createdDate, dueDate