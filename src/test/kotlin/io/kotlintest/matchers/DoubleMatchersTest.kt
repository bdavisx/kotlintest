package io.kotlintest.matchers

import io.kotlintest.TestFailedException
import io.kotlintest.specs.ShouldSpec

class DoubleMatchersTest : ShouldSpec() {
  init {
    with("qweqwe") {
      length
    }
    should("fail outside of tolerance") {
      shouldThrow<TestFailedException> {
        1.0 shouldBe (1.3 plusOrMinus 0.2)
      }
    }
    should("match within tolerance") {
      1.0 shouldBe (1.1 plusOrMinus 0.2)
    }
    should("match exactly without tolerance") {
      1.0 shouldBe 1.0
    }
  }
}