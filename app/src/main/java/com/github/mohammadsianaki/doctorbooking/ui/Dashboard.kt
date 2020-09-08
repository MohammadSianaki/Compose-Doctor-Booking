package com.github.mohammadsianaki.doctorbooking.ui

import androidx.compose.foundation.ScrollableColumn
import androidx.compose.foundation.Text
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.RowScope.gravity
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.TabConstants.defaultTabIndicatorOffset
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.ui.tooling.preview.Preview
import com.github.mohammadsianaki.doctorbooking.data.DataFactory
import com.github.mohammadsianaki.doctorbooking.ui.components.SectionTitle


@Composable
@Preview
fun DashboardContent(
    categories: List<String> = listOf("Adults", "Childrens", "Womens", "Mens"),
    specialities: List<Speciality> = DataFactory.getSpeciality(),
    doctors: List<DoctorModel> = DataFactory.getDoctors()
) {

    Scaffold(
        topBar = { AppBar() },
    ) { _ ->
        ScrollableColumn(
            modifier = Modifier.fillMaxSize(),
            horizontalGravity = Alignment.Start,
            verticalArrangement = Arrangement.Top
        ) {
            SearchSection()
            CategorySection(categories, specialities)
            DoctorsSection(doctors)
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
    SearchBox(Modifier.padding(16.dp))
}

@Composable
fun CategorySection(categories: List<String>, specialities: List<Speciality>) {
    SectionTitle(text = "Categories")
    DashboardCategoryTabs(categories = categories, "Adults")
    SpecialityList(specialities = specialities)

}


@Composable
fun DashboardCategoryTabs(categories: List<String>, selectedCategory: String) {
    val selectedIndex = categories.indexOfFirst { it == selectedCategory }
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
            Tab(selected = (index == 0), onClick = {}, text = {
                Text(text = category)
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
fun DoctorsSection(doctors: List<DoctorModel>) {
    SectionTitle(text = "Doctors")
    DoctorsList(doctors = doctors)
}

