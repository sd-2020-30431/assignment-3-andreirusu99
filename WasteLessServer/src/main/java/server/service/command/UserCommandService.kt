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

    @Transactional
    fun updateUser(userId: Int, calorieIntake: Int) =
            userRepo.findById(userId).let {
                it.ifPresent { user ->
                    user.calorieIntake = calorieIntake
                }
            }
}