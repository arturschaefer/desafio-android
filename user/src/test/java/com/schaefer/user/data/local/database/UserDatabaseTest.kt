package com.schaefer.user.data.local.database

import com.schaefer.user.data.local.dao.UserDao
import com.schaefer.user.data.local.entity.UserEntity
import com.schaefer.user.di.userModule
import com.schaefer.user.test.BaseTest
import com.schaefer.user.test.UserDummies
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.TestCoroutineScope
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.hamcrest.CoreMatchers.equalTo
import org.junit.After
import org.junit.Assert.assertThat
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.koin.core.module.Module
import org.koin.test.inject
import java.io.IOException

@RunWith(JUnit4::class)
class SimpleEntityReadWriteTest : BaseTest() {
    private val userDao: UserDao by inject()
    private val db: UserDatabase by inject()

    private val testDispatcher = TestCoroutineDispatcher()
    private val testScope = TestCoroutineScope(testDispatcher)
    override val modules: List<Module> = arrayListOf(userModule)

    @Before
    override fun setUp() {
        super.setUp()
        Dispatchers.setMain(testDispatcher)
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        Dispatchers.resetMain()
        db.close()
    }

    @Test
    fun writeUserAndReadInList() {
        testScope.launch {
            val user: UserEntity = UserDummies.userEntityDummy
            userDao.save(user)

            val localUser = userDao.getAllUsers().first()[0]
            assertThat(localUser, equalTo(user))
        }
    }
}