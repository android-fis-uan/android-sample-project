package co.edu.uan.android.uancasts

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import co.edu.uan.android.uancasts.ui.HomeScreen
import co.edu.uan.android.uancasts.ui.PodcastScreen
import co.edu.uan.android.uancasts.ui.SearchScreen
import co.edu.uan.android.uancasts.ui.PodcastViewModel
import co.edu.uan.android.uancasts.ui.theme.UANCastsTheme

enum class UanCastsScreen(@StringRes val title: Int) {
    Home(title = R.string.title_home),
    Podcast(title = R.string.title_dashboard),
    Search(title = R.string.title_search)
}

data class NavigationItem(
    val title: String,
    val icon: ImageVector,
    val route: String
)

@Composable
fun BottomNavigationBar(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    val selectedNavigationIndex = rememberSaveable {
        mutableIntStateOf(0)
    }

    val navItems = listOf(
        NavigationItem(
            title = stringResource(UanCastsScreen.Home.title),
            icon = Icons.Filled.Home,
            route = UanCastsScreen.Home.name
        ),
        NavigationItem(
            title = stringResource(UanCastsScreen.Podcast.title),
            icon = Icons.AutoMirrored.Filled.List,
            route = UanCastsScreen.Podcast.name
        ),
        NavigationItem(
            title = stringResource(UanCastsScreen.Search.title),
            icon = Icons.Filled.Search,
            route = UanCastsScreen.Search.name
        )
    )

    NavigationBar(
        containerColor = Color.White
    ) {
        navItems.forEachIndexed { index, item ->
            NavigationBarItem(
                selected = selectedNavigationIndex.intValue == index,
                onClick = {
                    selectedNavigationIndex.intValue = index
                    navController.navigate(item.route)
                },
                icon = {
                    Icon(imageVector = item.icon, contentDescription = item.title)
                },
                label = {
                    Text(
                        item.title,
                        color = if (index == selectedNavigationIndex.intValue)
                            Color.Black
                        else Color.Gray
                    )
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = MaterialTheme.colorScheme.surface,
                    indicatorColor = MaterialTheme.colorScheme.primary
                )

            )
        }
    }
}

@Composable
fun UANCastsApp(
    viewmodel: PodcastViewModel = viewModel(),
    navController: NavHostController = rememberNavController()
) {

    // Get current back stack entry
    val backStackEntry by navController.currentBackStackEntryAsState()
    // Get the name of the current screen
    val currentScreen = UanCastsScreen.valueOf(
        backStackEntry?.destination?.route ?: UanCastsScreen.Home.name
    )

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            BottomNavigationBar(navController)
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = UanCastsScreen.Home.name,
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(innerPadding)
        ) {
            composable(route = UanCastsScreen.Home.name) {
                HomeScreen()
            }
            composable(route = UanCastsScreen.Podcast.name) {
                PodcastScreen()
            }
            composable(route = UanCastsScreen.Search.name) {
                SearchScreen()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun UANCastsAppPreview() {
    UANCastsTheme {
        UANCastsApp()
    }
}