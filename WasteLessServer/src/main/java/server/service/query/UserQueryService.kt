package server.service.query

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import server.db.model.User
import server.db.repository.UserRepo

@Service
class UserQueryService {

    @Autowired
    private lateinit var userRepo: UserRepo

    fun getAllUsers(): List<User> =
            userRepo.findAll()

    fun getUser(userId: Int): User =
        userRepo.findById(userId).get()


    fun getWaste(userId: Int): Int =
            userRepo.findById(userId).get().calorieIntake

}