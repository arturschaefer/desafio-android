package com.schaefer.user.data.local.database

import android.content.Context
import com.schaefer.user.data.local.dao.UserDao
import com.schaefer.user.data.local.entity.UserEntity
import com.schaefer.user.di.userModule
import com.schaefer.user.test.UserDummies
import io.mockk.mockk
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
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.test.KoinTest
import org.koin.test.inject
import java.io.IOException

@RunWith(JUnit4::class)
class SimpleEntityReadWriteTest : KoinTest {
    private val context = mockk<Context>()

    private val userDao: UserDao by inject()
    private val db: UserDatabase by inject()

    private val testDispatcher = TestCoroutineDispatcher()
    private val testScope = TestCoroutineScope(testDispatcher)

    @Before
    fun createDb() {
        startKoin {
            androidContext(context)
            modules(userModule)
        }
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