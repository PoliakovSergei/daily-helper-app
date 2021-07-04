rootProject.name = "daily-helper-app"
include(
    "todo-web-app:todo-back",
    "todo-web-app:todo-front",
    "todo-web-app:todo-docker",
    "expenses-calculation-service",
    "expenses-calculation-service:ecs-back",
    "expenses-calculation-service:ecs-front",
    "expenses-calculation-service:ecs-docker"
)