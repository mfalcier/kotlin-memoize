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

Gradle Dependency:
```
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}

dependencies {
    implementation 'com.github.mfalcier:kotlin-memoize:1.0.0'
}
```

Maven Dependency:
```xml
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>

<dependency>
    <groupId>com.github.mfalcier</groupId>
    <artifactId>kotlin-memoize</artifactId>
    <version>1.0.0</version>
</dependency>
```