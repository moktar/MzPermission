package com.moktar.mzpermission.request

/**
 * Maintain the task chain of permission request process.
 * @author moktar
 * @since 2022/08/10
 */
class RequestChain {
    /**
     * Holds the first task of request process. Permissions request begins here.
     */
    private var headTask: BaseTask? = null

    /**
     * Holds the last task of request process. Permissions request ends here.
     */
    private var tailTask: BaseTask? = null

    /**
     * Add a task into task chain.
     * @param task  task to add.
     */
    internal fun addTaskToChain(task: BaseTask) {
        if (headTask == null) {
            headTask = task
        }
        // add task to the tail
        tailTask?.next = task
        tailTask = task
    }

    /**
     * Run this task chain from the first task.
     */
    internal fun runTask() {
        headTask?.request()
    }
}