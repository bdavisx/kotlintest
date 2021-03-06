package io.kotlintest.matchers

import io.kotlintest.TestFailedException

interface StringMatchers {

  infix fun Have<String>.substring(substr: String): Unit {
    if (!value.contains(substr))
        throw TestFailedException("String does not have substring $substr")
    }

  infix fun Start<String>.with(prefix: String): Unit {
    if (!value.startsWith(prefix))
      throw TestFailedException("String does not start with $prefix but with ${value.take(prefix.length)}")
  }

  infix fun End<String>.with(suffix: String): Unit {
    if (!value.endsWith(suffix))
      throw TestFailedException("String does not end with $suffix but with ${value.takeLast(suffix.length)}")
    }

  fun match(regex: String): Matcher<String> = object : Matcher<String> {
    override fun test(value: String) {
      if (!value.matches(regex.toRegex()))
        throw TestFailedException("String $value does not match regex $regex")
    }
  }
}
