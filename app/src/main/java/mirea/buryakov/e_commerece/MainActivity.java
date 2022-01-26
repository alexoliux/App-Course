package mirea.buryakov.e_commerece;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import mirea.buryakov.e_commerece.adapter.CatagoryAdapter;
import mirea.buryakov.e_commerece.adapter.CourseAdapter;
import mirea.buryakov.e_commerece.model.Category;
import mirea.buryakov.e_commerece.model.Course;
import mirea.buryakov.e_commerece.model.Order;

public class MainActivity extends AppCompatActivity {

    RecyclerView categoryRecycler, courseRecycler;
    CatagoryAdapter catagoryAdapter;
    static CourseAdapter courseAdapter;
    static List<Course> courseList = new ArrayList<>();
    static List<Course> fullCourseList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Category> categoryList = new ArrayList<>();
        categoryList.add(new Category(1, "Игры"));
        categoryList.add(new Category(2, "Сайты"));
        categoryList.add(new Category(3, "Языки"));
        categoryList.add(new Category(4, "Прочее"));

        setCategoryRecycler(categoryList);


        courseList.add(new Course(1, "java", "Профессия Java\nразработчик", "1 янв", "начальный", "#424345", "Test", 3));
        courseList.add(new Course(2, "python", "Профессия python\nразработчик", "10 янв", "начальный", "#9FA52D", "Test", 1));

        fullCourseList.addAll(courseList);

        setCourseRecycler(courseList);
    }

    public void openShoppingCart(View view) {
        Intent intent = new Intent(this, OrderPage.class);
        startActivity(intent);
    }

    private void setCourseRecycler(List<Course> courseList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);

        courseRecycler = findViewById(R.id.courseRecycler);
        courseRecycler.setLayoutManager(layoutManager);

        courseAdapter = new CourseAdapter(this, courseList);
        courseRecycler.setAdapter(courseAdapter);
    }

    private void setCategoryRecycler(List<Category> categoryList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);

        categoryRecycler = findViewById(R.id.categoryRecycler);
        categoryRecycler.setLayoutManager(layoutManager);

        catagoryAdapter = new CatagoryAdapter(this, categoryList);
        categoryRecycler.setAdapter(catagoryAdapter);
    }

    @SuppressLint("NotifyDataSetChanged")
    public static void showCoursesByCategory(int category) {

        courseList.clear();
        courseList.addAll(fullCourseList);

        List<Course> filterCourses = new ArrayList<>();

        for (Course c : courseList) {
            if (c.getCategory() == category) {
                filterCourses.add(c);
            }
        }

        courseList.clear();
        courseList.addAll(filterCourses);

        courseAdapter.notifyDataSetChanged();
    }

}