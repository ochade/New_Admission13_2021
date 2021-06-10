package com.serverless.service

import com.serverless.model.Role
import com.serverless.repository.RoleRepositoryImplementation

class RoleService {
    private  val roleRepositoryImplementation: RoleRepositoryImplementation = RoleRepositoryImplementation()

    fun createRoleTable(){
        roleRepositoryImplementation.createRoleTable()
    }
    fun createRoleService(role: Role){
        roleRepositoryImplementation.createRole(role)
    }
}