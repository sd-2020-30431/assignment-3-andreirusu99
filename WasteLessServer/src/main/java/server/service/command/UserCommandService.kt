package server.service.command

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import server.db.model.User
import server.db.repository.UserRepo

@Service
class UserCommandService {

    @Autowired
    private lateinit var userRepo: UserRepo

    fun attemptLogin(firstName: String, lastName: String, password: String)
            : Int {
        val users = userRepo.getMatchingUser(firstName, lastName, password)
        if (users.isNotEmpty()) return users[0].id
        val user = User(firstName = firstName, lastName = lastName, password = password, calorieIntake = 0)
        return userRepo.save(user).id
    }

    fun addUser(firstName: String, lastName: String, password: String, calorieIntake: Int) {
        println("entered @add")
        val user = User(firstName = firstName, lastName = lastName, password = password, calorieIntake = calorieIntake)
        println("User stored : $user")
        userRepo.save(user)
    }

    @Transactional
    fun updateUser(id: Int, calorieIntake: Int) =
            userRepo.findById(id).let {
                it.ifPresent { user ->
                    user.calorieIntake = calorieIntake
                }
            }

    fun deleteUser(id: Int) {
        userRepo.deleteById(id)
    }

    @Transactional
    fun syncDatabase(userList: MutableList<User>) {
        userRepo.findAll().forEach {
            userList.find { user -> user.id == it.id }?.let { user ->
                it.apply {
                    lastName = user.lastName
                    firstName = user.firstName
                    password = user.password
                    calorieIntake = user.calorieIntake
                }
                userList.remove(user)
            } ?: userRepo.delete(it)
        }
        userList.forEach {
            userRepo.save(it)
        }
    }

}