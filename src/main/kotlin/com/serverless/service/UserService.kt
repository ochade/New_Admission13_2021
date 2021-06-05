package com.serverless.service

import com.serverless.model.Applicant
import com.serverless.model.User
import com.serverless.repository.ApplicantRepositoryImplementation
import com.serverless.repository.UserRepositoryImplementation

class UserService {
    private val userRepositoryImplementation: UserRepositoryImplementation = UserRepositoryImplementation()

    fun createUserTable(){
        userRepositoryImplementation.createUserTable()
    }
    fun createUserService(user: User){
        userRepositoryImplementation.createUser(user)
    }
    fun updateUserTable(user: User){
        userRepositoryImplementation.updateUser(user)
    }
    fun selectUser(username : String) {
        userRepositoryImplementation.selectUser(username)
    }

}
