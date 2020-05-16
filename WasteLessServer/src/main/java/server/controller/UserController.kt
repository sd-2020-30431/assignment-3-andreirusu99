package server.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import server.db.model.User
import server.mediator.Mediator
import server.mediator.command.LoginUserCommand
import server.mediator.command.UpdateUserCommand
import server.mediator.query.ReadAllUsersQuery
import server.mediator.query.ReadUserWasteQuery
import server.mediator.response.EmptyResponse
import server.mediator.response.LoginUserCommandResponse
import server.mediator.response.ReadAllUsersQueryResponse
import server.mediator.response.ReadUserWasteQueryResponse

@RestController
@RequestMapping("/wasteless")
class UserController {

    @Autowired
    private lateinit var mediator: Mediator

    @RequestMapping("users/login", method = [RequestMethod.POST])
    fun loginUser(@RequestBody user: User): ResponseEntity<Int> {
        val request = LoginUserCommand(user)
        val handler = mediator.handle<LoginUserCommand, LoginUserCommandResponse>(request)
        val response = handler.handle(request)
        return ResponseEntity.ok(response.userId)
    }

    @RequestMapping("/users/all", method = [RequestMethod.GET])
    fun getAllUsers(): ResponseEntity<List<User>> {
        val request = ReadAllUsersQuery()
        val handler = mediator.handle<ReadAllUsersQuery, ReadAllUsersQueryResponse>(request)
        val response = handler.handle(request)
        return ResponseEntity.ok(response.users)
    }

    @RequestMapping("/users/waste/{userId}", method = [RequestMethod.GET])
    fun getUserWaste(@PathVariable userId: Int): ResponseEntity<Int> {
        val request = ReadUserWasteQuery(userId)
        val handler = mediator.handle<ReadUserWasteQuery, ReadUserWasteQueryResponse>(request)
        val response = handler.handle(request)
        return ResponseEntity.ok(response.waste)
    }

    @RequestMapping("/users/update/{userId}", method = [RequestMethod.PUT])
    fun updateUser(@PathVariable userId: Int, @RequestBody calories: Int) {
        val request = UpdateUserCommand(userId, calories)
        val handler = mediator.handle<UpdateUserCommand, EmptyResponse>(request)
        handler.handle(request)
    }
}