package com.sangeet.kotlindistablecoroutine.di

/**
 * @author sangeet.suresh on 27/10/18
 */
interface ComponentProvider<T> {
    val component: T
}

fun <T, U> ComponentProvider<T>.inject(block: T.() -> U) = lazy {
    block(component)
}