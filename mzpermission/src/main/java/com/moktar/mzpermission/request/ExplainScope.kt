package com.moktar.mzpermission.request

import com.moktar.mzpermission.dialog.RationaleDialog
import com.moktar.mzpermission.dialog.RationaleDialogFragment

/**
 * Provide specific scopes for [com.moktar.mzpermission.callback.ExplainReasonCallback]
 * and [com.moktar.mzpermission.callback.ExplainReasonCallbackWithBeforeParam] to give it specific functions to call.
 * @author moktar
 * @since 2022/08/10
 */
class ExplainScope internal constructor(
    private val pb: PermissionBuilder,
    private val chainTask: ChainTask
) {
    /**
     * Show a rationale dialog to explain to user why you need these permissions.
     * @param permissions
     * Permissions that to request.
     * @param message
     * Message that show to user.
     * @param positiveText
     * Text on the positive button. When user click, MzPermission will request permissions again.
     * @param negativeText
     * Text on the negative button. When user click, MzPermission will finish request.
     */
    @JvmOverloads
    fun showRequestReasonDialog(
        permissions: List<String>,
        message: String,
        positiveText: String,
        negativeText: String? = null
    ) {
        pb.showHandlePermissionDialog(
            chainTask,
            true,
            permissions,
            message,
            positiveText,
            negativeText
        )
    }

    /**
     * Show a rationale dialog to explain to user why you need these permissions.
     * @param dialog
     * Dialog to explain to user why these permissions are necessary.
     */
    fun showRequestReasonDialog(dialog: RationaleDialog) {
        pb.showHandlePermissionDialog(chainTask, true, dialog)
    }

    /**
     * Show a rationale dialog to explain to user why you need these permissions.
     * @param dialogFragment
     * DialogFragment to explain to user why these permissions are necessary.
     */
    fun showRequestReasonDialog(dialogFragment: RationaleDialogFragment) {
        pb.showHandlePermissionDialog(chainTask, true, dialogFragment)
    }
}