package com.moktar.mzpermission.request

import com.moktar.mzpermission.dialog.RationaleDialog
import com.moktar.mzpermission.dialog.RationaleDialogFragment

/**
 * Provide specific scopes for [com.moktar.mzpermission.callback.ForwardToSettingsCallback]
 * to give it specific functions to call.
 * @author moktar
 * @since 2022/08/10
 */
class ForwardScope internal constructor(
    private val pb: PermissionBuilder,
    private val chainTask: ChainTask
) {
    /**
     * Show a rationale dialog to tell user to allow these permissions in settings.
     * @param permissions
     * Permissions that to request.
     * @param message
     * Message that show to user.
     * @param positiveText
     * Text on the positive button. When user click, MzPermission will forward to settings page of your app.
     * @param negativeText
     * Text on the negative button. When user click, MzPermission will finish request.
     */
    @JvmOverloads
    fun showForwardToSettingsDialog(
        permissions: List<String>,
        message: String,
        positiveText: String,
        negativeText: String? = null
    ) {
        pb.showHandlePermissionDialog(
            chainTask,
            false,
            permissions,
            message,
            positiveText,
            negativeText
        )
    }

    /**
     * Show a rationale dialog to tell user to allow these permissions in settings.
     * @param dialog
     * Dialog to explain to user why these permissions are necessary.
     */
    fun showForwardToSettingsDialog(dialog: RationaleDialog) {
        pb.showHandlePermissionDialog(chainTask, false, dialog)
    }

    /**
     * Show a rationale dialog to tell user to allow these permissions in settings.
     * @param dialogFragment
     * DialogFragment to explain to user why these permissions are necessary.
     */
    fun showForwardToSettingsDialog(dialogFragment: RationaleDialogFragment) {
        pb.showHandlePermissionDialog(chainTask, false, dialogFragment)
    }
}