package org.jesperancinha.arrow.books.resilience.circuit

import arrow.core.Either
import arrow.resilience.CircuitBreaker
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.time.Duration.Companion.seconds

class UrsusService {

    companion object {

        @JvmStatic
        fun main(args: Array<String>) = runBlocking {
            val circuitBreaker = CircuitBreaker(
                openingStrategy = CircuitBreaker.OpeningStrategy.Count(1),
                resetTimeout = 2.seconds,
                exponentialBackoffFactor = 2.0,
                maxResetTimeout = 60.seconds,
            )

            justSayingHello(circuitBreaker)

            doubtingOnYourExperience(circuitBreaker)
            doubtingOnYourExperience(circuitBreaker)

            val either = circuitBreaker
                .protectEither { println("I am trying to calm down. ARE YOU DOUBTING MY EXPERIENCE?!?!??!? ${circuitBreaker.state()}") }
            println(either.getOrNone())

            println("Me the Ursus is going to SLEEP! I need to calm down, but I HAVE TESTED EVERYTHING AND EVERYTHING WORKS! ${circuitBreaker.state()}")
            delay(2000)
            println("I AM TRYING TO CALM DOWN! ${circuitBreaker.state()}")
            doubtingOnYourExperience(circuitBreaker)
            delay(2000)
            delay(2000)
            println("I AM TRYING TO CALM DOWN! ${circuitBreaker.state()}")


            circuitBreaker.protectOrThrow {
                "I CANNOT SLEEP! But I can calm down. Or at least PRETEND TO!: ${circuitBreaker.state()}"
            }.also(::println)
            println("Finally you accept that I AM THE BEST! ${circuitBreaker.state()}")
        }

        private suspend fun doubtingOnYourExperience(circuitBreaker: CircuitBreaker) {
            Either.catch {
                circuitBreaker.protectOrThrow { throw RuntimeException("I have tested it, it works perfectly and I am an angry bear and my code IS THE BEST!") }
            }.also(::println)
        }

        private suspend fun justSayingHello(circuitBreaker: CircuitBreaker) {
            circuitBreaker.protectOrThrow { "Hi there, I am Ursus. Oh my God! are you saying that my code is the best? THANK YOU!: ${circuitBreaker.state()}" }
                .also(::println)
        }
    }
}
