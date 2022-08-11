package com.example.mzpermission

import android.Manifest
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.mzpermission.databinding.ActivityKotlinMainBinding
import com.moktar.mzpermission.MzPermission

class MainKotlinActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityKotlinMainBinding.inflate(layoutInflater);
        setContentView(binding.root)

        binding.makeRequestBtn.setOnClickListener {
            MzPermission.init(this@MainKotlinActivity)
                .permissions(Manifest.permission.WRITE_EXTERNAL_STORAGE)
                .explainReasonBeforeRequest()
                .onExplainRequestReason { scope, deniedList, _ ->
//                    val customDialog = CustomDialog(this@MainKotlinActivity,
//                        "MZPermission needs following permissions to continue", deniedList);
//                    scope.showRequestReasonDialog(customDialog);
                    scope.showRequestReasonDialog(
                        deniedList,
                        "PermissionX needs following permissions to continue",
                        "Allow"
                    )
                }
                .onForwardToSettings { scope, deniedList ->
                    scope.showForwardToSettingsDialog(
                        deniedList,
                        "Please allow following permissions in settings",
                        "Allow"
                    )
                }
                .request { allGranted, _, deniedList ->
                    if (allGranted) {
                        Toast.makeText(
                            this@MainKotlinActivity,
                            "All permissions are granted",
                            Toast.LENGTH_SHORT
                        ).show()
                    } else {
                        Toast.makeText(
                            this@MainKotlinActivity,
                            "The following permissions are denied：$deniedList",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
        }
    }
}