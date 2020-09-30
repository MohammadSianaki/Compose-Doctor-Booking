package com.github.mohammadsianaki.doctorbooking.ui.dashboard

import androidx.compose.foundation.ScrollableColumn
import androidx.compose.foundation.Text
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.RowScope.gravity
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.TabConstants.defaultTabIndicatorOffset
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.github.mohammadsianaki.doctorbooking.model.DoctorModel
import com.github.mohammadsianaki.doctorbooking.ui.Category
import com.github.mohammadsianaki.doctorbooking.ui.DashboardViewModel
import com.github.mohammadsianaki.doctorbooking.ui.components.AppBar
import com.github.mohammadsianaki.doctorbooking.ui.components.EmphasizedText
import com.github.mohammadsianaki.doctorbooking.ui.components.Search
import com.github.mohammadsianaki.doctorbooking.util.Screen

@Composable
fun HomeScreen(
    navigateTo: (Screen) -> Unit,
    dashboardViewModel: DashboardViewModel
) {
    val viewState by dashboardViewModel.viwState.collectAsState()
    Scaffold(
        topBar = { AppBar() },
    ) { _ ->
        ScrollableColumn(
            modifier = Modifier.fillMaxSize(),
            horizontalGravity = Alignment.Start,
            verticalArrangement = Arrangement.Top
        ) {
            SearchSection()
            CategorySection(
                viewState.categories,
                viewState.selectedCategory,
                dashboardViewModel::onCategorySelected
            )
            DoctorsSection(viewState.doctors, navigateTo)
        }
    }
}

@Composable
fun SearchSection() {
    ProvideEmphasis(emphasis = EmphasisAmbient.current.high) {
        Text(
            modifier = Modifier.padding(16.dp),
            text = "Find Your \nConsultation", style = TextStyle(
                color = Color(0xDD000000).copy(alpha = 0.8f),
                fontWeight = FontWeight.SemiBold,
                fontSize = 30.sp,
            )
        )
    }
    Search(query = TextFieldValue(""))
}

@Composable
fun CategorySection(
    categories: List<Category>,
    selectedCategory: Int,
    onCategorySelected: (index:Int) -> Unit
) {
    EmphasizedText(text = "Categories")
    DashboardCategoryTabs(categories = categories, selectedCategory, onCategorySelected)
    SpecialityList(specialityModels = categories[selectedCategory].specialists)
}


@Composable
fun DashboardCategoryTabs(
    categories: List<Category>,
    selectedIndex: Int,
    onCategorySelected: (index: Int) -> Unit
) {
    val indicator = @Composable { tabPositions: List<TabPosition> ->
        DashboardCategoryTabIndicator(
            Modifier.defaultTabIndicatorOffset(tabPositions[selectedIndex])
        )
    }

    TabRow(
        selectedTabIndex = 0,
        indicator = indicator,
        backgroundColor = Color.White
    ) {
        categories.forEachIndexed { index, category ->
            Tab(selected = (index == selectedIndex), onClick = { onCategorySelected(index) }, text = {
                Text(text = category.name)
            })
        }
    }
}

@Composable
fun DashboardCategoryTabIndicator(
    modifier: Modifier = Modifier,
    color: Color = MaterialTheme.colors.primary
) {
    Spacer(
        modifier = modifier.preferredWidth(112.dp)
            .preferredHeight(4.dp)
            .gravity(Alignment.CenterVertically)
            .background(color, RoundedCornerShape(topLeftPercent = 100, topRightPercent = 100))
    )
}

@Composable
fun DoctorsSection(doctors: List<DoctorModel>, navigateTo: (Screen) -> Unit) {
    EmphasizedText(text = "Doctors")
    DoctorsList(doctors = doctors, navigateTo)
}

