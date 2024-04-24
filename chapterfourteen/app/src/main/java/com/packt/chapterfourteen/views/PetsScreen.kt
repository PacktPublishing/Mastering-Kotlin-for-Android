package com.packt.chapterfourteen.views

import android.Manifest
import android.widget.Toast
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.packt.chapterfourteen.data.Cat
import com.packt.chapterfourteen.data.PermissionAction
import com.packt.chapterfourteen.navigation.ContentType
import com.packt.chapterfourteen.viewmodel.PetsViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun PetsScreen(
    onPetClicked: (Cat) -> Unit,
    contentType: ContentType
) {
    val petsViewModel: PetsViewModel = koinViewModel()
    val petsUIState by petsViewModel.petsUIState.collectAsStateWithLifecycle()

    val context = LocalContext.current
    var showContent by rememberSaveable { mutableStateOf(false) }

    PermissionDialog(
        context = context,
        permission = Manifest.permission.ACCESS_COARSE_LOCATION
    ) { permissionAction ->
        when (permissionAction) {
            is PermissionAction.PermissionDenied -> {
                showContent = false
            }

            is PermissionAction.PermissionGranted -> {
                showContent = true
                Toast.makeText(
                    context,
                    "Location permission granted!",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
    if (showContent) {
        PetsScreenContent(
            modifier = Modifier
                .fillMaxSize(),
            onPetClicked = onPetClicked,
            contentType = contentType,
            petsUIState = petsUIState,
            onFavoriteClicked = {
                petsViewModel.updatePet(it)
            }
        )
    }
}
