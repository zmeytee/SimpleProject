package ru.zmeytee.simpleproject.data

import ru.zmeytee.simpleproject.data.models.User

object TestData {

    val usersList = listOf(
        User.SimpleUser(
            id = 1,
            name = "Anna",
            email = "anna@anna.ru",
            phone = "12345646346"
        ),
        User.SimpleUser(
            id = 2,
            name = "Oleg",
            email = "oleg@oleg.ru",
            phone = "37645754785478"
        ),
        User.SimpleUser(
            id = 1,
            name = "Max",
            email = "max@max.ru",
            phone = "426547345735"
        ),
        User.SimpleUser(
            id = 1,
            name = "Nick",
            email = "nick@nick.ru",
            phone = "547457546"
        ),
        User.SimpleUser(
            id = 1,
            name = "Vova",
            email = "vova@vova.ru",
            phone = "342635754753"
        ),
        User.SimpleUser(
            id = 1,
            name = "Vera",
            email = "vera@vera.ru",
            phone = "346375754873547"
        ),
        User.SimpleUser(
            id = 1,
            name = "Olivia",
            email = "olivia@olivia.ru",
            phone = "4365783568754"
        ),
        User.SimpleUser(
            id = 1,
            name = "Ivan",
            email = "ivan@ivan.ru",
            phone = "357358735783457"
        ),
        User.SimpleUser(
            id = 1,
            name = "Egor",
            email = "egor@egor.ru",
            phone = "437578654621451"
        ),
        User.SimpleUser(
            id = 1,
            name = "Gregor",
            email = "gregor@gregor.ru",
            phone = "375485682464123"
        )
    )
}