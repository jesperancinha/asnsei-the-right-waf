package org.jesperancinha.arrow.books

import arrow.core.Either
import arrow.optics.Prism
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.nulls.shouldNotBeNull
import io.kotest.matchers.shouldBe
import org.jesperancinha.arrow.books.ImmutableData.Companion.happyBirthday
import org.jesperancinha.arrow.books.ImmutableData.Companion.realHappyBirthDay
import org.junit.jupiter.api.Test


sealed class Account {
    data class CheckingAccount(val balance: Double) : Account()
    data class SavingsAccount(val balance: Double, val interestRate: Double) : Account()
}

class ImmutableDataTest {

    @Test
    fun `should process address data`() {
        val address = Address(Street("Indigarr Street", 1), City("Thanos place", "Indigarr"))
        val me = Person(
            "Rocket Raccoon", Age(19),
            address
        )

        Person.name.get(me) shouldBe "Rocket Raccoon"
        Person.address.get(me) shouldBe address

        val raccoonOneYearOlder = Person.age.age.modify(me) { it + 1 }
        Person.age.age.get(raccoonOneYearOlder) shouldBe 20

        val newAddress = Address(Street("Groot Street", null), City("Thanos place", "Indigarr"))
        val meAfterMoving = Person.address.set(me, newAddress)
        Person.address.get(meAfterMoving) shouldBe newAddress
    }

    @Test
    fun `should create a good prism`() {
        val x = Prism.left<Int, String>().reverseGet(5)
        x shouldBe Either.Left(5)
        x.getOrNull() shouldBe null
        x.swap().getOrNull() shouldBe 5
    }

    @Test
    fun `should create a happy birthday prism`() {
        val p = Person(
            name = "me",
            age = Age(29),
            address = Address(
                street = Street("Groot Street", null),
                city = City("Thanos place", "Indigarr")
            )
        )
        val newPerson1 = p.happyBirthday()
        newPerson1.age.age shouldBe 30
        val newPerson2 = p.realHappyBirthDay()
        newPerson2.age.age shouldBe 30
        val listUsers = listOf(p)
        val userPrism: Prism<User, Person> = Prism(
            getOrModify = { person ->
                when (person) {
                    is Person -> Either.Right(person)
                    else -> Either.Left(person)
                }
            },
            reverseGet = { user -> user }
        )
        val source = listUsers.happyBirthday().shouldHaveSize(1).first()
        val person3 = userPrism.getOrModify(source)
            .getOrNull()
        person3?.age?.age shouldBe 30
    }

    @Test
    fun `should create a prism and use it later`() {
        val checkingAccountPrism: Prism<Account, Account.CheckingAccount> = Prism(
            getOrModify = { account ->
                when (account) {
                    is Account.CheckingAccount -> Either.Right(account)
                    else -> Either.Left(account)
                }
            },
            reverseGet = { checkingAccount -> checkingAccount }
        )
        val account: Account = Account.CheckingAccount(balance = 100.0)
        val checking = checkingAccountPrism.getOrModify(account)
        checking.getOrNull().shouldNotBeNull().balance shouldBe 100.0
        val updatedAccount = checkingAccountPrism.modify(account) { it.copy(balance = 200.0) }
        checkingAccountPrism.getOrModify(updatedAccount).getOrNull()
            .shouldNotBeNull().balance shouldBe 200.0

    }
}