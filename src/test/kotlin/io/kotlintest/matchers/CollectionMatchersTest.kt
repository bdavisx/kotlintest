package io.kotlintest.matchers

import io.kotlintest.TestFailedException
import io.kotlintest.specs.WordSpec
import java.util.*

class CollectionMatchersTest : WordSpec() {

  init {

    "CollectionMatchers.contain" should {
      "test that a collection contains an element"  {
        val col = listOf(1, 2, 3)

        col should contain element 2

        shouldThrow<TestFailedException> {
          col should contain element 4
        }
      }
    }

    "haveSize" should {
      "test that a collection has a certain size" {
        val col1 = listOf(1, 2, 3)
        col1 should haveSize(3)
        shouldThrow<TestFailedException> {
          col1 should haveSize(2)
        }

        val col2 = emptyList<String>()
        col2 should haveSize(0)
        shouldThrow<TestFailedException> {
          col2 should haveSize(1)
        }
      }
    }

    "CollectionMatchers.empty" should {
      "test that a collection contains an element"  {
        val col = listOf(1, 2, 3)

        shouldThrow<TestFailedException> {
          col should beEmpty()
        }

        ArrayList<String>() should beEmpty()
      }
    }

    "containInAnyOrder" should {
      "test that a collection contains all the elements but in any order" {
        val col = listOf(1, 2, 3, 4, 5)

        col should containInAnyOrder(1, 2, 3)
        col should containInAnyOrder(3, 2, 1)
        col should containInAnyOrder(5, 1)
        col should containInAnyOrder(1, 5)
        col should containInAnyOrder(1)
        col should containInAnyOrder(5)

        shouldThrow<TestFailedException> {
          col should containInAnyOrder(1, 2, 6)
        }

        shouldThrow<TestFailedException> {
          col should containInAnyOrder(6)
        }

        shouldThrow<TestFailedException> {
          col should containInAnyOrder(0, 1, 2)
        }

        shouldThrow<TestFailedException> {
          col should containInAnyOrder(3, 2, 0)
        }
      }
    }
  }
}