package server.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import server.db.model.User
import server.mediator.Mediator
import server.mediator.command.LoginUserCommand
import server.mediator.response.LoginUserCommandResponse
import server.service.user.UserService

@RestController
@RequestMapping("/wasteless")
class UserController {

    @Autowired
    private lateinit var userService: UserService

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
        println("\"/users/all\" received")
        return ResponseEntity.ok(userService.getAllUsers())
    }

    @RequestMapping("/users/waste/{userId}", method = [RequestMethod.GET])
    fun getUserWaste(@PathVariable userId: Int): ResponseEntity<Int> =
            ResponseEntity.ok(userService.getWaste(userId))

    @RequestMapping("/users/add", method = [RequestMethod.POST])
    fun addUser(@RequestBody user: User) =
            ResponseEntity.ok(userService.addUser(user.firstName, user.lastName, user.password, user.calorieIntake))

    @RequestMapping("/users/update/{userId}", method = [RequestMethod.PUT])
    fun updateUser(@PathVariable userId: Int, @RequestBody calories: Int) =
            ResponseEntity.ok(userService.updateUser(userId, calories))

    @RequestMapping("/users/delete/{userId}", method = [RequestMethod.DELETE])
    fun deleteUser(@PathVariable userId: Int) =
            ResponseEntity.ok(userService.deleteUser(userId))
}