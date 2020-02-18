# kotlin-memoize
A simple library used for memoizing a pure function with a single input value.

Example:
```kotlin
fun complexFunction(param: Any): Any {
    ...
}

val memoizedComplexFunction = ::complexFunction.memoize()

memoizedComplexFunction("Hello")
memoizedComplexFunction("Hello")
memoizedComplexFunction("World")
```

The second execution of `memoizedComplexFunction("Hello")` will not be executed and its value will be returned.

If you need to know what memoization is: https://en.wikipedia.org/wiki/Memoization