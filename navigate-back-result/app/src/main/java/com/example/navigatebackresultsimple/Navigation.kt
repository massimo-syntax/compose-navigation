package com.example.navigatebackresultsimple

import androidx.compose.runtime.Composable
import androidx.compose.runtime.saveable.Saver
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.example.navigatebackresultsimple.ui.screens.FirstScreenReceiver
import com.example.navigatebackresultsimple.ui.screens.SecondScreenProducer
import kotlinx.serialization.Serializable


@Serializable
data object FirstRoute : NavKey

@Serializable
data object SecondRoute : NavKey

@Composable
fun Navigation(){

    val backStack = rememberNavBackStack(FirstRoute)
    val resultStore = rememberResultStore()

    NavDisplay(
        backStack = backStack,
        entryProvider = entryProvider {
            entry<FirstRoute> {
                val resultOfType1 = resultStore.getResult<DataTypeResult1?>()
                FirstScreenReceiver(
                    onNavigateToCreateResult = {
                        backStack.add(SecondRoute)
                    },
                    result = resultOfType1
                )
            }
            entry<SecondRoute> {
                SecondScreenProducer(
                    onSetResult = {
                        resultStore.setResult<DataTypeResult1>(result = it)
                    },
                    onNavigateBack = { backStack.removeLastOrNull() }
                )
            }
        }
    )

}

@Composable
private fun rememberResultStore() = rememberSaveable(
    saver = Saver(
        save = { it.resultMap },
        restore = { ResultStore().apply { resultMap.putAll(it)  } },
    )
) { ResultStore() }

data class DataTypeResult1(
    val data: String
)
data class DataTypeResult2(
    val data: String
)
class ResultStore {

    /**
     * Map from the result key to a mutable state of the result.
     */
    val resultMap: MutableMap<String, Any?> = mutableMapOf()

    /**
     * Retrieves the current result of the given resultKey.
     */
    inline fun <reified T> getResult(resultKey: String = T::class.toString()) =
        resultMap[resultKey] as? T

    /**
     * Sets the result for the given resultKey.
     */
    inline fun <reified T> setResult(resultKey: String = T::class.toString(), result: T) {
        resultMap[resultKey] = result
    }

    /**
     * Removes all results associated with the given key from the store.
     */
    inline fun <reified T> removeResult(resultKey: String = T::class.toString()) {
        resultMap.remove(resultKey)
    }
}