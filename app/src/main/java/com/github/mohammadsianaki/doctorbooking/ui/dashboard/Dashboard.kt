package com.github.mohammadsianaki.doctorbooking.ui.dashboard

import androidx.compose.foundation.ScrollableColumn
import androidx.compose.foundation.ScrollableRow
import androidx.compose.foundation.Text
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
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
import com.github.mohammadsianaki.doctorbooking.ui.theme.LightOrange
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
    onCategorySelected: (index: Int) -> Unit
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

    ScrollableRow(modifier = Modifier.preferredHeightIn(minHeight = 56.dp)) {
        Spacer(Modifier.preferredWidth(8.dp))
        categories.forEachIndexed { index, category ->
            FilterChip(
                filter = category,
                selected = selectedIndex == index,
                modifier = Modifier.gravity(Alignment.CenterVertically),
                onCategorySelected = onCategorySelected,
                index = index
            )
            Spacer(Modifier.preferredWidth(8.dp))
        }
    }
}

@Composable
fun FilterChip(
    filter: Category,
    modifier: Modifier = Modifier,
    selected: Boolean,
    onCategorySelected: (index: Int) -> Unit,
    index: Int
) {
    Surface(
        modifier = modifier
            .preferredHeight(28.dp)
            .clickable(onClick = { onCategorySelected(index) }, indication = null),
        color = if (selected) LightOrange else Color.Transparent,
        contentColor = if (selected) Color.White else Color.Black,
        shape = if (selected) RoundedCornerShape(15.dp) else RectangleShape
    ) {
        Text(
            text = filter.name,
            style = MaterialTheme.typography.caption,
            maxLines = 1,
            modifier = Modifier.padding(
                horizontal = 20.dp,
                vertical = 6.dp
            )
        )
    }
}

@Composable
fun DoctorsSection(doctors: List<DoctorModel>, navigateTo: (Screen) -> Unit) {
    EmphasizedText(text = "Doctors")
    DoctorsList(doctors = doctors, navigateTo)
}

