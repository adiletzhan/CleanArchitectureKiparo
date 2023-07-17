package com.example.cleanarchitecture.domain.usecase

import com.example.cleanarchitecture.domain.models.SaveUserNameParam
import com.example.cleanarchitecture.domain.repository.UserRepository

class SaveUserNameUseCase(private val userRepository: UserRepository) {

    public fun execute(param: SaveUserNameParam): Boolean{

        return userRepository.saveName(param)
    }
}