package com.example.android.architecture.blueprints.todoapp.statistics

import com.example.android.architecture.blueprints.todoapp.data.Task
import org.junit.Assert.*
import org.junit.Test

class StatisticsUtilsTest {

    @Test
    fun getActiveAndCompletedStats_noCompleted_returnsHundredZero() {

        // Create an active tasks (the false makes this active)
        val tasks = listOf<Task>(
                Task("title", "desc", isCompleted = false)
        )
        // Call our function
        val result = getActiveAndCompletedStats(tasks)

        // Check the result
        assertEquals(result.completedTasksPercent, 0f)
        assertEquals(result.activeTasksPercent, 100f)
    }

    //If there is one completed task and no active tasks,
    //the activeTasks percentage should be 0f, the completed tasks percentage should be 100f.
    @Test
    fun getActiveAndCompletedStats_completed_returnsZeroHundred() {

        // Create an active tasks (the false makes this active)
        val tasks = listOf<Task>(
                Task("title", "desc", isCompleted = true)
        )
        // Call our function
        val result = getActiveAndCompletedStats(tasks)

        // Check the result
        assertEquals(result.completedTasksPercent, 100f)
        assertEquals(result.activeTasksPercent, 0f)
    }

    //If there are two completed tests and three active test, the completed percentage should be
    //40f and the active percentage should be 60f.
    @Test
    fun getActiveAndCompletedStats_both_returnsFortySixty() {

        // Create an active tasks (the false makes this active)
        val tasks = listOf<Task>(
                Task("title", "desc", isCompleted = true),
                Task("title", "desc", isCompleted = true),
                Task("title", "desc", isCompleted = false),
                Task("title", "desc", isCompleted = false),
                Task("title", "desc", isCompleted = false)
        )
        // Call our function
        val result = getActiveAndCompletedStats(tasks)

        // Check the result
        assertEquals(result.completedTasksPercent, 40f)
        assertEquals(result.activeTasksPercent, 60f)
    }
}