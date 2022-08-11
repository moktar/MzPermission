package com.example.mzpermission

import android.Manifest
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.mzpermission.databinding.FragmentFirstBinding
import com.moktar.mzpermission.MzPermission

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonFirst.setOnClickListener {
            MzPermission.init(this)
                .permissions(
                    Manifest.permission.CAMERA,
                    Manifest.permission.ACCESS_FINE_LOCATION,
                    Manifest.permission.RECORD_AUDIO,
//                    Manifest.permission.READ_CALENDAR,
//                    Manifest.permission.READ_CALL_LOG,
//                    Manifest.permission.READ_CONTACTS,
//                    Manifest.permission.READ_PHONE_STATE,
//                    Manifest.permission.BODY_SENSORS,
//                    Manifest.permission.ACTIVITY_RECOGNITION,
//                    Manifest.permission.SEND_SMS,
//                    Manifest.permission.READ_EXTERNAL_STORAGE
                )
                .setDialogTintColor(Color.parseColor("#1972e8"), Color.parseColor("#8ab6f5"))
                .onExplainRequestReason { scope, deniedList, _ ->
                    val message = "PermissionX needs following permissions to continue"
                    scope.showRequestReasonDialog(deniedList, message, "Allow", "Deny")
//                    val message = "Please allow the following permissions in settings"
//                    val dialog = CustomDialogFragment(message, deniedList)
//                    scope.showRequestReasonDialog(dialog)
                }
                .onForwardToSettings { scope, deniedList ->
                    val message = "Please allow following permissions in settings"
                    val dialog = CustomDialogFragment(message, deniedList)
                    scope.showForwardToSettingsDialog(dialog)
                }
                .request { allGranted, _, deniedList ->
                    if (allGranted) {
                        Toast.makeText(activity, "All permissions are granted", Toast.LENGTH_SHORT)
                            .show()
                    } else {
                        Toast.makeText(
                            activity,
                            "The following permissions are denied：$deniedList",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
//            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}