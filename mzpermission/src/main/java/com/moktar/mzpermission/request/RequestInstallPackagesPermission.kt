package com.moktar.mzpermission.request

import android.Manifest
import android.os.Build

/**
 * Implementation for request android.permission.REQUEST_INSTALL_PACKAGES.
 *
 * @author moktar
 * @since 2022/08/10
 */
internal class RequestInstallPackagesPermission internal constructor(permissionBuilder: PermissionBuilder) :
    BaseTask(permissionBuilder) {

    override fun request() {
        if (pb.shouldRequestInstallPackagesPermission()
            && Build.VERSION.SDK_INT >= Build.VERSION_CODES.O
            && pb.targetSdkVersion >= Build.VERSION_CODES.O) {
            if (pb.activity.packageManager.canRequestPackageInstalls()) {
                // REQUEST_INSTALL_PACKAGES permission has already granted, we can finish this task now.
                finish()
                return
            }
            if (pb.explainReasonCallback != null || pb.explainReasonCallbackWithBeforeParam != null) {
                val requestList = mutableListOf(Manifest.permission.REQUEST_INSTALL_PACKAGES)
                if (pb.explainReasonCallbackWithBeforeParam != null) {
                    // callback ExplainReasonCallbackWithBeforeParam prior to ExplainReasonCallback
                    pb.explainReasonCallbackWithBeforeParam!!.onExplainReason(explainScope, requestList, true)
                } else {
                    pb.explainReasonCallback!!.onExplainReason(explainScope, requestList)
                }
            } else {
                // No implementation of explainReasonCallback, we can't request
                // REQUEST_INSTALL_PACKAGES permission at this time, because user won't understand why.
                finish()
            }
        } else {
            // shouldn't request REQUEST_INSTALL_PACKAGES permission at this time, so we call finish() to finish this task.
            finish()
        }
    }

    override fun requestAgain(permissions: List<String>) {
        // don't care what the permissions param is, always request REQUEST_INSTALL_PACKAGES permission.
        pb.requestInstallPackagePermissionNow(this)
    }

    companion object {
        /**
         * Define the const to compat with system lower than M.
         */
        const val REQUEST_INSTALL_PACKAGES = "android.permission.REQUEST_INSTALL_PACKAGES"
    }
}