package com.mfalcier.memoize

import org.junit.Assert.assertEquals
import org.junit.Test
import java.util.concurrent.atomic.AtomicInteger

class MemoizeTest {

    private val counter = AtomicInteger(0)

    data class FillMe (
        val field: String?
    )

    private fun addSemicolon(param: String): String = "$param;".also { counter.incrementAndGet() }
    private fun fillField(param: FillMe): FillMe = FillMe("test").also { counter.incrementAndGet() }

    private val memoizedConcatIt = ::addSemicolon.memoize()
    private val memoizedFillField = ::fillField.memoize()

    // String

    @Test
    fun concatItShouldWork() {
        assertEquals("One;", addSemicolon("One"))
        assertEquals("Two;", addSemicolon("Two"))
        assertEquals("Two;", addSemicolon("Two"))
        assertEquals(3, counter.get())
    }

    @Test
    fun memoizedConcatItShouldMemoize() {
        assertEquals("One;", memoizedConcatIt("One"))
        assertEquals("Two;", memoizedConcatIt("Two"))
        assertEquals("Two;", memoizedConcatIt("Two"))
        assertEquals(2, counter.get())
    }

    // Custom Data Class

    @Test
    fun fillFieldShouldWork() {
        assertEquals(FillMe("test"), fillField(FillMe("one")))
        assertEquals(FillMe("test"), fillField(FillMe("two")))
        assertEquals(FillMe("test"), fillField(FillMe("two")))
        assertEquals(3, counter.get())
    }

    @Test
    fun memoizedFillFieldShouldMemoize() {
        assertEquals(FillMe("test"), memoizedFillField(FillMe("one")))
        assertEquals(FillMe("test"), memoizedFillField(FillMe("two")))
        assertEquals(FillMe("test"), memoizedFillField(FillMe("two")))
        assertEquals(2, counter.get())
    }
}